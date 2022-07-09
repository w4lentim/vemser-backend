package br.com.vemser.pessoaapi.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EnderecoCreateDTO {

    private Integer idPessoa;

    @NotNull(message = "O tipo de endereço deve ser RESIDENCIAL/COMERCIAL.")
    private String tipo;

    @NotEmpty
    @Size(max = 250, message = "Informe um logradouro válido, contendo até 250 caracteres.")
    private String logradouro;

    @NotNull(message = "O número da residência não pode ser nulo.")
    private Integer numero;

    private String complemento;

    @NotEmpty(message = "O CEP não pode ser vazio/nulo.")
    @Size(min = 8, max = 8, message = "O CEP deve conter 8 números.")
    private String cep;

    @NotEmpty(message = "A cidade não pode ser nula/vazia.")
    @Size(max = 250, message = "Informe uma cidade válida, contendo até 250 caracteres.")
    private String cidade;

    @NotNull(message = "O estado não pode ser nulo.")
    private String estado;

    @NotNull(message = "O país não pode ser nulo.")
    private String pais;
}
