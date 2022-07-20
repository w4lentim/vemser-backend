package br.com.vemser.pessoaapi.controller;
// ----------- Import's Classes ------------;
import br.com.vemser.pessoaapi.config.Response;
import br.com.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.vemser.pessoaapi.dto.PessoaDTO;
import br.com.vemser.pessoaapi.entity.PessoaEntity;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.PessoaRepository;
import br.com.vemser.pessoaapi.service.EmailService;
import br.com.vemser.pessoaapi.service.PessoaService;
// ----------- Import's Swagger ------------;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
// ----------- Import's SpringFramework ----;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
// ----------- Import's Java ---------------;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/pessoa")
@Validated
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @Operation(summary = "Listar pessoas", description = "Realizará a listagem de todas as pessoas cadastradas no banco de dados")
    @Response
    @GetMapping
    public ResponseEntity<List<PessoaDTO>> list() {
        return new ResponseEntity<>(pessoaService.list(), HttpStatus.OK);
    }

    @Operation(summary = "Listar pessoas e enderecos",  description = "Realizará a listagem de todas as pessoas e seus endereços associados. Caso queira solicitar informações de apenas uma pessoa, informe pelo Query Param, caso contrário, trará todas as informações.")
    @Response
    @GetMapping("/enderecos")
    public ResponseEntity<List<PessoaDTO>> listPessoaAndEnderecos(@RequestParam(required = false) Integer idPessoa) {
        return new ResponseEntity<>(pessoaService.listPessoaAndEndereco(idPessoa), HttpStatus.OK);
    }

    @Operation(summary = "Listar pessoas e contatos", description = "Realizará a listagem de todas as pessoas e seus contatos associados. Caso queira solicitar informações de apenas uma pessoa, informe pelo Query Param, caso contrário, trará todas as informações.")
    @Response
    @GetMapping("/contatos")
    public ResponseEntity<List<PessoaDTO>> listPessoaAndContatos(@RequestParam(required = false) Integer idPessoa) {
        return new ResponseEntity<>(pessoaService.listPessoaAndContato(idPessoa), HttpStatus.OK);
    }

    @Operation(summary = "Listar pessoas e pets", description = "Realizará a listagem de todas as pessoas e seus contatos associados. Caso queira solicitar informações de apenas uma pessoa, informe pelo Query Param, caso contrário, trará todas as informações.")
    @Response
    @GetMapping("/pet")
    public ResponseEntity<List<PessoaDTO>> listPessoaAndPets(@RequestParam(required = false) Integer idPessoa) {
        return new ResponseEntity<>(pessoaService.listPessoaAndPets(idPessoa), HttpStatus.OK);
    }

    @Operation(summary = "Listar pessoa pelo cpf", description = "Realizará a listagem dos dados da pessoa associada ao CPF.")
    @Response
    @GetMapping("/{cpf}")
    public ResponseEntity<PessoaDTO> listByCpf(@PathVariable ("cpf") String cpf){
        return new ResponseEntity<>(pessoaService.listByCpf(cpf), HttpStatus.OK);
    }

    @Operation(summary = "Listar pessoas pelo nome", description = "Realizará a listagem de todas as pessoas que fazem referência ao nome informado.")
    @Response
    @GetMapping("/bynome/{by-nome}")
    public ResponseEntity<List<PessoaDTO>> listContainsNome(@PathVariable ("by-nome") String nome) {
        return new ResponseEntity<>(pessoaService.listContainsNome(nome), HttpStatus.OK);
    }

    @Operation(summary = "Adicionar pessoa", description = "Adicionará uma nova pessoa ao banco de dados")
    @Response
    @PostMapping
    public ResponseEntity<PessoaDTO> create(@RequestBody @Valid PessoaCreateDTO pessoa) throws RegraDeNegocioException {
        return new ResponseEntity<>(pessoaService.create(pessoa), HttpStatus.CREATED);
    }

    @Operation(summary = "Atualizar pessoa", description = "Atualizará os dados de uma pessoa do banco de dados")
    @Response
    @PutMapping("/{idPessoa}")
    public ResponseEntity<PessoaDTO> update(@PathVariable("idPessoa") Integer id, @RequestBody @Valid PessoaCreateDTO pessoaAtualizar) throws RegraDeNegocioException {
        return new ResponseEntity<>(pessoaService.update(id, pessoaAtualizar), HttpStatus.ACCEPTED);
    }

    @Operation(summary = "Deletar pessoa", description = "Deletará a pessoa e todos os seus dados do banco de dados")
    @Response
    @DeleteMapping("/{idPessoa}")
    public ResponseEntity<Void> delete(@PathVariable("idPessoa") Integer idPessoa) throws RegraDeNegocioException {
        pessoaService.delete(idPessoa);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}