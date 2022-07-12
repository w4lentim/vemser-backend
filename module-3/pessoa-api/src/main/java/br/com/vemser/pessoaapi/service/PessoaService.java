package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.vemser.pessoaapi.dto.PessoaDTO;
import br.com.vemser.pessoaapi.entity.Pessoa;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        return pessoaRepository.list().stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .collect(Collectors.toList());
    }

    public List<PessoaDTO> listByName(String nome) {
        List<PessoaDTO> pessoasDTO = new ArrayList<>();
        List<Pessoa> pessoasEntity = pessoaRepository.list().stream()
                .filter(pessoa -> pessoa.getNome().equals(nome)).toList();
        for (Pessoa pessoa : pessoasEntity) {
            pessoasDTO.add(objectMapper.convertValue(pessoa, PessoaDTO.class));
        }
        return pessoasDTO;
    }

    public PessoaDTO create(PessoaCreateDTO pessoa) throws RegraDeNegocioException {
        log.info("Criando pessoa...");
        // --- ENTRADA ---
        Pessoa pessoaEntity = objectMapper.convertValue(pessoa, Pessoa.class);
        Pessoa pessoaCriada = pessoaRepository.create(pessoaEntity);
        // --- RETORNO ---
        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaCriada, PessoaDTO.class);
        log.info("Pessoa " + pessoaDTO.getNome() + " criada com sucesso!");
        return pessoaDTO;
    }

    public PessoaDTO update(Integer idPessoa, PessoaCreateDTO pessoaAtualizar) throws RegraDeNegocioException {
        log.info("Atualizando pessoa...");
        // --- ENTRADA ---
        Pessoa pessoaEntity = objectMapper.convertValue(pessoaAtualizar, Pessoa.class);
        Pessoa pessoaAtualizada = pessoaRepository.update(verifyByIdPessoa(idPessoa), pessoaEntity);
        // --- RETORNO ---
        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaAtualizada, PessoaDTO.class);
        log.info("Dados atualizados da pessoa: " + pessoaAtualizada);
        return pessoaDTO;
    }

    public void delete(Integer idPessoa) throws RegraDeNegocioException {
        log.info("Deletando pessoa...");
        Pessoa pessoaDeletada = verifyByIdPessoa(idPessoa);
        pessoaRepository.delete(pessoaDeletada);
        log.info("Pessoa " + pessoaDeletada.getNome() + " deletada com sucesso!");
    }

    public Pessoa verifyByIdPessoa(Integer idPessoa) throws RegraDeNegocioException {
        return pessoaRepository.list().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(idPessoa))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Não foi encontrado nenhuma pessoa associada ao ID."));
    }
}
