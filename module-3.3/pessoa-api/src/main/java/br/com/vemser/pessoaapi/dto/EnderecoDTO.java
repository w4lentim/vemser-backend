package br.com.vemser.pessoaapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EnderecoDTO extends EnderecoCreateDTO {

    @Schema(description = "Identificador (ID) do endereço.")
    private Integer idEndereco;

    @Schema(description = "Identificador da pessoa.")
    private Integer idPessoa;

    @Schema(description = "Pessoas que estão associadas a este endereço")
    private PessoaDTO pessoaDTO;
}
