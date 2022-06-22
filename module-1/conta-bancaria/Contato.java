public class Contato {

    // Variáveis da classe;
    String descricao;
    String telefone;
    int tipo; // Se o contato for 1, informar residencial, se for 2, comercial;

    // Retornando os dados ao usuário;
    void imprimirContato() {
        switch (tipo) {
            case 1 -> {
                System.out.printf("\nContato residencial: %s\n", telefone);
            }
            case 2 -> {
                System.out.printf("\nContato comercial: %s\n", telefone);
            }
            default -> {
                System.out.println("Tipo de contato inválido. É necessário informar um tipo válido!");
            }
        }
    }
}