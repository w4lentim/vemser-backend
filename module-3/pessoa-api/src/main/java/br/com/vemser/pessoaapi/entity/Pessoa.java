package br.com.vemser.pessoaapi.entity;

import lombok.*;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pessoa {

    private Integer idPessoa;

    @NotBlank(message = "O nome não pode ser nulo/vazio/conter somente espaços.")
    private String nome;

    @Past
    @NotNull
    private LocalDate dataNascimento;

    @NotBlank
    @Size(min = 11, max = 11, message = "O CPF deve conter 11 números.")
    private String cpf;
}
