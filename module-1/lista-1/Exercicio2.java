// Nome: Willian Valentim;
// Stack: Back-End - Vem Ser DBC;

import java.util.Scanner;
public class Exercicio2 {
    public static void main(String[] args) {
        // Scanner para obter as notas do aluno;
        Scanner entrada = new Scanner(System.in);

        System.out.println("Informe sua primeira nota: ");
        double primeiraNota = entrada.nextDouble();
        System.out.println("Informe sua segunda nota: ");
        double segundaNota = entrada.nextDouble();
        System.out.println("Informe sua terceira nota: ");
        double terceiraNota = entrada.nextDouble();
        System.out.println("Informe sua quarta nota: ");
        double quartaNota = entrada.nextDouble();

        // Calculando a média das notas;
        double mediaNotas = (primeiraNota + segundaNota + terceiraNota + quartaNota) / 4;

        System.out.printf("Sua média foi: %.2f\n", mediaNotas);

        // Avaliação da média do aluno;
        if (mediaNotas >= 0 && mediaNotas <= 5) {
            System.out.println("Você foi reprovado.");
        } else if (mediaNotas >= 5.1 && mediaNotas <= 6.9) {
            System.out.println("Você está em exame.");
        } else {
            System.out.println("Você foi aprovado. Parabéns!");
        }
        entrada.close();
    }
}