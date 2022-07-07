package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.entity.Contato;
import br.com.vemser.pessoaapi.repository.ContatoRepository;
import br.com.vemser.pessoaapi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;
    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private PessoaService pessoaService;

    public Contato create(Integer id, Contato contato) throws Exception {
        verifyPessoa(id);
        contato.setIdPessoa(id);
        return contatoRepository.create(contato);
    }

    public List<Contato> list() {
        return contatoRepository.list();
    }

    public Contato update(Integer id, Contato contatoAtualizar) throws Exception {
        verifyPessoa(contatoAtualizar.getIdPessoa());
        return contatoRepository.update(verifyContato(id), contatoAtualizar);
    }

    public void delete(Integer id) throws Exception {
        Contato contatoRecuperado = contatoRepository.list().stream()
                .filter(contato -> contato.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("O contato não foi encontrado"));
        contatoRepository.list().remove(contatoRecuperado);
    }

    public List<Contato> listById(Integer id) throws Exception {
        return contatoRepository.listById(id);
    }

    public boolean verifyPessoa(Integer id) throws Exception {
        pessoaService.list().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Não foi encontrado nenhuma pessoa com o ID informado!"));
        return true;
    }

    public Contato verifyContato(Integer idContato) throws Exception {
        try {
            Contato contatoRecuperado = contatoRepository.contatoByIdContato(idContato);
            return contatoRecuperado;
        } catch (Exception e) {
            throw new Exception("Não foi encontrado nenhum contato com o ID informado!");
        }
    }
}
