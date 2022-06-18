// Nome: Willian Valentim;
// Stack: Back-End - Vem Ser DBC;

import java.util.Scanner;
public class Exercicio10 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        int eleitores, brancos, nulos, validos;
        double percentualBrancos, percentualNulos, percentualValidos;

        System.out.println("Informe a quantidade de eleitores do município: ");
        eleitores = entrada.nextInt();
        System.out.println("Informe a quantidade de votos brancos obtidos: ");
        brancos = entrada.nextInt();
        System.out.println("Informe a quantidade de votos nulos obtidos: ");
        nulos = entrada.nextInt();
        System.out.println("Informe a quantidade de votos válidos: ");
        validos = entrada.nextInt();

        /* Para o cálculo do percentual, foi utilizado uma conversão estrita. Caso a conversão não fosse aplicada, ao exibir o percentual dos votos, teríamos um valor igual a 0, pois estaríamos dividindo um valor int e seu resultado será um double/float */
        percentualValidos = ((double)validos / eleitores) * 100;
        percentualNulos = ((double)nulos / eleitores) * 100;
        percentualBrancos = ((double)brancos / eleitores) * 100;

        System.out.printf("\nFoi obtido um total de %6.1f%% de votos brancos;\n", percentualBrancos);
        System.out.printf("\nFoi obtido um total de %6.1f%% votos nulos;\n", percentualNulos);
        System.out.printf("\nFoi obtido um total de %6.1f%% votos válidos.\n", percentualValidos);
    }
}
