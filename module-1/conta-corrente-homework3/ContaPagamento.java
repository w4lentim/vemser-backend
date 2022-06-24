public class ContaPagamento extends Conta implements Impressao {
    
    static final Double TAXA_SAQUE = 4.25;

    public ContaPagamento(Cliente cliente, String numeroDaConta, String agencia, Double saldo) {
        super(cliente, numeroDaConta, agencia, saldo);
    }

    @Override
    public boolean sacar(Double valor) {
        if (valor < (this.getSaldo() + TAXA_SAQUE) && valor > 0) {
            this.setSaldo(this.getSaldo() - valor);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean transferir(Conta numeroConta, Double valor) {
        if (this.getSaldo() >= valor && valor > 0) {
            return numeroConta.depositar(valor);
        } else {
            return false;
        }
    }

    @Override
    public void imprimir() {
        System.out.println("Cliente: " + this.getCliente() + "\nNúmero da Conta de Pagamento: " + this.getNumeroDaConta() + "\nNúmero da agência: " + this.getAgencia() + "\nSaldo da conta: " + this.getSaldo());
    }
}
