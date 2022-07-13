package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.dto.DadosPessoaisDTO;
import br.com.vemser.pessoaapi.service.DadosPessoaisService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dados-pessoais")
public class DadosPessoaisController {

    @Autowired
    private DadosPessoaisService dadosPessoaisService;

    @GetMapping
    public ResponseEntity<List<DadosPessoaisDTO>> listAll() {
        return new ResponseEntity<>(dadosPessoaisService.listAll(), HttpStatus.OK);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<DadosPessoaisDTO> list(@PathVariable("cpf") String cpf) {
        return new ResponseEntity<>(dadosPessoaisService.list(cpf), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DadosPessoaisDTO> create(@RequestBody DadosPessoaisDTO dadosPessoaisDTO) {
        return new ResponseEntity<>(dadosPessoaisService.create(dadosPessoaisDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{cpf}")
    public ResponseEntity<DadosPessoaisDTO> update(@PathVariable("cpf") String cpf, @RequestBody DadosPessoaisDTO dadosPessoaisDTO) {
        return new ResponseEntity<>(dadosPessoaisService.update(cpf, dadosPessoaisDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<Void> delete(@PathVariable("cpf") String cpf) {
        dadosPessoaisService.delete(cpf);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
