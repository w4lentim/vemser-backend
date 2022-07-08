package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.entity.Endereco;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/endereco")
@Validated
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    public List<Endereco> list() {
        return enderecoService.list();
    }

    @GetMapping("/{idEndereco}")
    public Endereco listEnderecoByIdEndereco(@PathVariable("idEndereco") Integer idEndereco) throws RegraDeNegocioException {
        return enderecoService.listEnderecoByIdEndereco(idEndereco);
    }

    @GetMapping("/{idPessoa}/pessoa")
    public List<Endereco> listByIdPessoa(@PathVariable("idPessoa") Integer idPessoa) throws RegraDeNegocioException {
        return enderecoService.listEnderecoByIdPessoa(idPessoa);
    }

    @PostMapping("/{idPessoa}")
    public ResponseEntity<Endereco> create(@PathVariable("idPessoa") Integer idPessoa, @RequestBody @Valid Endereco endereco) throws RegraDeNegocioException {
        return ResponseEntity.ok(enderecoService.create(idPessoa, endereco));
    }

    @PutMapping("/{idEndereco}")
    public ResponseEntity<Endereco> update(@PathVariable("idEndereco") Integer idEndereco, @RequestBody @Valid Endereco enderecoAtualizar) throws RegraDeNegocioException {
        return ResponseEntity.ok(enderecoService.update(idEndereco, enderecoAtualizar));
    }

    @DeleteMapping("/{idEndereco}")
    public void delete(@PathVariable("idEndereco") Integer idEndereco) throws RegraDeNegocioException {
        enderecoService.delete(idEndereco);
    }
}
