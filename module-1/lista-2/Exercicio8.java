// Nome: Willian Valentim;
// Stack: Back-End - Vem Ser DBC;

import java.util.Scanner;
public class Exercicio8 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int matriz[][] = new int[5][4];

        int notaFinalMaior = 0, matriculaMaiorNotaFinal = 0, somaNotasFinais = 0;
        double mediaNotasFinais = 0.0;
        
        // Cadastro das informações na matriz;
        for (int i = 0; i < 5; i++) {
            System.out.printf("\nInforme os dados do %d aluno: \n", i + 1);
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    System.out.println("Informe a matrícula: ");
                    matriz[i][j] = input.nextInt();
                } else if (j == 1) {
                    System.out.println("Informe a média das provas: ");
                    matriz[i][j] = input.nextInt();
                } else if (j == 2) {
                    System.out.println("Informe a média dos trabalhos: ");
                    matriz[i][j] = input.nextInt();
                }
            }
        }
        // Cálculo e atribuição do valor da média final dos alunos;
        for (int k = 0; k < 5; k++) {
            matriz[k][3] = (int) (matriz[k][1] * 0.6 + matriz[k][2] * 0.4);
            somaNotasFinais += matriz[k][3];
            if (matriz[k][3] > notaFinalMaior) {
                notaFinalMaior = matriz[k][3];
                matriculaMaiorNotaFinal = matriz[k][0];
            }
        }

        // Cálculo da média das notas finais;
        mediaNotasFinais = (double) somaNotasFinais / 5;
        System.out.printf("\nMatricula do aluno com maior nota %d : Com nota igual a: %d\n", matriculaMaiorNotaFinal, notaFinalMaior);
        System.out.printf("\nMédia das notas finais dos alunos: %6.2f\n", mediaNotasFinais);

        input.close();
    }
}
