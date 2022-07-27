package br.com.vemser.pessoaapi.controller;


import br.com.vemser.pessoaapi.config.Response;
import br.com.vemser.pessoaapi.dto.LoginDTO;
import br.com.vemser.pessoaapi.entity.UsuarioEntity;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.security.TokenService;
import br.com.vemser.pessoaapi.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
@Validated
@RequiredArgsConstructor
public class AuthController {

    private final UsuarioService usuarioService;
    private final TokenService tokenService;

    @Response
    @PostMapping
    public String auth(@RequestBody @Valid LoginDTO login) throws RegraDeNegocioException {
        Optional<UsuarioEntity> usuarioOptional = usuarioService.findByLoginAndSenha(login.getLogin(), login.getSenha());
        if(usuarioOptional.isPresent()){
            String token = tokenService.getToken(usuarioOptional.get());
            return token;
        }
        throw new RegraDeNegocioException("Usuário ou senha inválidos!");
    }
}
