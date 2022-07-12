package br.com.vemser.pessoaapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ContatoCreateDTO {

    private Integer idPessoa;

    @NotBlank(message = "O tipo de contato não pode ser nulo.")
    @Schema(description = "Tipo de contato")
    private String tipo;

    @NotBlank(message = "O numero nao pode ser vazio/nulo.")
    @Size(max = 13)
    @Schema(description = "Número de telefone")
    private String numero;

    @NotBlank(message = "A descriçao nao pode ser vazia/nula.")
    @Schema(description = "Descrição do contato")
    private String descricao;
}
