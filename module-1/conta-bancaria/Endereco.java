public class Endereco {

    // Variáveis da classe;
    int tipo; // (Se for 1, deverá informar o end. residencial; Se for 2, informar end. comercial);
    String logradouro;
    int numero;
    String complemento;
    String cep;
    String cidade;
    String estado;
    String pais;

    // Exibir o endereço do cliente;
    void imprimirEndereco() {
        switch (tipo) {
            case 1 -> {
                System.out.printf("\nEndereço residencial:\nLogradouro: %s\nNúmero: %d\nCEP: %s\nCidade: %s\nEstado: %s\nPaís: %s\n", logradouro, numero, cep, cidade, estado, pais);
            }
            case 2 -> {
                System.out.printf("\nEndereço comercial:\nLogradouro: %s\nNúmero: %d\nCEP: %s\nCidade: %s\nEstado: %s\nPaís: %s\n", logradouro, numero, cep, cidade, estado, pais);
            }
            default -> {
                System.out.println("Tipo de endereço inválido. Informe um tipo válido!");
            }
        }
    }
}