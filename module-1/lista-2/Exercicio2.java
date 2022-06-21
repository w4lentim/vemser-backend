// Nome: Willian Valentim;
// Stack: Back-End - Vem Ser DBC;

import java.util.Scanner;
public class Exercicio2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Digite um número para o usuário adivinhar: ");
        int numAdivinhar = input.nextInt();

        // Estrutura de repetição para advinhar o número:
        while(true) {
            System.out.println("Adivinhe o número: ");
            int palpite = input.nextInt();
            if (palpite < numAdivinhar) {
                System.out.println("Você errou!");
                System.out.println("O número que você informou é menor.");
            } else if (palpite > numAdivinhar) {
                System.out.println("Você errou!");
                System.out.println("O número que você informou é maior.");
            } else {
                System.out.println("Parabéns, você acertou!");
                System.out.println("Número imaginado: " + palpite);
                break;
            }
        }
        input.close();
    }
}
