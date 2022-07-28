package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.dto.LoginDTO;
import br.com.vemser.pessoaapi.entity.UsuarioEntity;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.security.TokenService;
import br.com.vemser.pessoaapi.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
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
@Slf4j
public class AuthController {

    private final UsuarioService usuarioService;
    private final TokenService tokenService;

    private final AuthenticationManager authenticationManager;

    @PostMapping
    public String auth(@RequestBody @Valid LoginDTO login) throws RegraDeNegocioException {

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(
                        login.getLogin(),
                        login.getSenha());

        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        log.info("Sucesso! Autenticado com sucesso!");

        Object usuarioLogado = authentication.getPrincipal();
        UsuarioEntity usuarioEntity = (UsuarioEntity) usuarioLogado;

        String token = tokenService.getToken(usuarioEntity);
        return token;
    }
}
