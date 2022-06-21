// Nome: Willian Valentim;
// Stack: Back-End - Vem Ser DBC;

import java.util.Scanner;
public class Exercicio5 {
    public static void main(String[] args) {
        // Obter os valores do usuário;
        Scanner entrada = new Scanner(System.in);

        System.out.println("Informe o valor da hora (em R$): ");
        double valorHora = entrada.nextDouble();
        System.out.println("O número de horas trabalhadas: ");
        int horasTrabalhadas = entrada.nextInt();
        System.out.println("O número de horas extras (meio-período): ");
        int horasExtras = entrada.nextInt();
        System.out.println("O número de horas extras (período completo): ");
        int horasExtrasTotais = entrada.nextInt();

        // Cálculo do salário do usuário com base nos dados informados;
        double salarioTotal = (horasTrabalhadas * valorHora) + (horasExtras * valorHora * 1.5) + (horasExtrasTotais * valorHora * 2);

        // Exibindo o salário do usuário;
        System.out.printf("\nObrigado pelas informações.\nSeu salário é de: R$: %.2f", salarioTotal);
        entrada.close();
    }
}
