package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.entity.Endereco;
import br.com.vemser.pessoaapi.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<Endereco> list() {
        return enderecoRepository.list();
    }

    public Endereco create(Integer idPessoa, Endereco endereco) throws Exception {
        endereco.setIdPessoa(idPessoa);
        return enderecoRepository.create(endereco);
    }

    public Endereco update(Integer idEndereco, Endereco enderecoAtualizar) throws Exception {
        Endereco enderecoRecuperado = enderecoRepository.listEnderecoByIdEndereco(idEndereco);
        return enderecoRepository.update(enderecoRecuperado, enderecoAtualizar);
    }

    public void delete(Integer idEndereco) throws Exception {
        enderecoRepository.delete(idEndereco);
    }

    public Endereco listEnderecoByIdEndereco(Integer id) throws Exception {
        return enderecoRepository.listEnderecoByIdEndereco(id);
    }

    public List<Endereco> listEnderecoByIdPessoa(Integer id) throws Exception {
        return enderecoRepository.listEnderecoByIdPessoa(id);
    }
}
