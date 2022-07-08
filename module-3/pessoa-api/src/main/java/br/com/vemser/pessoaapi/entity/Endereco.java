package br.com.vemser.pessoaapi.entity;

import javax.validation.constraints.*;

public class Endereco {

    private Integer idEndereco;

    private Integer idPessoa;
    @NotBlank(message = "O tipo de endereço deve ser RESIDENCIAL/COMERCIAL.")
    private String tipo;
    @NotBlank
    @Size (max = 100, message = "Informe um logradouro válido, contendo até 100 caracteres.")
    private String logradouro;
    @NotNull(message = "O número da residência não pode ser nulo.")
    private Integer numero;
    private String complemento;
    @NotBlank(message = "Informe um CEP válido. O CEP não pode ser nulo/vazio/conter somente espaços.")
    @Size(min = 8, max = 8, message = "O CEP deve conter 8 números.")
    private String cep;
    @NotBlank(message = "Informe uma cidade válida. A cidade não pode ser nula/vazia/conter somente espaços.")
    private String cidade;
    @NotBlank(message = "Informe um estado válido. O estado não pode ser nulo/vazio/conter somente espaços.")
    private String estado;
    @NotBlank(message = "Informe um país válido. O país não pode ser nulo/vazio/conter somente espaços.")
    private String pais;

    public Endereco() {}

    public Endereco(Integer idEndereco, Integer idPessoa, String tipo, String logradouro, Integer numero, String complemento, String cep, String cidade, String estado, String pais) {
        this.idEndereco = idEndereco;
        this.idPessoa = idPessoa;
        this.tipo = tipo;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
    }

    public Integer getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
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

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "idEndereco=" + idEndereco +
                ", idPessoa=" + idPessoa +
                ", tipo='" + tipo + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", numero=" + numero +
                ", complemento='" + complemento + '\'' +
                ", cep='" + cep + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", pais='" + pais + '\'' +
                '}';
    }
}
