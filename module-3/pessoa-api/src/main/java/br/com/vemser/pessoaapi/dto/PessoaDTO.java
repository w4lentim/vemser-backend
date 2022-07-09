package br.com.vemser.pessoaapi.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PessoaDTO extends PessoaCreateDTO {

    private Integer idPessoa;

}
