public class ContaCorrente {

    // Variáveis da classe;
    Cliente cliente;
    String numeroDaConta;
    int agencia;
    Double saldo = 0.0;
    Double chequeEspecial = 0.0;

    // Imprimir conta corrente;
    void imprimirContaCorrente() {
        System.out.println("Cliente: " + this.cliente.nome +
                "\nNúmero da conta: " + this.numeroDaConta +
                "\nAgência: " + this.agencia +
                "\nSaldo R$: " + this.saldo +
                "\nCheque Especial R$: " + this.chequeEspecial);
    }

    // Validação para o saque na conta;
    boolean saque(double valor) {
        if (valor <= (this.saldo + this.chequeEspecial) && valor > 0) {
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
        return this.saldo + this.chequeEspecial;
    }
    // Validação de transferência de valores entre as contas;
    boolean transferir(ContaCorrente numeroDaContaTransf, double valor) {
        if (this.saque(valor)) {
            return numeroDaContaTransf.deposito(valor);
        } else {
            return false;
        }
    }
}