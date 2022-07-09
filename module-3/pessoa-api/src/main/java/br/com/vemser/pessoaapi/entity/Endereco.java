package br.com.vemser.pessoaapi.entity;

import lombok.*;

import javax.validation.constraints.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    private Integer idEndereco;

    private Integer idPessoa;

    @NotBlank(message = "O tipo de endereço deve ser RESIDENCIAL/COMERCIAL.")
    private String tipo;

    @NotBlank
    @Size (max = 250, message = "Informe um logradouro válido, contendo até 250 caracteres.")
    private String logradouro;

    @NotBlank(message = "O número da residência não pode ser nulo.")
    private Integer numero;

    private String complemento;

    @NotBlank(message = "O CEP não pode ser vazio/nulo.")
    @Size(min = 8, max = 8, message = "O CEP deve conter 8 números.")
    private String cep;

    @NotBlank(message = "A cidade não pode ser nula/vazia.")
    @Size (max = 250, message = "Informe uma cidade válida, contendo até 250 caracteres.")
    private String cidade;

    @NotBlank(message = "O estado não pode ser nulo.")
    private String estado;

    @NotBlank(message = "O país não pode ser nulo.")
    private String pais;
}
