package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.vemser.pessoaapi.dto.PessoaDTO;
import br.com.vemser.pessoaapi.config.PropertieReader;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.service.EmailService;
import br.com.vemser.pessoaapi.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pessoa")
@Validated
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;
    @Autowired
    private PropertieReader propertieReader;
    @Autowired
    private EmailService emailService;

    public PessoaController() {}

    @GetMapping("/ambiente")
    public String endpoint() {
        return propertieReader.getAmbiente();
    }

    @GetMapping("/hello")
    public String hello() { return "Hello World!"; }

    @GetMapping("/email")
    public String email() {
        emailService.sendEmail();
        return "Enviando email...";
    }

    @GetMapping
    public List<PessoaDTO> list() { return pessoaService.list(); }

    @GetMapping("/byname")
    public List<PessoaDTO> listByName(@RequestParam("nome") String nome) {
        return pessoaService.listByName(nome);
    }

    @PostMapping
    public ResponseEntity<PessoaDTO> create(@RequestBody @Valid PessoaCreateDTO pessoa) throws RegraDeNegocioException {
        return ResponseEntity.ok(pessoaService.create(pessoa));
    }

    @PutMapping("/{idPessoa}")
    public ResponseEntity<PessoaDTO> update(@PathVariable("idPessoa") Integer id, @RequestBody @Valid PessoaCreateDTO pessoaAtualizar) throws RegraDeNegocioException {
        return ResponseEntity.ok(pessoaService.update(id, pessoaAtualizar));
    }

    @DeleteMapping("/{idPessoa}")
    public void delete(@PathVariable("idPessoa") Integer idPessoa) throws Exception {
        pessoaService.delete(idPessoa);
    }
}