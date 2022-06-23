public class Endereco {

    // Variáveis da classe;
    private Integer tipo; // (Se for 1, deverá informar o end. residencial; Se for 2, informar end. comercial);
    private String logradouro;
    private Integer numero;
    private String complemento;
    private String cep;
    private String cidade;
    private String estado;
    private String pais;

    public Endereco(Integer tipo, String logradouro, Integer numero, String complemento, String cep, String cidade, String estado, String pais) {
        this.tipo = tipo;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
    }

    // Exibir o endereço do cliente;
    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
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

    void imprimirEndereco() {
        switch (getTipo()) {
            case 1 -> {
                System.out.printf("\nEndereço residencial:\nLogradouro: %s\nNúmero: %d\nCEP: %s\nCidade: %s\nEstado: %s\nPaís: %s\n", this.getLogradouro(), this.getNumero(), this.getCep(), this.getCidade(), this.getEstado(), this.getPais());
            }
            case 2 -> {
                System.out.printf("\nEndereço comercial:\nLogradouro: %s\nNúmero: %d\nCEP: %s\nCidade: %s\nEstado: %s\nPaís: %s\n", this.getLogradouro(), this.getNumero(), this.getCep(), this.getCidade(), this.getEstado(), this.getPais());
            }
            default -> {
                System.out.println("Tipo de endereço inválido. Informe um tipo válido!");
            }
        }
    }
}