package br.com.vemser.pessoaapi.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PessoaCreateDTO {

    @NotBlank(message = "O nome não pode ser nulo/vazio/conter somente espaços.")
    private String nome;

    @Past
    @NotNull
    private LocalDate dataNascimento;

    @NotBlank
    @Size(min = 11, max = 11, message = "O CPF deve conter 11 números.")
    private String cpf;

    @NotBlank
    private String email;
}
