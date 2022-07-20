package br.com.vemser.pessoaapi.controller;
// ---------------- Import's Classes -----------------;
import br.com.vemser.pessoaapi.config.Response;
import br.com.vemser.pessoaapi.client.dto.ContatoCreateDTO;
import br.com.vemser.pessoaapi.client.dto.ContatoDTO;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.service.ContatoService;
// ---------------- Import's SpringBoot --------------;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
// ---------------- Import's Java --------------------;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/contato")
@Validated
public class ContatoController {
    @Autowired
    private ContatoService contatoService;

    @Operation(summary = "Listar contatos", description = "Listará todos os contatos contidos no banco de dados")
    @Response
    @GetMapping
    public ResponseEntity<List<ContatoDTO>> list() {
        return new ResponseEntity<>(contatoService.list(), HttpStatus.OK);
    }

    @Operation(summary = "Listar contato pelo ID da pessoa", description = "Listará todos os contatos associados ao ID da pessoa")
    @Response
    @GetMapping("/{idPessoa}")
    public ResponseEntity<List<ContatoDTO>> listByIdPessoa(@PathVariable("idPessoa") Integer idPessoa) throws RegraDeNegocioException {
        return new ResponseEntity<>(contatoService.listContatoByIdPessoa(idPessoa), HttpStatus.OK);
    }

    @Operation(summary = "Adicionar um contato a uma pessoa", description = "Adicionará um novo contato a uma pessoa do banco de dados")
    @Response
    @PostMapping("/{idPessoa}")
    public ResponseEntity<ContatoDTO> create(@PathVariable("idPessoa") Integer idPessoa, @RequestBody @Valid ContatoCreateDTO contato) throws RegraDeNegocioException {
        return new ResponseEntity<>(contatoService.create(idPessoa, contato), HttpStatus.CREATED);
    }

    @Operation(summary = "Atualizar contato", description = "Atualizará os dados do contato no banco de dados")
    @Response
    @PutMapping("/{idContato}")
    public ResponseEntity<ContatoDTO> update(@PathVariable("idContato") Integer idContato, @RequestBody @Valid ContatoCreateDTO contatoAtualizar) throws RegraDeNegocioException {
        return new ResponseEntity<>(contatoService.update(idContato, contatoAtualizar), HttpStatus.ACCEPTED);
    }

    @Operation(summary = "Deletar contato", description = "Deletará todos os dados de um contato no banco de dados")
    @Response
    @DeleteMapping("/{idContato}")
    public ResponseEntity<Void> delete(@PathVariable("idContato") Integer idContato) throws RegraDeNegocioException {
        contatoService.delete(idContato);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}