package br.com.vemser.pessoaapi.entity;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contato {

    private Integer idContato;

    private Integer idPessoa;

    @NotBlank(message = "O tipo de contato não pode ser nulo.")
    private String tipo;

    @NotBlank(message = "O numero nao pode ser vazio/nulo.")
    @Size(max = 13)
    private String numero;

    @NotBlank(message = "A descriçao nao pode ser vazia/nula.")
    private String descricao;

}
