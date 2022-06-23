public class Main {
    public static void main(String[] args) {
        
        // INÍCIO DA CONFIGURAÇÃO PARA CRIAR CONTA PRIMEIRO CLIENTE -------------------------- //
        Contato primeiroClienteContato1 = new Contato("Telefone celular", "(85) 92223-4442", 1);
        Contato primeiroClienteContato2 = new Contato("Telefone fixo", "(85) 3333-3210", 2);

        Endereco primeiroClienteEndereco1 = new Endereco(1, "Rua Travessa Gama", 847, "Próximo ao centro", "12345-678", "Maranguape", "Ceará", "Brasil");
        Endereco primeiroClienteEndereco2 = new Endereco(2, "Rua Travessa Quinderé", 123, "Próximo a rodoviária", "89101-112", "Maranguape", "Ceará", "Brasil");

        Cliente primeiroCliente = new Cliente("Willian Valentim", "111.222.333-44", new Contato[]{primeiroClienteContato1, primeiroClienteContato2}, new Endereco[]{primeiroClienteEndereco1, primeiroClienteEndereco2});

        ContaCorrente primeiroClienteConta = new ContaCorrente(primeiroCliente, "00001", 1010, 1000.00, 550.00);
        // FINALIZAÇÃO DA CONTA DO PRIMEIRO CLIENTE ---------------------------------------- //

        // INÍCIO DA CONFIGURAÇÃO PARA CRIAR CONTA SEGUNDO CLIENTE ------------------------- //
        Contato segundoClienteContato1 = new Contato("Telefone celular", "(85) 91234-5567", 1);
        Contato segundoClienteContato2 = new Contato("Telefone fixo", "(85) 3144-5566", 2);

        Endereco segundoClienteEndereco1 = new Endereco(1, "Rua Raul Barbosa", 0101, "Próximo ao centro", "11223-342", "Fortaleza", "Ceará", "Brasil");
        Endereco segundoClienteEndereco2 = new Endereco(2, "Rua Padre Antonino", 1010, "Próximo a Av. Antônio Sales", "44556-677", "Fortaleza", "Ceará", "Brasil");

        Cliente segundoCliente = new Cliente("Wesley Valentim", "555.666.777-88", new Contato[]{segundoClienteContato1, segundoClienteContato2}, new Endereco[]{segundoClienteEndereco1, segundoClienteEndereco2});

        ContaCorrente segundoClienteConta = new ContaCorrente(segundoCliente, "00002", 2020, 1500.00, 1100.00);
        // FINALIZAÇÃO DA CONTA DO SEGUNDO CLIENTE ---------------------------------------- //

        // IMPRIMINDO DADOS DO CLIENTE 1;
        primeiroCliente.imprimirCliente();
        System.out.println("___________________________________");

        primeiroCliente.imprimirContatos();
        System.out.println("___________________________________");

        primeiroCliente.imprimirEnderecos();
        System.out.println("___________________________________");

        primeiroClienteConta.imprimirDadosConta();
        System.out.println("___________________________________");
        // FIM DA IMPRESSÃO DOS DADOS CLIENTE 1;

        // OPERAÇÕES DE SAQUE/DEPOSITO NA CONTA DO CLIENTE 1;
        primeiroClienteConta.deposito(200.00);
        primeiroClienteConta.saque(100.00);
        System.out.printf("\nSaldo do Cheque Especial da conta R$: %.2f\n", primeiroClienteConta.retornarSaldoComChequeEspecial());
        System.out.println("___________________________________");
        // FIM DAS OPERAÇÕES;

        // IMPRIMINDO DADOS DO CLIENTE 2;
        segundoCliente.imprimirCliente();
        System.out.println("___________________________________");

        segundoCliente.imprimirContatos();
        System.out.println("___________________________________");

        segundoCliente.imprimirEnderecos();
        System.out.println("___________________________________");

        segundoClienteConta.imprimirDadosConta();
        System.out.println("___________________________________");
        // FIM DA IMPRESSÃO DOS DADOS CLIENTE 2;

        // OPERAÇÕES DE SAQUE/DEPOSITO NA CONTA DO CLIENTE 2;
        segundoClienteConta.deposito(1200.00);
        segundoClienteConta.saque(200.00);
        System.out.printf("\nSaldo do Cheque Especial da conta R$: %.2f\n", segundoClienteConta.retornarSaldoComChequeEspecial());

        // TRANSAÇÕES ENTRE AS CONTAS 1 E 2 (CONTA 1 --> CONTA 2);
        primeiroClienteConta.transferir(segundoClienteConta, 200);
        System.out.println("___________________________________");
        primeiroClienteConta.imprimirDadosConta();
        System.out.println("___________________________________");

        // TRANSAÇÕES ENTRE AS CONTAS 1 E 2 (CONTA 2 --> CONTA 1);
        segundoClienteConta.transferir(primeiroClienteConta, 100);
        segundoClienteConta.imprimirDadosConta();
        System.out.println("___________________________________");
    }
}
