// Nome: Willian Valentim;
// Stack: Back-End - Vem Ser DBC;

import java.util.Scanner;
public class Exercicio7 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int matriz[][] = new int[4][4];
        /* Exemplo matriz: {
            { 1, 2, 3, 4 },
            { 5, 6, 7, 8 },
            { 9, 10, 11, 12 },
            { 13, 14, 15 16 }
        } */
        int count = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.printf("\nElemento que ficará na %d ª linha e %d ª coluna: ", i, j);
                int infoValor = entrada.nextInt();
                matriz[i][j] = infoValor;
                if (infoValor > 10) {
                    count += 1;
                }
            }
        }
        System.out.println("A matriz possui " + count + " valores maiores que 10.");
        entrada.close();
    }
}
