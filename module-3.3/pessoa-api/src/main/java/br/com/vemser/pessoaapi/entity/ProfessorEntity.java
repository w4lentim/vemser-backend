package br.com.vemser.pessoaapi.entity;


import br.com.vemser.pessoaapi.entity.pk.ProfessorPK;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity(name = "PROFESSOR")
@Getter
@Setter
//@DynamicUpdate(lembrar)
public class ProfessorEntity {

    @EmbeddedId
    private ProfessorPK professorPK;

    @Column(name = "nome")
    private String nome;

    @Column(name = "salario")
    private Double salario;
}
