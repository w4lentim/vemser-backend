package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.config.Response;
import br.com.vemser.pessoaapi.entity.ProfessorEntity;
import br.com.vemser.pessoaapi.repository.ProfessorRepository;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/professor")
@Validated
public class ProfessorController {

    @Autowired
    private ProfessorRepository professorRepository;

    @Operation(summary = "Listar professor", description = "Realizará a listagem de todas as pessoas cadastradas no banco de dados")
    @Response
    @GetMapping
    public List<ProfessorEntity> listAll() {
        return professorRepository.findAll();
    }

    @Operation(summary = "Adicionar professor", description = "Adicionará um professor ao banco de dados")
    @Response
    @PostMapping
    public ResponseEntity<ProfessorEntity> post(@RequestBody @Valid ProfessorEntity professorEntity) throws RegraDeNegocioException {
        return new ResponseEntity<>(professorRepository.save(professorEntity), HttpStatus.CREATED);
    }
}
