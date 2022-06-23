public class Main {
    public static void main(String[] args) {
        
        // Configurando dados para o cliente 1;
        Cliente cliente1 = new Cliente();
        cliente1.nome = "Willian Valentim";
        cliente1.cpf = "123.456.789-10";

        Contato contato1 = new Contato();
        Contato contato2 = new Contato();

        contato1.descricao = "Telefone celular";
        contato1.telefone = "(85) 92223-4442";
        contato1.tipo = 1;
        contato2.descricao = "Telefone fixo";
        contato2.telefone = "(85) 3333-3210";
        contato2.tipo = 2;

        cliente1.contatos[0] = contato1;
        cliente1.contatos[1] = contato2;

        Endereco endereco1 = new Endereco();
        Endereco endereco2 = new Endereco();

        endereco1.tipo = 1;
        endereco1.logradouro = "Rua Travessa Gama";
        endereco1.numero = 847;
        endereco1.complemento = "Próximo ao centro";
        endereco1.cep = "12345-678";
        endereco1.cidade = "Maranguape";
        endereco1.estado = "Ceará";
        endereco1.pais = "Brasil";
        
        endereco2.tipo = 2;
        endereco2.logradouro = "Rua Travessa Quinderé";
        endereco2.numero = 123;
        endereco2.complemento = "Próximo a rodoviária";
        endereco2.cep = "89101-112";
        endereco2.cidade = "Maranguape";
        endereco2.estado = "Ceará";
        endereco2.pais = "Brasil";

        cliente1.enderecos[0] = endereco1;
        cliente1.enderecos[1] = endereco2;

        // Configurando conta para o cliente 1;
        ContaCorrente clienteConta1 = new ContaCorrente();

        clienteConta1.cliente = cliente1;
        clienteConta1.numeroDaConta = "00001";
        clienteConta1.agencia = 1010;
        clienteConta1.saldo = 1000.00;
        clienteConta1.chequeEspecial = 550.00;

        // Configurando dados para o cliente 2;
        Cliente cliente2 = new Cliente();
        cliente2.nome = "Natanael Silva";
        cliente2.cpf = "101.111.222-33";

        Contato contato11 = new Contato();
        Contato contato22 = new Contato();

        contato11.descricao = "Telefone celular";
        contato11.telefone = "(85) 91234-5567";
        contato11.tipo = 1;
        contato22.descricao = "Telefone fixo";
        contato22.telefone = "(85) 3144-5566";
        contato22.tipo = 2;

        cliente2.contatos[0] = contato11;
        cliente2.contatos[1] = contato22;

        Endereco endereco11 = new Endereco();
        Endereco endereco22 = new Endereco();

        endereco11.tipo = 1;
        endereco11.logradouro = "Rua Raul Barbosa";
        endereco11.numero = 0101;
        endereco11.complemento = "Próximo ao centro";
        endereco11.cep = "11223-342";
        endereco11.cidade = "Fortaleza";
        endereco11.estado = "Ceará";
        endereco11.pais = "Brasil";
        
        endereco22.tipo = 2;
        endereco22.logradouro = "Rua Padre Antonino";
        endereco22.numero = 1010;
        endereco22.complemento = "Próximo a Av. Antonio Sales";
        endereco22.cep = "44556-677";
        endereco22.cidade = "Fortaleza";
        endereco22.estado = "Ceará";
        endereco22.pais = "Brasil";

        cliente2.enderecos[0] = endereco11;
        cliente2.enderecos[1] = endereco22;

        // Configurando conta para o Cliente 2;
        ContaCorrente clienteConta2 = new ContaCorrente();

        clienteConta2.cliente = cliente2;
        clienteConta2.numeroDaConta = "00002";
        clienteConta2.agencia = 0202;
        clienteConta2.saldo = 1500.00;
        clienteConta2.chequeEspecial = 1050.00;

        // Operando na conta do cliente 1;
        clienteConta1.imprimirContaCorrente();

        // Depósito e saque na conta do cliente 1;
        clienteConta1.deposito(200.00);
        clienteConta1.saque(100.00);
        System.out.printf("\nSaldo do Cheque Especial da conta R$: %.2f\n", clienteConta1.retornarSaldoComCheque());
        System.out.printf("--------------------------------------\n");

        // Operando na conta do cliente 2;
        clienteConta2.imprimirContaCorrente();
        // Depósito e saque na conta do cliente 2;
        clienteConta2.deposito(1200.00);
        clienteConta2.saque(200.00);
        System.out.printf("\nSaldo do Cheque Especial da conta R$: %.2f\n", clienteConta2.retornarSaldoComCheque());
        System.out.printf("--------------------------------------\n");

        // Efetuando transferência cliente 1 -> cliente 2;
        clienteConta1.transferir(clienteConta2, 200);
        clienteConta1.imprimirContaCorrente();
        System.out.printf("--------------------------------------\n");
        // Efetuando transferência cliente 2 -> cliente 1;
        clienteConta2.transferir(clienteConta1, 100);
        clienteConta2.imprimirContaCorrente();
    }
}
