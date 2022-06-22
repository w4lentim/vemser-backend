public class ContaCorrente {

    // Variáveis da classe;
    Cliente cliente;
    String numeroDaConta;
    int agencia;
    Double saldo = 0.0;
    Double chequeEspecial;

    // Imprimir conta corrente;
    void imprimirContaCorrente() {
        System.out.println("Cliente: " + cliente.nome +
                "\nNúmero da conta: " + numeroDaConta +
                "\nAgência: " + agencia +
                "\nSaldo R$: " + saldo +
                "\nCheque Especial R$: " + chequeEspecial);
    }

    // Validação para o saque na conta;
    boolean saque(double valor) {
        if (valor > 0 && (saldo + chequeEspecial) > valor) {
            saldo -= valor;
            return true;
        } else {
            return false;
        }
    }
    // Validação para o depósito na conta;
    boolean deposito(double valor) {
        if (valor > 0) {
            saldo += valor;
            return true;
        } else {
            return false;
        }
    }
    // Exibir ao usuário seu saldo da conta e do cheque especial;
    double retornarSaldoComCheque() {
        return saldo + chequeEspecial;
    }
    // Validação de transferência de valores entre as contas;
    boolean transferir(ContaCorrente numeroDaContaTransf, double valor) {
        if (valor > 0 && (saldo + chequeEspecial) > valor) {
            saldo -= valor;
            numeroDaContaTransf.saldo += valor;
            return true;
        } else {
            return false;
        }
    }
}