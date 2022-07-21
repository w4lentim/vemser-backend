package br.com.vemser.pessoaapi.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RelatorioPersonalizadoDTO {

    private Integer idPessoa;
    private String nome;
    private String email;
    private String numero;
    private String cep;
    private String cidade;
    private String estado;
    private String pais;
    private String nomePet;
}
