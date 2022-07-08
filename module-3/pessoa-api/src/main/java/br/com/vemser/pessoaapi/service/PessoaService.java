package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.entity.Pessoa;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;

    public List<Pessoa> list() {
        return pessoaRepository.list();
    }

    public List<Pessoa> listByName(String nome) {
        return pessoaRepository.listByName(nome);
    }

    public Pessoa create(Pessoa pessoa) throws RegraDeNegocioException {
        return pessoaRepository.create(pessoa);
    }

    public Pessoa update(Integer idPessoa, Pessoa pessoaAtualizar) throws RegraDeNegocioException {
        return pessoaRepository.update(verifyByIdPessoa(idPessoa), pessoaAtualizar);
    }

    public void delete(Integer idPessoa) throws Exception {
        pessoaRepository.delete(verifyByIdPessoa(idPessoa));
    }

    public Pessoa verifyByIdPessoa(Integer idPessoa) throws RegraDeNegocioException {
        return list().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(idPessoa))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Não foi encontrado nenhuma pessoa associada ao ID."));
    }

    public Pessoa listPessoaByIdPessoa(Integer idPessoa) throws RegraDeNegocioException {
        return list().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(idPessoa))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Não foi encontrado uma pessoa associada ao ID."));
    }
}
