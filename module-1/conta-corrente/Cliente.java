public class Cliente {

    // Variáveis da classe;
    String nome;
    String cpf;
    Contato[] contatos = new Contato[2];
    Endereco[] enderecos = new Endereco[2];

    // Exibir contatos do cliente de acordo com o contido na classe Contato.java;
    void imprimirContatos() {
        for(int i = 0; i < contatos.length; i++) {
            if (contatos[i] != null) {
                contatos[i].imprimirContato();
            }
        }
    }

    // Exibir o endereço do cliente de acordo com o contido na classe Endereco.java;
    void imprimirEnderecos() {
        for(int j = 0; j < enderecos.length; j++) {
            if(enderecos[j] != null) {
                enderecos[j].imprimirEndereco();
            }
        }
    }

    // Exibir os dados do cliente;
    void imprimirCliente() {
        System.out.println("Nome do cliente: " + this.nome +
        "\nCPF: " + this.cpf);
    }
}