// Nome: Willian Valentim;
// Stack: Back-End - Vem Ser DBC;
/* OBS: O exercício foi resolvido com base no que foi ensinado na primeira aula sobre a linguagem. Contudo, não foi realizado nenhum tratamento de erro caso o usuário informe um valor incorreto. */

import java.util.Scanner;
public class Exercicio1 {
    public static void main(String[] args) {

        // Scanner para obter as informações do usuário e declarar as variáveis;
        Scanner entrada = new Scanner(System.in);

        System.out.println("Seja bem vindo, por favor, informe seu nome: ");
        String nome = entrada.nextLine();

        System.out.println("Sua idade: ");
        int idade = entrada.nextInt();

        System.out.println("A cidade em que mora: ");
        String cidade = entrada.next();

        System.out.println("Estado: ");
        String estado = entrada.next();

        // Exibindo os dados informados ao usuário;
        System.out.printf("\nOlá! Seu nome é %s, você tem %d anos, é da cidade de %s, situada no estado de %s.\n", nome, idade, cidade, estado);
    }
}