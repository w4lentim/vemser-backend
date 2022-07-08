package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.entity.Contato;
import br.com.vemser.pessoaapi.repository.ContatoRepository;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;
    @Autowired
    private PessoaService pessoaService;

    public List<Contato> list() {
        return contatoRepository.list();
    }

    public Contato create(Integer idPessoa, Contato contato) throws RegraDeNegocioException {
        contato.setIdPessoa(pessoaService.verifyByIdPessoa(idPessoa).getIdPessoa());
        return contatoRepository.create(contato);
    }

    public Contato update(Integer idContato, Contato contatoAtualizar) throws RegraDeNegocioException {
        pessoaService.verifyByIdPessoa(contatoAtualizar.getIdPessoa());
        try {
            return contatoRepository.update(verifyByIdContato(idContato), contatoAtualizar);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(Integer idContato) throws RegraDeNegocioException {
        try {
            contatoRepository.delete(verifyByIdContato(idContato));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Contato verifyByIdContato(Integer idContato) throws RegraDeNegocioException {
        return list().stream()
                .filter(contato -> contato.getIdContato().equals(idContato))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Não foi possível encontrar nenhum contato associado ao ID."));
    }

    public List<Contato> listContatoByIdPessoa(Integer idPessoa) throws RegraDeNegocioException {
        return list().stream()
                .filter(contato -> contato.getIdPessoa().equals(idPessoa)).toList();
    }
}
