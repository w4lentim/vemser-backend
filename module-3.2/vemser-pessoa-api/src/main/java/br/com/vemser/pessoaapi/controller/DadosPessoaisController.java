package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.config.Response;
import br.com.vemser.pessoaapi.dto.DadosPessoaisDTO;
import br.com.vemser.pessoaapi.service.DadosPessoaisService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dados-pessoais")
@Validated
public class DadosPessoaisController {

    @Autowired
    private DadosPessoaisService dadosPessoaisService;

    @Operation(summary = "Listar todos os dados pessoais", description = "Listará os dados pessoais de todas as pessoas do banco de dados")
    @Response
    @GetMapping
    public ResponseEntity<List<DadosPessoaisDTO>> getAll() {
        return new ResponseEntity<>(dadosPessoaisService.getAll(), HttpStatus.OK);
    }

    @Operation(summary = "Listar dados pessoais pelo CPF", description = "Listará os dados pessoais associados ao CPF")
    @Response
    @GetMapping("/{cpf}")
    public ResponseEntity<DadosPessoaisDTO> get(@PathVariable("cpf") String cpf) {
        return new ResponseEntity<>(dadosPessoaisService.get(cpf), HttpStatus.OK);
    }

    @Operation(summary = "Criar dados pessoais", description = "Criará novos dados pessoais no banco de dados")
    @Response
    @PostMapping
    public ResponseEntity<DadosPessoaisDTO> post(@RequestBody DadosPessoaisDTO dadosPessoaisDTO) {
        return new ResponseEntity<>(dadosPessoaisService.post(dadosPessoaisDTO), HttpStatus.CREATED);
    }

    @Operation(summary = "Atualizar dados pessoais pelo ID", description = "Atualizará os dados pessoais associados a um CPF")
    @Response
    @PutMapping("/{cpf}")
    public ResponseEntity<DadosPessoaisDTO> put(@PathVariable("cpf") String cpf, @RequestBody DadosPessoaisDTO dadosPessoaisDTO) {
        return new ResponseEntity<>(dadosPessoaisService.put(cpf, dadosPessoaisDTO), HttpStatus.OK);
    }

    @Operation(summary = "Deletar dados pessoais pelo ID", description = "Deletara os dados pessoais associados ao CPF no banco de dados")
    @Response
    @DeleteMapping("/{cpf}")
    public ResponseEntity<Void> delete(@PathVariable("cpf") String cpf) {
        dadosPessoaisService.delete(cpf);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
