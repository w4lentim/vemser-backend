// Nome: Willian Valentim;
// Stack: Back-End - Vem Ser DBC;

import java.util.Scanner;
public class Exercicio7 {
    public static void main(String[] args) {
        // Scanner para receber os valores das variáveis do usuário;
        Scanner entrada = new Scanner(System.in);

        // Declarando uma variável temporária para armazenar o valor e realizar a troca;
        int temp;

        System.out.println("Valor da variável A: ");
        int a = entrada.nextInt();
        System.out.println("Valor da variável B: ");
        int b = entrada.nextInt();

        // Atribuindo os valores e realizando a troca das variáveis;
        temp = a;
        a = b;
        b = temp;

        System.out.printf("Valor das variáveis:\nA: %d\nB: %d\n", a, b);

        entrada.close();
    }
}
