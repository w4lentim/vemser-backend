package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.vemser.pessoaapi.dto.PessoaDTO;
import br.com.vemser.pessoaapi.entity.EnderecoEntity;
import br.com.vemser.pessoaapi.entity.PessoaEntity;
import br.com.vemser.pessoaapi.enums.TipoDeMensagem;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.EnderecoRepository;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@Slf4j
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private PessoaService pessoaService;
    @Autowired
    private EmailService emailService;
    @Autowired
    private ObjectMapper objectMapper;

    public List<EnderecoDTO> list() {
        log.info("Listando todos os endereços...");
        return enderecoRepository.findAll().stream()
                .map(this::convertToDTO)
                .toList();
    }

    public EnderecoDTO findEnderecoByIdEndereco(Integer idEndereco) throws RegraDeNegocioException {
        log.info("Listando endereço pelo idEndereço...");
        return convertToDTO(enderecoRepository.findById(idEndereco)
                .orElseThrow(() -> new RegraDeNegocioException("O endereço não está cadastrado em nosso banco de dados.")));
    }

    public List<EnderecoDTO> listEnderecoByIdPessoa(Integer idPessoa) {
        return pessoaService.listPessoaAndEndereco(idPessoa)
                .get(0)
                .getEnderecoDTO();
    }

    public EnderecoDTO create(Integer idPessoa, EnderecoCreateDTO enderecoCreateDTO) throws RegraDeNegocioException {
        log.info("Adicionando endereço...");

        PessoaEntity pessoaEntity = pessoaService.findByIdPessoa(idPessoa);
        EnderecoEntity enderecoEntity = convertToEntity(enderecoCreateDTO);
        enderecoEntity.setPessoaEntitySet(Set.of(pessoaEntity));
        EnderecoDTO enderecoDTO = convertToDTO(enderecoRepository.save(enderecoEntity));

        String tipo = TipoDeMensagem.CREATE.getTipo();
        emailService.sendEmailEndereco(pessoaService.pessoaEntityToDTO(pessoaEntity), enderecoDTO, tipo);

        log.info("Endereço adicionado com sucesso!");
        return enderecoDTO;
    }

    public EnderecoDTO update(Integer idEndereco, EnderecoCreateDTO enderecoAtualizar) throws RegraDeNegocioException {
        log.info("Atualizando endereço...");

        EnderecoEntity enderecoRecuperado = enderecoRepository.findById(idEndereco)
                .orElseThrow(() -> new RegraDeNegocioException("Endereço não encontrado."));

        EnderecoEntity enderecoEntity = convertToEntity(enderecoAtualizar);
        enderecoEntity.setIdEndereco(idEndereco);
        enderecoEntity.setPessoaEntitySet(enderecoRecuperado.getPessoaEntitySet());

        EnderecoDTO enderecoDTO = convertToDTO(enderecoRepository.save(enderecoEntity));

        log.info("Endereço atualizado com sucesso!");
        return enderecoDTO;
    }

    public void delete(Integer idEndereco) throws RegraDeNegocioException {
        log.info("Deletando endereço...");

        enderecoRepository.delete(convertToEntity(findEnderecoByIdEndereco(idEndereco)));

        log.info("Endereço deletado com sucesso!");
    }

    public EnderecoEntity convertToEntity(EnderecoCreateDTO enderecoCreateDTO) {
        return objectMapper.convertValue(enderecoCreateDTO, EnderecoEntity.class);
    }

    public EnderecoDTO convertToDTO(EnderecoEntity enderecoEntity) {
        return objectMapper.convertValue(enderecoEntity, EnderecoDTO.class);
    }
}
