public class Cliente extends Usuario {
    
    private Integer idCliente;
    private String cpf;
    private String telefone;
    private String endereco;

    public Cliente(Integer idCliente, String nome, String cpf, String telefone, String endereco) {
        this.idCliente = idCliente;
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public void imprimir() {
        System.out.println("Nome do Cliente: " + this.getNome() + "\nCPF: " + this.getCpf());
    }
}