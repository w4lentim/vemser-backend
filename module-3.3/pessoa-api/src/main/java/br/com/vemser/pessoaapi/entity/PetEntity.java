package br.com.vemser.pessoaapi.entity;

import br.com.vemser.pessoaapi.enums.TipoDoPet;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity(name = "PET")
@NoArgsConstructor
@AllArgsConstructor
public class PetEntity implements Serializable {

    @Id
    @SequenceGenerator(name = "PET_SEQ", sequenceName = "SEQ_PET", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PET_SEQ")
    @Column(name = "ID_PET")
    private Integer idPet;

    @Column(name = "ID_PESSOA", insertable = false, updatable = false)
    private Integer idPessoa;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "TIPO")
    @Enumerated(EnumType.ORDINAL)
    private TipoDoPet tipo;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PESSOA", referencedColumnName = "ID_PESSOA")
    private PessoaEntity pessoaEntity;
}
