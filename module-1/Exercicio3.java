// Nome: Willian Valentim;
// Stack: Back-End - Vem Ser DBC;

import java.util.Scanner;
public class Exercicio3 {
    public static void main(String[] args) {
        // Scanner para obter os valores do usuário;
        Scanner entrada = new Scanner(System.in);

        System.out.println("Informe o valor total consumido (em R$): ");
        double valorConsumido = entrada.nextDouble();
        System.out.println("Informe o valor pago pelo cliente (em R$): ");
        double valorPago = entrada.nextDouble();

        if (valorPago < valorConsumido) {
            System.out.println("O valor pago deve ser maior ou igual ao valor consumido!");
        } else if (valorPago >= valorConsumido) {
            double troco = valorPago - valorConsumido;
            System.out.printf("\nO troco do cliente é de R$: %.2f\n", troco);
        }
    }
}
