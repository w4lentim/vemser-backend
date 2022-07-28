package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dto.LoginDTO;
import br.com.vemser.pessoaapi.dto.UsuarioDTO;
import br.com.vemser.pessoaapi.entity.UsuarioEntity;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.UsuarioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final ObjectMapper objectMapper;
    private final PasswordEncoder passwordEncoder;

//    public Optional<UsuarioEntity> findByLoginAndSenha(String login, String senha){
//        return usuarioRepository.findByLoginAndSenha(login, senha);
//    }
//
//    public Optional<UsuarioEntity> findById(Integer idUsuario) {
//        return usuarioRepository.findById(idUsuario);
//    }

    public Optional<UsuarioEntity> findByLogin(String login) {
        return usuarioRepository.findByLogin(login);
    }

    public String criptografarSenha(String senha) {
        String senhaCriptografada = passwordEncoder.encode(senha);
        return senhaCriptografada;
    }

    public UsuarioDTO cadastrarNovoUsuario(LoginDTO loginDTO) throws RegraDeNegocioException {
        UsuarioEntity usuarioEntity = objectMapper.convertValue(loginDTO, UsuarioEntity.class);
        usuarioEntity.setSenha(criptografarSenha(usuarioEntity.getSenha()));

        usuarioRepository.save(usuarioEntity);

        return objectMapper.convertValue(usuarioEntity, UsuarioDTO.class);
    }
}
