// Nome: Willian Valentim;
// Stack: Back-End - Vem Ser DBC;

import java.util.Scanner;
public class Exercicio1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Obtendo as variáveis de compras do usuário;
        System.out.println("Informe o nome do produto: ");
        String nomeProduto = input.nextLine();
        System.out.println("Informe o preço do produto (em R$): ");
        float precoProduto = input.nextFloat();

        // Exibindo o produto e seu valor;
        System.out.println("Produto: " + nomeProduto);
        System.out.println("Preço R$: " + precoProduto);
        System.out.println("--------------------------");

        // Estrutura de repetição para exibir o desconto de acordo com o n° de unidades;
        for(int i = 1, j = 5; i <= 10; i++, j += 5) {
            // Calculando o desconto para o número de quantidades;
            float desc = precoProduto - (((float)j / 100) * precoProduto);
            float result = ((float)i * desc);
            // Exibindo a lista para o usuário;
            System.out.printf("\n%d x R$: %.2f = R$: %.2f\n", i, desc, result);
        }
        input.close();
    }
}