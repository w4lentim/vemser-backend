// Nome: Willian Valentim;
// Stack: Back-End - Vem Ser DBC;

import java.util.Arrays;
import java.util.Scanner;
public class Exercicio5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int array[] = new int[20];

        for(int i = 0; i < array.length; i++) {
            System.out.println("Digite um número para preencher o array: ");
            int numDigitado = input.nextInt();
            array[i] = numDigitado;
        }
        // Array na ordem que o usuário informou;
        System.out.println("Array informado: " + Arrays.toString(array));

        // Array na ordem inversa;
        for(int j = array.length - 1; j >= 0; j--) {
            System.out.println(array[j]);
        }
        input.close();
    }
}