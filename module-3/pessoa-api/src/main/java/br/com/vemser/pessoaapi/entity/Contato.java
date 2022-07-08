package br.com.vemser.pessoaapi.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Contato {

    private Integer idContato;
    private Integer idPessoa;
    @NotBlank(message = "O tipo de contato não pode ser vazio/nulo/conter somente espaços.")
    private String tipo;
    @NotBlank(message = "Não é possível ter um número nulo/vazio/conter somente espaços.")
    @Size(max = 13)
    private String numero;
    @NotBlank (message = "É necessário informar uma descrição para o telefone. Não é possível ter uma descrição vazia/nula/conter somente espaços!")
    private String descricao;

    public Contato() {};

    public Contato(Integer idContato, Integer idPessoa, String tipo, String numero, String descricao) {
        this.idContato = idContato;
        this.idPessoa = idPessoa;
        this.tipo = tipo;
        this.numero = numero;
        this.descricao = descricao;
    }

    public Integer getIdContato() {
        return idContato;
    }

    public void setIdContato(Integer idContato) {
        this.idContato = idContato;
    }

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Contato{" +
                "idContato=" + idContato +
                ", idPessoa=" + idPessoa +
                ", tipo='" + tipo + '\'' +
                ", numero='" + numero + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
