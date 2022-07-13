package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dto.DadosPessoaisDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DadosPessoaisService {

    @Autowired
    private DadosPessoaisService client;

    public List<DadosPessoaisDTO> listAll() {
        return client.listAll();
    }

    public DadosPessoaisDTO list(String cpf) {
        return client.list(cpf);
    }

    public DadosPessoaisDTO create(DadosPessoaisDTO dadosPessoaisDTO) {
        return client.create(dadosPessoaisDTO);
    }

    public DadosPessoaisDTO update(String cpf, DadosPessoaisDTO dadosPessoaisDTO) {
        return client.update(cpf, dadosPessoaisDTO);
    }

    public void delete(String cpf) {
        client.delete(cpf);
    }
}
