// Nome: Willian Valentim;
// Stack: Back-End - Vem Ser DBC;

import java.util.Scanner;
public class Exercicio8 {
    public static void main(String[] args) {
        // Scanner para obter os valores do usuário;
        Scanner entrada = new Scanner(System.in);

        System.out.println("Informe o tamanho da base do retângulo (em cm): ");
        double base = entrada.nextDouble();

        System.out.println("Informe o tamanho da altura do retângulo (em cm): ");
        double altura = entrada.nextDouble();

        // Fórmula: A = base * altura;
        double areaRetangulo = base * altura;

        System.out.printf("De acordo com os dados informados, o retângulo possui uma área de: %.2f cm²\n", areaRetangulo);
    }
}
