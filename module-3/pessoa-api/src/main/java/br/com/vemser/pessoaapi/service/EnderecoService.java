package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.vemser.pessoaapi.entity.Endereco;
import br.com.vemser.pessoaapi.entity.Pessoa;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.EnderecoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        return enderecoRepository.list().stream()
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                .collect(Collectors.toList());
    }

    public EnderecoDTO create(Integer idPessoa, EnderecoCreateDTO endereco) throws RegraDeNegocioException {
        Pessoa pessoa = pessoaService.verifyByIdPessoa(idPessoa);
        log.info("Criando um endereço para a pessoa: " + pessoa.getNome());
        endereco.setIdPessoa(idPessoa);
        Endereco enderecoEntity = objectMapper.convertValue(endereco, Endereco.class);
        Endereco enderecoCriado = enderecoRepository.create(enderecoEntity);
        EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoCriado, EnderecoDTO.class);
        log.info("Endereço adicionado com sucesso!");
        return enderecoDTO;
    }

    public EnderecoDTO update(Integer idEndereco, EnderecoCreateDTO enderecoAtualizar) throws RegraDeNegocioException {
        Pessoa pessoa = pessoaService.verifyByIdPessoa((enderecoAtualizar.getIdPessoa()));
        log.info("Atualizando endereço...");
        Endereco enderecoEntity = objectMapper.convertValue(enderecoAtualizar, Endereco.class);
        Endereco enderecoAtualizado = enderecoRepository.update(verifyEnderecoById(idEndereco), enderecoEntity);
        EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoAtualizado, EnderecoDTO.class);
        log.info("Endereco atualizado com sucesso!");
        return enderecoDTO;
    }

    public void delete(Integer idEndereco) throws RegraDeNegocioException {
        log.info("Deletando endereço...");
        enderecoRepository.delete(verifyEnderecoById(idEndereco));
        log.info("Endereço deletado com sucesso!");
    }

    public Endereco verifyEnderecoById(Integer idEndereco) throws RegraDeNegocioException {
        return enderecoRepository.list().stream()
                .filter(endereco -> endereco.getIdEndereco().equals(idEndereco))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Não foi possível encontrar nenhum endereço associado ao ID."));
    }

    public List<EnderecoDTO> listEnderecoByIdPessoa(Integer idPessoa) throws RegraDeNegocioException {
//        return enderecoRepository.list().stream()
//                .filter(endereco -> endereco.getIdPessoa().equals(idPessoa))
//                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
//                .collect(Collectors.toList());
        List<EnderecoDTO> enderecosDTO = new ArrayList<>();
        List<Endereco> enderecos = enderecoRepository.list().stream()
                .filter(endereco -> endereco.getIdPessoa().equals(idPessoa)).toList();
        for (Endereco endereco : enderecos) {
            enderecosDTO.add(objectMapper.convertValue(endereco, EnderecoDTO.class));
        }
        return enderecosDTO;
    }

    public EnderecoDTO listEnderecoByIdEndereco(Integer idEndereco) throws RegraDeNegocioException {
        Endereco enderecoEntity = verifyEnderecoById(idEndereco);
        return objectMapper.convertValue(enderecoEntity, EnderecoDTO.class);
    }
}
