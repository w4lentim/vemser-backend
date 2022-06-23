public class Cliente {

    private String nome;
    private String cpf;
    private Contato[] contatos = new Contato[2];
    private Endereco[] enderecos = new Endereco[2];

    public Cliente(String nome, String cpf, Contato[] contatos, Endereco[] enderecos) {
        this.nome = nome;
        this.cpf = cpf;
        this.contatos = contatos;
        this.enderecos = enderecos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Contato[] getContatos() {
        return contatos;
    }

    public void setContatos(int i, Contato contatos) {
        if (i <= 2) {
            this.contatos[i] = contatos;
        }
    }

    public Endereco[] getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(int j, Endereco enderecos) {
        if (j <= 2) {
            this.enderecos[j] = enderecos;
        }
    }

    void imprimirContatos() {
        for(int i = 0; i < contatos.length; i++) {
            if (contatos[i] != null) {
                contatos[i].imprimirContato();
            }
        }
    }

    void imprimirEnderecos() {
        for(int j = 0; j < enderecos.length; j++) {
            if(enderecos[j] != null) {
                enderecos[j].imprimirEndereco();
            }
        }
    }

    void imprimirCliente() {
        System.out.println("\nNome do cliente: " + getNome() +
        "\nCPF: " + getCpf());
    }

    @Override
    public String toString() {
        return getNome();
    }
}