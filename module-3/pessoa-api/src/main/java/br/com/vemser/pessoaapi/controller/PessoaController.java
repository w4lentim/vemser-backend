package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.entity.Pessoa;
import br.com.vemser.pessoaapi.config.PropertieReader;
import br.com.vemser.pessoaapi.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa") // localhost:8080/pessoa
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private PropertieReader propertieReader;

    public PessoaController() {}

    @GetMapping("/ambiente")
    public String endpoint() {
        return propertieReader.getAmbiente();
    }

    @GetMapping("/hello") // localhost:8080/pessoa/hello;
    public String hello() { return "Hello World!"; }

    @PostMapping
    public Pessoa create(@RequestBody Pessoa pessoa) throws Exception {
        return pessoaService.create(pessoa);
    }

    @GetMapping
    public List<Pessoa> list() { return pessoaService.list(); }

    @GetMapping("/byname") // localhost:8080/pessoa/byname?nome=Rafa
    public List<Pessoa> listByName(@RequestParam("nome") String nome) {
        return pessoaService.listByName(nome);
    }

    @PutMapping("/{idPessoa}")
    public Pessoa update(@PathVariable("idPessoa") Integer id, @RequestBody Pessoa pessoaAtualizar) throws Exception {
        return pessoaService.update(id, pessoaAtualizar);
    }

    @DeleteMapping("/{idPessoa}")
    public void delete(@PathVariable("idPessoa") Integer id) throws Exception {
        pessoaService.delete(id);
    }
}

/* MAIS NOVO
//    private final PessoaService pessoaService;
//
//    public PessoaController(PessoaService pessoaService) {
//          this.pessoaService = pessoaService;
//    }
     */