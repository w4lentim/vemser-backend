package br.com.vemser.pessoaapi.entity;

import br.com.vemser.pessoaapi.enums.TipoDeEndereco;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity(name = "ENDERECO_PESSOA")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoEntity implements Serializable {

    @Id
    @SequenceGenerator(name = "ENDERECO_SEQ", sequenceName = "SEQ_ENDERECO_CONTATO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ENDERECO_SEQ")
    @Column(name = "ID_ENDERECO")
    private Integer idEndereco;

    @Column(name = "TIPO")
    private TipoDeEndereco tipo;

    @Column(name = "LOGRADOURO")
    private String logradouro;

    @Column(name = "NUMERO")
    private Integer numero;

    @Column(name = "COMPLEMENTO")
    private String complemento;

    @Column(name = "CEP")
    private String cep;

    @Column(name = "CIDADE")
    private String cidade;

    @Column(name = "ESTADO")
    private String estado;

    @Column(name = "PAIS")
    private String pais;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "PESSOA_X_PESSOA_ENDERECO", joinColumns = @JoinColumn(name = "ID_ENDERECO"), inverseJoinColumns = @JoinColumn(name = "ID_PESSOA"))
    private Set<PessoaEntity> pessoaEntitySet;
}
