public class Cliente {

    // Variáveis da classe;
    String nome;
    String cpf;
    Contato[] contatos = new Contato[2];
    Endereco[] enderecos = new Endereco[2];

    // Exibir contatos do cliente de acordo com o contido na classe Contato.java;
    void imprimirContatos() {
        for (Contato con : contatos) {
            con.imprimirContato();
        }
    }

    // Exibir o endereço do cliente de acordo com o contido na classe Endereco.java;
    void imprimirEnderecos() {
        for (Endereco end : enderecos) {
            end.imprimirEndereco();
        }
    }

    // Exibir os dados do cliente;
    void imprimirCliente() {
        System.out.println("Nome do cliente: " + nome +
        "\nCPF: " + cpf);
    }
}