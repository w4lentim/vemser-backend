package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.entity.Endereco;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private PessoaService pessoaService;

    public List<Endereco> list() {
        return enderecoRepository.list();
    }

    public Endereco create(Integer idPessoa, Endereco endereco) throws RegraDeNegocioException {
        endereco.setIdPessoa(pessoaService.verifyByIdPessoa(idPessoa).getIdPessoa());
        return enderecoRepository.create(endereco);
    }

    public Endereco update(Integer idEndereco, Endereco enderecoAtualizar) throws RegraDeNegocioException {
        try {
            return enderecoRepository.update(verifyEnderecoById(idEndereco), enderecoAtualizar);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(Integer idEndereco) throws RegraDeNegocioException {
        enderecoRepository.delete(verifyEnderecoById(idEndereco));
    }

    public Endereco verifyEnderecoById(Integer idEndereco) throws RegraDeNegocioException {
        return list().stream()
                .filter(endereco -> endereco.getIdEndereco().equals(idEndereco))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Não foi possível encontrar nenhum endereço associado ao ID."));
    }

    public List<Endereco> listEnderecoByIdPessoa(Integer idPessoa) throws RegraDeNegocioException {
        return list().stream()
                .filter(endereco -> endereco.getIdPessoa().equals(idPessoa)).toList();
    }

    public Endereco listEnderecoByIdEndereco(Integer idEndereco) throws RegraDeNegocioException {
        return list().stream()
                .filter(endereco -> endereco.getIdEndereco().equals(idEndereco))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Não foi possível listar, pois não há um endereço associado ao ID."));
    }
}
