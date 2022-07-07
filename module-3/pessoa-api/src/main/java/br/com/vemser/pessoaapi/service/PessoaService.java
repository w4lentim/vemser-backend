package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.entity.Pessoa;
import br.com.vemser.pessoaapi.repository.PessoaRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;

    public boolean verify(Pessoa pessoa) throws Exception {
        if (pessoa.getCpf().length() != 11 && (StringUtils.isBlank(pessoa.getNome()))
        && StringUtils.isEmpty(pessoa.getDataNascimento().toString())
        && StringUtils.isEmpty(pessoa.getCpf())) {
            return false;
        } else {
            throw new Exception("Os dados informados estão incorretos!");
        }
    }

    public Pessoa create(Pessoa pessoa) throws Exception {
        verify(pessoa);
        return pessoaRepository.create(pessoa);
    }

    public List<Pessoa> list() {
        return pessoaRepository.list();
    }

    public Pessoa update(Integer id, Pessoa pessoaAtualizar) throws Exception {
        verify(pessoaAtualizar);
        return pessoaRepository.update(id, pessoaAtualizar);
    }

    public void delete(Integer id) throws Exception {
        pessoaRepository.delete(id);
    }

    public List<Pessoa> listByName(String nome) {
        return pessoaRepository.listByName(nome);
    }
}
