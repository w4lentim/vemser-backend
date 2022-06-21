// Nome: Willian Valentim;
// Stack: Back-End - Vem Ser DBC;

import java.util.Scanner;
public class Exercicio10 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        // Solicitar os valores pelo usuário;
        System.out.println("Informe a quantidade de eleitores do município: ");
        int eleitores = entrada.nextInt();
        System.out.println("Informe a quantidade de votos brancos obtidos: ");
        int brancos = entrada.nextInt();
        System.out.println("Informe a quantidade de votos nulos obtidos: ");
        int nulos = entrada.nextInt();
        System.out.println("Informe a quantidade de votos válidos: ");
        int validos = entrada.nextInt();

        /* Para o cálculo do percentual, foi utilizado uma conversão estrita. Caso a conversão não fosse aplicada, ao exibir o percentual dos votos, teríamos um valor igual a 0, pois estaríamos dividindo um valor int e seu resultado será um double/float */
        double percentualValidos = ((double)validos / eleitores) * 100;
        double percentualNulos = ((double)nulos / eleitores) * 100;
        double percentualBrancos = ((double)brancos / eleitores) * 100;

        System.out.printf("\nFoi obtido um total de %6.1f%% de votos brancos;\n", percentualBrancos);
        System.out.printf("\nFoi obtido um total de %6.1f%% votos nulos;\n", percentualNulos);
        System.out.printf("\nFoi obtido um total de %6.1f%% votos válidos.\n", percentualValidos);

        entrada.close();
    }
}
