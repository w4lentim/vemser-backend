package br.com.vemser.pessoaapi.repository;

import br.com.vemser.pessoaapi.entity.Endereco;
import br.com.vemser.pessoaapi.entity.Pessoa;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class EnderecoRepository {

    private static List<Endereco> listaEndereco = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();

    public EnderecoRepository() {
        listaEndereco.add(new Endereco(COUNTER.incrementAndGet(), 1, "COMERCIAL", "Rua das Pedras", 44, "A", "61948000", "Fortaleza", "Ceará", "Brasil"));
        listaEndereco.add(new Endereco(COUNTER.incrementAndGet(), 2, "RESIDENCIAL", "Rua das Flores", 55, "B", "61948111", "Fortaleza", "Ceará", "Brasil"));
        listaEndereco.add(new Endereco(COUNTER.incrementAndGet(), 3, "COMERCIAL", "Rua dos Carros", 66, "C", "61948222", "Fortaleza", "Ceará", "Brasil"));
        listaEndereco.add(new Endereco(COUNTER.incrementAndGet(), 4, "RESIDENCIAL", "Rua das Árvores", 77, "D", "61948333", "Fortaleza", "Ceará", "Brasil"));
        listaEndereco.add(new Endereco(COUNTER.incrementAndGet(), 5, "COMERCIAL", "Rua das Calçadas", 88, "E", "61948444", "Fortaleza", "Ceará", "Brasil"));
    }

    public Endereco create(Endereco endereco) {
        endereco.setIdEndereco(COUNTER.incrementAndGet());
        listaEndereco.add(endereco);
        return endereco;
    }

    public List<Endereco> list() {
        return listaEndereco;
    }
    public Endereco update(Endereco enderecoRecuperado, Endereco enderecoAtualizar) throws Exception {
        enderecoRecuperado.setIdPessoa(enderecoAtualizar.getIdPessoa());
        enderecoRecuperado.setTipo(enderecoAtualizar.getTipo());
        enderecoRecuperado.setLogradouro(enderecoAtualizar.getLogradouro());
        enderecoRecuperado.setNumero(enderecoAtualizar.getNumero());
        enderecoRecuperado.setComplemento(enderecoAtualizar.getComplemento());
        enderecoRecuperado.setCep(enderecoAtualizar.getCep());
        enderecoRecuperado.setCidade(enderecoAtualizar.getCidade());
        enderecoRecuperado.setEstado(enderecoAtualizar.getEstado());
        enderecoRecuperado.setPais(enderecoAtualizar.getPais());

        return enderecoRecuperado;
    }

    public void delete(Integer id) throws Exception {
        Endereco enderecoRecuperado = listaEndereco.stream()
                .filter(endereco -> endereco.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("O endereço não foi encontrado."));
        listaEndereco.remove(enderecoRecuperado);
    }

    public List<Endereco> listEnderecoByIdPessoa(Integer id) {
        return listaEndereco.stream()
                .filter(endereco -> endereco.getIdPessoa().equals(id)).toList();
    }

    public Endereco listEnderecoByIdEndereco(Integer id) throws Exception {
        try {
            Endereco enderecoRecuperado = listaEndereco.stream()
                    .filter(endereco -> endereco.getIdEndereco().equals(id))
                    .findFirst().get();
            return enderecoRecuperado;
        } catch (Exception e) {
            throw new Exception("Não foi possível encontrar o endereço!");
        }
    }
}
