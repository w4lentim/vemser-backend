import java.util.Scanner;
public class Exercicio4 {

    // Criar um método para percorrer o array e buscar a posição do menor valor. Em seguida, armazenar a posição do menor valor encontrado.
    static void posicaoMenorValor(int vetor[]) {
        int posicao = 0;
        for(int j = 0; j < vetor.length - 1; j++) {
            if(vetor[j] < vetor.length && vetor[j] < vetor[j + 1]) {
                posicao = j;
            }
        }
        System.out.println("Menor valor: " + posicao);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Vetor com tamanho estático;
        int vetor[] = new int[3];
        
        // Estrutura de repetição para adicionar o números digitados pelo usuário nas posições do vetor.
        for(int i = 0; i < vetor.length; i++) {
            System.out.println("Número na posição " + i);
            int numDigitado = input.nextInt();
            vetor[i] = numDigitado;
        }
        posicaoMenorValor(vetor);
        input.close();
    }
}