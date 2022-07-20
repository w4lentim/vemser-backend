package br.com.vemser.pessoaapi.controller;
// ------------ Import's Classes -------------------;
import br.com.vemser.pessoaapi.config.Response;
import br.com.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.service.EnderecoService;
// ------------ Import's Swagger -------------------;
import io.swagger.v3.oas.annotations.Operation;
// ------------ Import's SpringBoot ----------------;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
// ------------ Import's Java ----------------------;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/endereco")
@Validated
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @Operation(summary = "Listar endereços", description = "Listará todos os endereços do banco de dados")
    @Response
    @GetMapping
    public ResponseEntity<List<EnderecoDTO>> list() {
        return new ResponseEntity<>(enderecoService.list(), HttpStatus.OK);
    }

    @Operation(summary = "Listar endereço pelo ID", description = "Listará um endereço do banco de acordo com o ID")
    @Response
    @GetMapping("/{idEndereco}")
    public ResponseEntity<EnderecoDTO> listEnderecoByIdEndereco(@PathVariable("idEndereco") Integer idEndereco) throws RegraDeNegocioException {
        return new ResponseEntity<>(enderecoService.findEnderecoByIdEndereco(idEndereco), HttpStatus.OK);
    }

    @Operation(summary = "Adicionar um endereço à uma pessoa", description = "Adicionará um endereço, vinculando-o à uma pessoa existente")
    @Response
    @PostMapping("/{idPessoa}")
    public ResponseEntity<EnderecoDTO> create(@PathVariable("idPessoa") Integer idPessoa, @RequestBody @Valid EnderecoCreateDTO enderecoCreateDTO) throws RegraDeNegocioException {
        return new ResponseEntity<>(enderecoService.create(idPessoa, enderecoCreateDTO), HttpStatus.OK);
    }

    @Operation(summary = "Atualizar endereço", description = "Atualizará todos os dados de um endereço de acordo com ID informado")
    @Response
    @PutMapping("/{idEndereco}")
    public ResponseEntity<EnderecoDTO> update(@PathVariable("idEndereco") Integer idEndereco, @RequestBody @Valid EnderecoCreateDTO enderecoAtualizar) throws RegraDeNegocioException {
        return new ResponseEntity<>(enderecoService.update(idEndereco, enderecoAtualizar), HttpStatus.ACCEPTED);
    }

    @Operation(summary = "Deletar endereço", description = "Deletará um endereço do banco de dados")
    @Response
    @DeleteMapping("/{idEndereco}")
    public ResponseEntity<Void> delete(@PathVariable("idEndereco") Integer idEndereco) throws RegraDeNegocioException {
        enderecoService.delete(idEndereco);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
