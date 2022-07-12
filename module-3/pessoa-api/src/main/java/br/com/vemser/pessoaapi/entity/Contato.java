package br.com.vemser.pessoaapi.entity;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contato {

    private Integer idContato;
    private Integer idPessoa;
    private String tipo;
    private String numero;
    private String descricao;

}
