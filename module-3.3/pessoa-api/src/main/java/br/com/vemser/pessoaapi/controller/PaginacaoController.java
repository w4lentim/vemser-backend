package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.config.Response;
import br.com.vemser.pessoaapi.entity.ContatoEntity;
import br.com.vemser.pessoaapi.entity.EnderecoEntity;
import br.com.vemser.pessoaapi.repository.ContatoRepository;
import br.com.vemser.pessoaapi.repository.EnderecoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paginacao")
@RequiredArgsConstructor
public class PaginacaoController {

    private final ContatoRepository contatoRepository;
    private final EnderecoRepository enderecoRepository;

    @Response
    @GetMapping("/contato-descricao")
    public ResponseEntity<Page<ContatoEntity>> getContatoByDescricao(Integer paginas, Integer quantidade) {

        Sort ordenacao = Sort.by("descricao");

        Pageable pageable = PageRequest.of(paginas,quantidade, ordenacao);

        Page<ContatoEntity> contatoEntities = contatoRepository.listContatoByDescricao(pageable);
        return new ResponseEntity<>(contatoEntities, HttpStatus.OK);
    }

    @Response
    @GetMapping("/endereco-cep")
    public ResponseEntity<Page<EnderecoEntity>> getEnderecoByCEP(Integer paginas, Integer quantidade) {

        Pageable pageable = PageRequest.of(paginas, quantidade, Sort.by("cep"));

        Page<EnderecoEntity> enderecoEntities = enderecoRepository.listEnderecoOrderedByCep(pageable);

        return new ResponseEntity<>(enderecoEntities, HttpStatus.OK);
    }

    @Response
    @GetMapping("/endereco-pais")
    public ResponseEntity<Page<EnderecoEntity>> getEnderecoByPais(@RequestParam String pais, Integer paginas, Integer quantidade) {
        Pageable pageable = PageRequest.of(paginas, quantidade, Sort.by("pais"));
        Page<EnderecoEntity> enderecoEntities = enderecoRepository.listEnderecoOrderedByPais(pais, pageable);
        return new ResponseEntity<>(enderecoEntities, HttpStatus.OK);
    }
}
