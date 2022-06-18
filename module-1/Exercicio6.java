// Nome: Willian Valentim;
// Stack: Back-End - Vem Ser DBC;
/* OBS: Código bastante extenso e que pode ser reduzido o número de condicionais, entretanto, resolvi solucionar o problema apenas com o conteúdo que foi passado em aula, servindo também como exemplo de código que pode futuramente ser reduzido com boas práticas mais avançadas. */

import java.util.Scanner;
public class Exercicio6 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Em qual idioma deseja ver o catálogo de palavras?\n1 - Inglês;\n2 - Português;\nSua escolha: ");
        int escolhaCatalogo = entrada.nextInt();

        if (escolhaCatalogo == 1) {
            System.out.println("Words avaliable for translation:\n1 - Dog;\n2 - Time;\n3 - Love;\n4 - City;\n5 - Happy;\n6 - Sad;\n7 - Should;\n8 - Could;\nYour choice: ");

            int palavraEscolhida = entrada.nextInt();
            
            if (palavraEscolhida == 1) {
                System.out.println("Dog in Portuguese is: Cachorro");
            } else if (palavraEscolhida == 2) {
                System.out.println("Time in Portuguese is: Tempo");
            } else if (palavraEscolhida == 3) {
                System.out.println("Love in Portuguese is: Amor");
            } else if (palavraEscolhida == 4) {
                System.out.println("City in Portuguese is: Cidade");
            } else if (palavraEscolhida == 5) {
                System.out.println("Happy in Portuguese is: Feliz");
            } else if (palavraEscolhida == 6) {
                System.out.println("Sad in Portuguese is: Triste");
            } else if (palavraEscolhida == 7) {
                System.out.println("Should in Portuguese is: Deveria");
            } else if (palavraEscolhida == 8) {
                System.out.println("Could in Portuguese is: Poderia");
            } else {
                System.out.println("Selected word is not available for translation");
            }
        } else if (escolhaCatalogo == 2) {
            System.out.println("Palavras disponíveis para tradução:\n1 - Cachorro;\n2 - Tempo;\n3 - Amor;\n4 - Cidade;\n5 - Feliz;\n6 - Triste;\n7 - Deveria;\n8 - Poderia;\nSua escolha: ");

            int palavraEscolhida = entrada.nextInt();
            
            if (palavraEscolhida == 1) {
                System.out.println("Cachorro em Inglês é: Dog");
            } else if (palavraEscolhida == 2) {
                System.out.println("Tempo em Inglês é: Time");
            } else if (palavraEscolhida == 3) {
                System.out.println("Amor em Inglês é: Love");
            } else if (palavraEscolhida == 4) {
                System.out.println("Cidade em Inglês: City");
            } else if (palavraEscolhida == 5) {
                System.out.println("Feliz em Inglês: Happy");
            } else if (palavraEscolhida == 6) {
                System.out.println("Triste em Inglês: Sad");
            } else if (palavraEscolhida == 7) {
                System.out.println("Deveria em Inglês: Should");
            } else if (palavraEscolhida == 8) {
                System.out.println("Poderia em Inglês: Could");
            } else {
                System.out.println("Palavra selecionada não está disponível para tradução.");
            }
        } else {
            System.out.println("Não há palavras disponíveis para o que você escolheu.");
        }
    }
}