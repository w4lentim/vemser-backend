package br.com.vemser.pessoaapi.dto;

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
    private String tipo;

    @NotBlank(message = "O numero nao pode ser vazio/nulo.")
    @Size(max = 13)
    private String numero;

    @NotBlank(message = "A descriçao nao pode ser vazia/nula.")
    private String descricao;
}
