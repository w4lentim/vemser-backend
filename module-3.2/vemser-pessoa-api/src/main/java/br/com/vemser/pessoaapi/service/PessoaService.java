package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dto.*;
import br.com.vemser.pessoaapi.entity.ContatoEntity;
import br.com.vemser.pessoaapi.entity.EnderecoEntity;
import br.com.vemser.pessoaapi.entity.PessoaEntity;
import br.com.vemser.pessoaapi.entity.PetEntity;
import br.com.vemser.pessoaapi.enums.TipoDeMensagem;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.PessoaRepository;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private EmailService emailService;
    @Autowired
    private ObjectMapper objectMapper;

    public List<PessoaDTO> list() {
        return pessoaRepository.findAll()
                .stream()
                .map(this::pessoaEntityToDTO).toList();
    }

    public List<PessoaDTO> findByNome(String nome) {
        return pessoaRepository.findAll()
                .stream()
                .filter(pessoa -> pessoa.getNome().toLowerCase().contains(nome.toLowerCase()))
                .toList()
                .stream()
                .map(this::pessoaEntityToDTO)
                .toList();
    }

    public List<PessoaDTO> listPessoaAndEndereco(Integer idPessoa) {
        if (idPessoa == null) {
            return pessoaRepository.findAll().stream()
                    .map(pessoaEntity -> {
                        PessoaDTO pessoaDTO = pessoaEntityToDTO(pessoaEntity);
                        pessoaDTO.setEnderecoDTOList(pessoaEntity.getEnderecoEntitySets().stream()
                                .map(this::enderecoEntityToDTO)
                                .toList());
                        return pessoaDTO;
                    }).toList();
        } else {
            return pessoaRepository.findById(idPessoa)
                    .map(pessoaEntity -> {
                        PessoaDTO pessoaDTO = pessoaEntityToDTO(pessoaEntity);
                        pessoaDTO.setEnderecoDTOList(pessoaEntity.getEnderecoEntitySets().stream()
                                .map(this::enderecoEntityToDTO).toList());
                        return pessoaDTO;
                    }).stream().toList();
        }
    }

    public List<PessoaDTO> listPessoaAndContato(Integer idPessoa) {
        if (idPessoa == null) {
            return pessoaRepository.findAll().stream()
                    .map(pessoaEntity -> {
                        PessoaDTO pessoaDTO = pessoaEntityToDTO(pessoaEntity);
                        pessoaDTO.setContatoDTOList(pessoaEntity.getContatoEntitySets().stream()
                                .map(this::contatoEntityToDTO).toList());
                        return pessoaDTO;
                    }).toList();
        } else {
            return pessoaRepository.findById(idPessoa)
                    .map(pessoaEntity -> {
                        PessoaDTO pessoaDTO = pessoaEntityToDTO(pessoaEntity);
                        pessoaDTO.setContatoDTOList(pessoaEntity.getContatoEntitySets().stream()
                                .map(this::contatoEntityToDTO).toList());
                        return pessoaDTO;
                    }).stream().toList();
        }
    }

    public List<PessoaDTO> listPessoaAndPets(Integer idPessoa) {
        if (idPessoa == null) {
            return pessoaRepository.findAll().stream()
                    .map(pessoaEntity -> {
                        PessoaDTO pessoaDTO = pessoaEntityToDTO(pessoaEntity);
                        pessoaDTO.setPetDTO(petEntityToDTO(pessoaEntity.getPetEntity()));
                        return pessoaDTO;
                    }).toList();
        } else {
            return pessoaRepository.findById(idPessoa)
                    .map(pessoaEntity -> {
                        PessoaDTO pessoaDTO = pessoaEntityToDTO(pessoaEntity);
                        pessoaDTO.setPetDTO(petEntityToDTO(pessoaEntity.getPetEntity()));
                        return pessoaDTO;
                    }).stream().toList();
        }
    }

    public List<PessoaDTO> listContainsNome(String nome) {
        return pessoaRepository.findAllByNomeContainsIgnoreCase(nome).stream()
                .map(this::pessoaEntityToDTO)
                .toList();
    }

    public PessoaDTO listByCpf(String cpf) {
        return pessoaEntityToDTO(pessoaRepository.findByCpf(cpf));
    }

    public PessoaEntity findByIdPessoa(Integer idPessoa) throws RegraDeNegocioException {
        return pessoaRepository.findById(idPessoa)
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada no Banco de Dados."));
    }

    public PessoaDTO create(PessoaCreateDTO pessoaCreateDTO) throws RegraDeNegocioException {
        log.info("Criando pessoa...");
        PessoaDTO pessoaDTO = pessoaEntityToDTO(pessoaRepository.save(pessoaDTOToEntity(pessoaCreateDTO)));
        log.info("Pessoa " + pessoaDTO.getNome() + " criada com sucesso!");
        return pessoaDTO;
    }

    public PessoaDTO update(Integer idPessoa, PessoaCreateDTO pessoaAtualizar) throws RegraDeNegocioException {
        log.info("Atualizando pessoa...");
        PessoaEntity pessoaEntity = findByIdPessoa(idPessoa);

        pessoaEntity.setNome(pessoaAtualizar.getNome());
        pessoaEntity.setDataNascimento(pessoaAtualizar.getDataNascimento());
        pessoaEntity.setCpf(pessoaAtualizar.getCpf());
        pessoaEntity.setEmail(pessoaAtualizar.getEmail());

        PessoaDTO pessoaDTO = pessoaEntityToDTO(pessoaRepository.save(pessoaEntity));

        String tipo = TipoDeMensagem.UPDATE.getTipo();
        emailService.sendEmailPessoa(pessoaDTO, tipo);
        log.info("Os dados de " + pessoaDTO.getNome() + " foram atualizados com sucesso!");
        return pessoaDTO;
    }

    public void delete(Integer idPessoa) throws RegraDeNegocioException {
        log.info("Removendo pessoa...");

        PessoaEntity pessoaVerify = findByIdPessoa(idPessoa);
        pessoaRepository.delete(pessoaVerify);

        log.info("A Pessoa " + pessoaVerify.getNome() + " foi removida com sucesso!");

        PessoaDTO pessoaDTO = pessoaEntityToDTO(pessoaVerify);
        String tipo = TipoDeMensagem.DELETE.getTipo();
        emailService.sendEmailPessoa(pessoaDTO, tipo);
    }

    public PessoaEntity pessoaDTOToEntity(PessoaCreateDTO pessoaCreateDTO) {
        return objectMapper.convertValue(pessoaCreateDTO, PessoaEntity.class);
    }

    public PessoaDTO pessoaEntityToDTO(PessoaEntity pessoaEntity) {
        return objectMapper.convertValue(pessoaEntity, PessoaDTO.class);
    }

    public EnderecoDTO enderecoEntityToDTO(EnderecoEntity enderecoEntity) {
        return objectMapper.convertValue(enderecoEntity, EnderecoDTO.class);
    }

    public ContatoDTO contatoEntityToDTO(ContatoEntity contatoEntity) {
        return objectMapper.convertValue(contatoEntity, ContatoDTO.class);
    }

    public PetDTO petEntityToDTO(PetEntity petEntity) {
        return objectMapper.convertValue(petEntity, PetDTO.class);
    }
}
