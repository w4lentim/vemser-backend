import java.util.ArrayList;

public class Cliente {
    
    private String nome;
    private String cpf;
    private ArrayList<Contato> contatos = new ArrayList<>();
    private ArrayList<Endereco> enderecos = new ArrayList<>();

    public Cliente(String nome, String cpf, ArrayList<Contato> contatos, ArrayList<Endereco> enderecos) {
        this.nome = nome;
        this.cpf = cpf;
        this.contatos = contatos;
        this.enderecos = enderecos;
    }

    public void imprimirCliente() {
    if (this.getNome() != null && this.getCpf() != null)
        System.out.println("\nNome do Cliente: " + getNome() + "\nCPF: " + getCpf());
        System.out.println("___________________________________");
    }

    @Override
    public String toString() {
        return getNome();
    }

    public void imprimirContatos() {
        if (contatos != null) {
            for (int i = 0; i < getContatos().size(); i++) {
                if (contatos.get(i) != null) {
                    contatos.get(i).imprimirContato();
                }
            }
        }
    }

    public void imprimirEnderecos() {
        if (contatos != null) {
            for (int j = 0; j < getEnderecos().size(); j++) {
                if (enderecos.get(j) != null) {
                    enderecos.get(j).imprimirEndereco();
                }
            }
        }
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

    public ArrayList<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(ArrayList<Contato> contatos) {
        this.contatos = contatos;
    }

    public ArrayList<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(ArrayList<Endereco> enderecos) {
        this.enderecos = enderecos;
    }
}
