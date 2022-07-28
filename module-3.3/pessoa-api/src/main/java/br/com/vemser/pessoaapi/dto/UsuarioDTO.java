package br.com.vemser.pessoaapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

    @Schema(description = "Identificador (ID) do usuário")
    private Integer idUsuario;

    @Schema(description = "Login do usuário")
    private String login;
}
