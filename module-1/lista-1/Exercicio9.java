// Nome: Willian Valentim;
// Stack: Back-End - Vem Ser DBC;
/* OBS: Não tenho certeza se a interpretação da questão foi correta pois o enunciado está meio confuso. Mas deve servir como resultado parcial.*/

import java.util.Scanner;
public class Exercicio9 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int anos;
        int meses;
        int dias;

        System.out.println("Informe sua idade (somente em anos): ");
        anos = entrada.nextInt();
        System.out.println("Informe sua idade (somente em meses): ");
        meses = entrada.nextInt();
        System.out.println("Informe sua idade (somente em dias): ");
        dias = entrada.nextInt();

        int idadeEmDias = dias + (anos * 365) + (meses * 30);

        System.out.printf("Sua idade em dias é: %d dias de vida.", idadeEmDias);

        entrada.close();
    }
}
