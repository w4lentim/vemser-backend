import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        Contato primeiroContatoCliente1 = new Contato("Celular", "(85) 91111-2222", 1);
        Contato segundoContatoCliente1 = new Contato("Fixo", "(85) 1111-2222", 2);

        Contato primeiroContatoCliente2 = new Contato("Celular", "(85) 93333-4444", 1);
        Contato segundoContatoCliente2 = new Contato("Fixo", "(85) 3333-4444", 2);

        Endereco primeiroEnderecoCliente1 = new Endereco(1, "Rua João Barbosa", 11, "A", "11111-222", "Maranguape",
                "Ceará", "Brasil");
        Endereco segundoEnderecoCliente1 = new Endereco(2, "Rua José Cavalcante Prata", 1, "B", "33333-444",
                "Maranguape", "Ceará", "Brasil");

        Endereco primeiroEnderecoCliente2 = new Endereco(1, "Rua Maria Gonzaga", 5, "C", "55555-666", "Fortaleza",
                "Ceará", "Brasil");
        Endereco segundoEnderecoCliente2 = new Endereco(2, "Rua Antônio Sales", 6, "D", "77777-888", "Fortaleza",
                "Ceará", "Brasil");

        ArrayList<Contato> contatosCliente1 = new ArrayList<>();
        ArrayList<Contato> contatosCliente2 = new ArrayList<>();
        ArrayList<Endereco> enderecosCliente1 = new ArrayList<>();
        ArrayList<Endereco> enderecosCliente2 = new ArrayList<>();

        Collections.addAll(contatosCliente1, primeiroContatoCliente1, segundoContatoCliente1);
        Collections.addAll(contatosCliente2, primeiroContatoCliente2, segundoContatoCliente2);
        Collections.addAll(enderecosCliente1, primeiroEnderecoCliente1, segundoEnderecoCliente1);
        Collections.addAll(enderecosCliente2, primeiroEnderecoCliente2, segundoEnderecoCliente2);

        Cliente cliente1 = new Cliente("Willian Valentim", "111.222.333-44", contatosCliente1, enderecosCliente1);
        Cliente cliente2 = new Cliente("Wesley Valentim", "555.666.777-88", contatosCliente2, enderecosCliente2);

        ContaPagamento contaPagamentoCliente1 = new ContaPagamento(cliente1, "1111", "042-1", 5000.00);
        ContaCorrente contaCorrenteCliente1 = new ContaCorrente(cliente1, "2222", "034-6", 2000.00, 1500.00);
        ContaPoupanca contaPoupancaCliente2 = new ContaPoupanca(cliente2, "3333", "481-2", 8000.00);

        // FASE DE OPERAÇÕES (IMPRESSÃO DOS DADOS DOS CLIENTES, SAQUE, DEPÓSITO E
        // TRANSF.);

        // CLIENTE 1;
        cliente1.imprimirCliente();
        cliente1.imprimirContatos();
        cliente1.imprimirEnderecos();
        System.out.println("___________________________________");

        // CLIENTE 2;
        cliente2.imprimirCliente();
        cliente2.imprimirContatos();
        cliente2.imprimirEnderecos();
        System.out.println("___________________________________");

        // DADOS DE CONTA CLIENTE 1;
        contaCorrenteCliente1.imprimir();
        System.out.println("___________________________________");
        contaPagamentoCliente1.imprimir();
        System.out.println("___________________________________");

        // DEPÓSITO, SAQUE E TRANS NA CONTA CORRENTE DO CLIENTE 1 //
        System.out.println("TESTES CLIENTE 1 (CONTA CORRENTE)");
        System.out.println("\nSaldo disponível na Conta Corrente: " + contaCorrenteCliente1.getSaldo());
        contaCorrenteCliente1.sacar(300.00);
        System.out.println("\nSaldo disponível na Conta Corrente após o saque: " + contaCorrenteCliente1.getSaldo());
        System.out.println("___________________________________");

        // DEPOSITO NA CONTA CORRENTE CLIENTE 1;
        contaCorrenteCliente1.depositar(7000.00);
        System.out.println("\nSaldo após o depósito: " + contaCorrenteCliente1.getSaldo());
        System.out.println("___________________________________");

        // TRANSFERÊNCIA DA CONTA CORRENTE CLIENTE 1 PARA CONTA PAGAMENTO CLIENTE 1;
        System.out.println("\nSaldo da Conta Corrente antes da transferência: " + contaCorrenteCliente1.getSaldo());
        System.out.println("\nSaldo da Conta Pagamento antes da transferência: " + contaPagamentoCliente1.getSaldo());
        contaCorrenteCliente1.transferir(contaPagamentoCliente1, 300.00);
        System.out.println("\nSaldo da Conta Corrente após a transferência: " + contaCorrenteCliente1.getSaldo());
        System.out.println("\nSaldo da Conta Pagamento após receber a transferência: " + contaPagamentoCliente1.getSaldo());
        System.out.println("___________________________________");

        // DEPÓSITO E SAQUE NA CONTA PAGAMENTO CLIENTE 1;
        System.out.println("TESTES CLIENTE 1 (CONTA PAGAMENTO)");
        System.out.println("\nSaldo disponível em sua Conta Pagamento: " + contaPagamentoCliente1.getSaldo());
        contaPagamentoCliente1.sacar(300.00);
        System.out.println("\nSaldo disponível na Conta Pagamento após o saque: " + contaPagamentoCliente1.getSaldo());
        System.out.println("___________________________________");

        contaPagamentoCliente1.depositar(2000.00);
        System.out.println("\nSaldo após o depósito: " + contaPagamentoCliente1.getSaldo());
        System.out.println("___________________________________");

        // DEPOSITO, SAQUE E TRANSF. NA CONTA POUPANÇA CLIENTE 2;
        System.out.println("TESTES CLIENTE 2 (CONTA POUPANÇA)");
        System.out.println("\nSaldo na Conta Poupança: " + contaPoupancaCliente2.getSaldo());
        contaPoupancaCliente2.sacar(500.00);
        System.out.println("\nSaldo na Conta Poupança após o saque: " + contaPoupancaCliente2.getSaldo());
        System.out.println("___________________________________");

        System.out.println("\nSaldo na Conta Poupança: " + contaPoupancaCliente2.getSaldo());
        contaPoupancaCliente2.depositar(600.00);
        System.out.println("\nSaldo na Conta Poupança após o depósito: " + contaPoupancaCliente2.getSaldo());
        System.out.println("___________________________________");

        System.out.println("(TRANSF. POUPANÇA -> CORRENTE E PAGAMENTO)");
        System.out.println("\nSaldo na Conta Poupança antes da transferência: " + contaPoupancaCliente2.getSaldo());
        System.out.println("\nSaldo na Conta Corrente (cliente 1) antes da transferência: " + contaCorrenteCliente1.getSaldo());
        System.out.println("\nSaldo na Conta Pagamento (cliente 1) antes da transferência: " + contaPagamentoCliente1.getSaldo());
        System.out.println("___________________________________");
        contaPoupancaCliente2.transferir(contaCorrenteCliente1, 500.00);
        contaPoupancaCliente2.transferir(contaPagamentoCliente1, 300.00);
        System.out.println("\nSaldo na Conta Poupança após da transferência: " + contaPoupancaCliente2.getSaldo());
        System.out.println("\nSaldo na Conta Corrente (cliente 1) após a transferência: " + contaCorrenteCliente1.getSaldo());
        System.out.println("\nSaldo na Conta Pagamento (cliente 1) após a transferência: " + contaPagamentoCliente1.getSaldo());
        System.out.println("___________________________________");

        System.out.println("IMPRIMINDO OS DADOS FINAIS DAS CONTAS:\n");
        contaCorrenteCliente1.imprimir();
        System.out.println("___________________________________");
        contaPagamentoCliente1.imprimir();
        System.out.println("___________________________________");
        contaPoupancaCliente2.imprimir();

        

    }
}