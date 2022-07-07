package br.com.vemser.pessoaapi.repository;

import br.com.vemser.pessoaapi.entity.Contato;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class ContatoRepository {

    private static List<Contato> listaContatos = new ArrayList<>();

    private AtomicInteger COUNTER = new AtomicInteger();

    public ContatoRepository() {
        listaContatos.add(new Contato(COUNTER.incrementAndGet(), 1, "COMERCIAL", "8533334444", "Telegram"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet(), 2, "RESIDENCIAL", "85911112222", "Whatsapp"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet(), 3, "RESIDENCIAL", "85933334444", "Telegram"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet(), 4, "COMERCIAL", "8533335555", "Whatsapp"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet(), 5, "COMERCIAL", "8533336666", "Telegram"));
    }

    public Contato create(Contato contato) {
        contato.setIdContato(COUNTER.incrementAndGet());
        listaContatos.add(contato);
        return contato;
    }

    public Contato update(Contato contatoRecuperado, Contato contatoAtualizar) throws Exception {
        contatoRecuperado.setTipo(contatoAtualizar.getTipo());
        contatoRecuperado.setIdPessoa(contatoAtualizar.getIdPessoa());
        contatoRecuperado.setNumero(contatoAtualizar.getNumero());
        contatoRecuperado.setDescricao(contatoAtualizar.getDescricao());
        return contatoRecuperado;
    }

    public List<Contato> list() {
        return listaContatos;
    }

    public void delete(Integer id) throws Exception {
        Contato contatoRemover = contatoByIdContato(id);
        listaContatos.remove(contatoRemover);
    }

    public Contato contatoByIdContato(Integer idContato) throws Exception {
        try {
            Contato contatoRecuperado = listaContatos.stream()
                    .filter(contato -> contato.getIdContato().equals(idContato))
                    .findFirst()
                    .get();
            return contatoRecuperado;
        } catch (Exception e) {
            throw new Exception();
        }
    }

    public List<Contato> listById(Integer id) {
        return listaContatos.stream()
                .filter(contato -> contato.getIdPessoa().equals(id))
                .toList();
    }
}
