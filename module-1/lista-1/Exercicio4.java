// Name: Willian Valentim;
// Stack: Back-End - Vem Ser DBC;

import java.util.Scanner;
public class Exercicio4 {
    public static void main(String[] args) {
        // Scanner para obter a cidade escolhida pelo usuário;
        Scanner entrada = new Scanner(System.in);

        int estadoEscolhido;

        System.out.println("Estados disponíveis para consulta:\n1 - Ceará;\n2 - Rio Grande do Norte;\n3 - Piauí.");
        estadoEscolhido = entrada.nextInt();

        if (estadoEscolhido == 1) {
            int cidadeEscolhida;

            System.out.println("Cidades disponíveis no Ceará para consulta:\n1 - Fortaleza\n2 - Juazeiro do Norte");
            cidadeEscolhida = entrada.nextInt();

            if (cidadeEscolhida == 1) {
                int populacao = 2703391;
                double idh = 0.754;
                String festa = "Carnaval de Fortaleza";
                System.out.printf("População de Fortaleza: %d habitantes\nIDH: %.3f\nPrincipal festa: %s\n", populacao, idh, festa);
            } else if (cidadeEscolhida == 2) {
                int populacao = 278264;
                double idh = 0.694;
                String festa = "Juaforró";
                System.out.printf("População de Juazeiro do Norte: %d habitantes\nIDH: %.3f\nPrincipal festa: %s\n", populacao, idh, festa);
            }
        } else if (estadoEscolhido == 2) {
            int cidadeEscolhida;

            System.out.println("Cidades disponíveis no Rio Grande do Norte para consulta:\n1 - Mossoró\n2 - Natal");
            cidadeEscolhida = entrada.nextInt();

            if (cidadeEscolhida == 1) {
                int populacao = 303792;
                double idh = 0.720;
                String festa = "Quadrilhas";
                System.out.printf("População de Mossoró: %d habitantes\nIDH: %.3f\nPrincipal festa: %s\n", populacao, idh, festa);
            } else if (cidadeEscolhida == 2) {
                int populacao = 896708;
                double idh = 0.763;
                String festa = "Reis Magos";
                System.out.printf("População de Natal: %d habitantes\nIDH: %.3f\nPrincipal festa: %s\n", populacao, idh, festa);
            }
        } else if (estadoEscolhido == 3) {
            int cidadeEscolhida;

            System.out.println("Cidades disponíveis no Piauí para consulta:\n1 - Teresina\n2 - Parnaíba");
            cidadeEscolhida = entrada.nextInt();

            if (cidadeEscolhida == 1) {
                int populacao = 871126;
                double idh = 0.751;
                String festa = "Piauí Fest Music";
                System.out.printf("População de Teresina: %d habitantes\nIDH: %.3f\nPrincipal festa: %s\n", populacao, idh, festa);
            } else if (cidadeEscolhida == 2) {
                int populacao = 183482;
                double idh = 0.789;
                String festa = "Festa de São Francisco";
                System.out.printf("População de Parnaíba: %d habitantes\nIDH: %.3f\nPrincipal festa: %s\n", populacao, idh, festa);
            }
        } else {
            System.out.println("Estado informado inválido ou não disponível para consulta.");
        }
        entrada.close();
    }
}
