package br.com.vemser.pessoaapi.dto;


import br.com.vemser.pessoaapi.enums.TipoDoPet;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PetCreateDTO {

    @NotBlank
    @Schema(description = "Nome do pet")
    private String nome;

    @NotNull
    @Schema(description = "Tipo do pet")
    private TipoDoPet tipo;

    @Schema(description = "ID da pessoa que o pet está associado.")
    private Integer idPessoa;
}
