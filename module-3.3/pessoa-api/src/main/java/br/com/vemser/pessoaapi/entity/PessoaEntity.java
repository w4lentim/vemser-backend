package br.com.vemser.pessoaapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Entity(name = "PESSOA")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PessoaEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PESSOA_SEQ")
    @SequenceGenerator(name = "PESSOA_SEQ", sequenceName = "seq_pessoa2", allocationSize = 1)
    @Column(name = "ID_PESSOA")
    private Integer idPessoa;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "DATA_NASCIMENTO")
    private LocalDate dataNascimento;

    @Column(name = "CPF")
    private String cpf;

    @Column(name = "EMAIL")
    private String email;

    // ER PESSOA <-> CONTATO
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pessoaEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ContatoEntity> contatoEntitySet;

    // ER PESSOA <-> PESSOA X ENDERECO
    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "PESSOA_X_PESSOA_ENDERECO", joinColumns = @JoinColumn(name = "ID_PESSOA"), inverseJoinColumns = @JoinColumn(name = "ID_ENDERECO"))
    private Set<EnderecoEntity> enderecoEntitySet;

    // ER PESSOA <-> PET
    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PET", referencedColumnName = "ID_PET")
    private PetEntity petEntity;
}
