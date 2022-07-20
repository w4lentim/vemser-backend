package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.config.Response;
import br.com.vemser.pessoaapi.client.dto.PetCreateDTO;
import br.com.vemser.pessoaapi.client.dto.PetDTO;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.service.PetService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pet")
@Validated
public class PetController {

    @Autowired
    private PetService petService;

    @Operation(summary = "Listar todos os pets", description = "Realizará a listagem de todos os pets.")
    @Response
    @GetMapping
    public ResponseEntity<List<PetDTO>> list() {
        return new ResponseEntity<>(petService.list(), HttpStatus.OK);
    }

    @Operation(summary = "Adicionar um novo pet", description = "Adicionará um novo pet ao banco de dados.")
    @Response
    @PostMapping
    public ResponseEntity<PetDTO> create(@RequestBody @Valid PetCreateDTO petCreateDTO) throws RegraDeNegocioException {
        return new ResponseEntity<>(petService.create(petCreateDTO), HttpStatus.CREATED);
    }

    @Operation(summary = "Atualizar dados de um pet", description = "Atualizará os dados de um pet associado ao ID.")
    @Response
    @PutMapping("/{idPet}")
    public ResponseEntity<PetDTO> update(@PathVariable("idPet") Integer idPet, @RequestBody @Valid PetCreateDTO petCreateDTO) throws RegraDeNegocioException {
        return new ResponseEntity<>(petService.update(idPet, petCreateDTO), HttpStatus.OK);
    }

    @Operation(summary = "Deletar um pet", description = "Removerá um pet e todos os seus dados do banco de dados.")
    @Response
    @DeleteMapping("/{idPet}")
    public ResponseEntity<Void> delete(@PathVariable("idPet") Integer idPet) throws RegraDeNegocioException {
        petService.delete(idPet);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
