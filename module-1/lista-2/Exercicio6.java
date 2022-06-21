// Nome: Willian Valentim;
// Stack: Back-End - Vem Ser DBC;

import java.util.Scanner;
public class Exercicio6 {
    // Método para buscar o número informado pelo user;
    static void buscarValor(int array[], int num) {
        int inicio = 0;
        int fim = array.length - 1;
        boolean encontrou = false;

        while(inicio <= fim) {
            int meio = (int) (inicio + fim) / 2;
            if(array[meio] == num) {
                encontrou = true;
                break;
            } else if (array[meio] < num) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }
        if(encontrou) {
            System.out.println("Número informado foi encontrado no array.");
        } else {
            System.out.println("O número informado não foi encontrado no array.");
        };
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int array[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        System.out.println("Número que deseja pesquisar no array: ");
        int numBusca = input.nextInt();

        buscarValor(array, numBusca);
        input.close();
    }
}