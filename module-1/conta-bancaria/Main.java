public class Main {
    public static void main(String[] args) {
        
        // Configurando dados para o usuário 1;
        Cliente usuario1 = new Cliente();
        usuario1.nome = "Willian Valentim";
        usuario1.cpf = "12345678910";

        Contato contato1 = new Contato();
        Contato contato2 = new Contato();

        contato1.descricao = "Telefone celular";
        contato1.telefone = "85981828384";
        contato1.tipo = 1;
        contato2.descricao = "Telefone fixo";
        contato2.telefone = "30333434";
        contato2.tipo = 2;

        usuario1.contatos[0] = contato1;
        usuario1.contatos[1] = contato2;

        Endereco endereco1 = new Endereco();
        Endereco endereco2 = new Endereco();

        endereco1.tipo = 1;
        endereco1.logradouro = "Rua Travessa Gama";
        endereco1.numero = 847;
        endereco1.complemento = "Próximo ao centro";
        endereco1.cep = "12345678";
        endereco1.cidade = "Maranguape";
        endereco1.estado = "Ceará";
        endereco1.pais = "Brasil";
        
        endereco2.tipo = 2;
        endereco2.logradouro = "Rua Travessa Quinderé";
        endereco2.numero = 123;
        endereco2.complemento = "Próximo a rodoviária";
        endereco2.cep = "89101112";
        endereco2.cidade = "Maranguape";
        endereco2.estado = "Ceará";
        endereco2.pais = "Brasil";

        usuario1.enderecos[0] = endereco1;
        usuario1.enderecos[1] = endereco2;

        // Configurando conta para o usuário 1;
        ContaCorrente usuarioConta1 = new ContaCorrente();

        usuarioConta1.cliente = usuario1;
        usuarioConta1.numeroDaConta = "00001";
        usuarioConta1.agencia = 1010;
        usuarioConta1.saldo = 1000.00;
        usuarioConta1.chequeEspecial = 550.00;

        // Configurando dados para o usuário 2;
        Cliente usuario2 = new Cliente();
        usuario2.nome = "Natanael Silva";
        usuario2.cpf = "10111122233";

        Contato contato11 = new Contato();
        Contato contato22 = new Contato();

        contato11.descricao = "Telefone celular";
        contato11.telefone = "8591234567";
        contato11.tipo = 1;
        contato22.descricao = "Telefone fixo";
        contato22.telefone = "31445566";
        contato22.tipo = 2;

        usuario2.contatos[0] = contato11;
        usuario2.contatos[1] = contato22;

        Endereco endereco11 = new Endereco();
        Endereco endereco22 = new Endereco();

        endereco11.tipo = 1;
        endereco11.logradouro = "Rua Raul Barbosa";
        endereco11.numero = 0101;
        endereco11.complemento = "Próximo ao centro";
        endereco11.cep = "11223342";
        endereco11.cidade = "Fortaleza";
        endereco11.estado = "Ceará";
        endereco11.pais = "Brasil";
        
        endereco22.tipo = 2;
        endereco22.logradouro = "Rua Padre Antonino";
        endereco22.numero = 1010;
        endereco22.complemento = "Próximo a Av. Antonio Sales";
        endereco22.cep = "44556677";
        endereco22.cidade = "Fortaleza";
        endereco22.estado = "Ceará";
        endereco22.pais = "Brasil";

        usuario2.enderecos[0] = endereco11;
        usuario2.enderecos[1] = endereco22;

        // Configurando conta para o usuário 2;
        ContaCorrente usuarioConta2 = new ContaCorrente();

        usuarioConta2.cliente = usuario2;
        usuarioConta2.numeroDaConta = "00002";
        usuarioConta2.agencia = 0202;
        usuarioConta2.saldo = 1500.00;
        usuarioConta2.chequeEspecial = 1050.00;

        // Exibir os dados das contas e clientes;
        usuario1.imprimirCliente();
        usuario1.imprimirContatos();
        usuario1.imprimirEnderecos();
        usuarioConta1.imprimirContaCorrente();
        usuarioConta1.deposito(200.00);
        usuarioConta1.saque(100.00);
        System.out.printf("\nSaldo do Cheque Especial da conta R$: %.2f\n", usuarioConta1.retornarSaldoComCheque());

        usuario2.imprimirCliente();
        usuario2.imprimirContatos();
        usuario2.imprimirEnderecos();
        usuarioConta2.imprimirContaCorrente();
        usuarioConta2.deposito(1200.00);
        usuarioConta2.saque(200.00);
        System.out.printf("\nSaldo do Cheque Especial da conta R$: %.2f\n", usuarioConta2.retornarSaldoComCheque());

        // Efetuando transferência entre as contas;
        usuarioConta1.transferir(usuarioConta2, 200);
        usuarioConta1.imprimirContaCorrente();

        usuarioConta2.transferir(usuarioConta1, 100);
        usuarioConta1.imprimirContaCorrente();
    }
}
