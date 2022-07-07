package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.entity.Contato;
import br.com.vemser.pessoaapi.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contato")
public class ContatoController {

    @Autowired
    private ContatoService contatoService;

    @GetMapping
    public List<Contato> list() { return contatoService.list(); }

    @GetMapping("/{idPessoa}")
    public List<Contato> listById(@PathVariable("idPessoa") Integer id) throws Exception {
        return contatoService.listById(id);
    }

    @PostMapping
    public Contato create(@PathVariable("idPessoa") Integer id, @RequestBody Contato contato) throws Exception {
        return contatoService.create(id, contato);
    }

    @PutMapping("/{idContato}")
    public Contato update(@PathVariable("idContato") Integer id, @RequestBody Contato contatoAtualizar) throws Exception {
        return contatoService.update(id, contatoAtualizar);
    }

    @DeleteMapping("/{idContato}")
    public void delete(@PathVariable("idContato") Integer id) throws Exception {
        contatoService.delete(id);
    }
}

    /* MAIS NOVO
//    private final ContatoService contatoService;
//
//    public ContatoController(ContatoService contatoService) {
//        this.contatoService = contatoService;
//    }
     */