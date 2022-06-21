// Nome: Willian Valentim;
// Stack: Back-End - Vem Ser DBC;

import java.util.Scanner;
public class Exercicio3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String nomeJogador;
        double altura = 0.0, maiorAltura = 0.0, somaTotalAlturas = 0.0, mediaDasAlturas = 0.0, peso = 0.0, maisPesado = 0.0;
        int idade, jogadorMaisVelho = 0, qntJogadores = 0, id = 1;

        System.out.println("Seja bem vindo ao Cadastro de Jogadores!");
        
        while(true) {
            System.out.println("Informe o nome do jogador que deseja cadastrar: ");
            nomeJogador = input.nextLine();
            
            // Caso o usuário deseje finalizar o programa;
            if (nomeJogador.equalsIgnoreCase("SAIR")) {
                System.out.println("Cadastro de jogadores finalizado!");
                break;
            }

            // Caso o usuário deseje cadastrar um novo jogador;
            System.out.println("Informe a altura do jogador (em m): ");
            altura = input.nextDouble();
            System.out.println("Informe a idade do jogador (em anos): ");
            idade = input.nextInt();
            System.out.println("Informe o peso do jogador (em kg): ");
            peso = input.nextDouble();
            input.nextLine();
            qntJogadores++;
            id++;

            // Armazenando os maiores valores;
            if (altura > maiorAltura) {
                maiorAltura = altura;
            }
            if (idade > jogadorMaisVelho) {
                jogadorMaisVelho = idade;
            }
            if (peso > maisPesado) {
                maisPesado = peso;
            }
            somaTotalAlturas += altura;
        }
        mediaDasAlturas = (double) somaTotalAlturas / id;

        // Exibindo os dados ao usuário;
        System.out.printf("\nQuantidade de jogadores cadastrados: %d;\nAltura do maior jogador: %6.2f m;\nJogador mais velho possui: %d anos;\nJogador mais pesado foi %s com: %6.2f kg;\nMédia das alturas: %6.2f m\n", qntJogadores, maiorAltura, jogadorMaisVelho, maisPesado, mediaDasAlturas);

        input.close();
    }
}