// Nome: Willian Valentim;
// Stack: Back-End - Vem Ser DBC;

import java.util.Arrays;
import java.util.Scanner;
public class Exercicio5 {

    static void arrayInvertido(int array[]) {
        int inicio = 0;
        int fim = array.length - 1;
        int temp;
        while(inicio < fim) {
            temp = array[inicio];
            array[inicio] = array[fim];
            array[fim] = temp;

            inicio++;
            fim--;
        }
        System.out.println("Array invertido: " + Arrays.toString(array));
    }
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
        arrayInvertido(array);
        input.close();
    }
}