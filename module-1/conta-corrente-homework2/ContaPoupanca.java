public class ContaPoupanca extends Conta implements Impressao {
    
    static final Double JUROS_MENSAL = 1.01;

    public ContaPoupanca(Cliente cliente, String numeroDaConta, Integer agencia, Double saldo) {
        super(cliente, numeroDaConta, agencia, saldo);
    }

    @Override
    public void imprimirDadosConta() {
        System.out.println("__________________"
        + "\nCliente: " + this.getCliente().getNome()
        + "\nNúmero da conta: " + this.getNumeroDaConta()
        + "\nNúmero da agência: " + this.getAgencia()
        + "\nSaldo: " + this.getSaldo()
        + "\nJuros mensal: " + JUROS_MENSAL);
    }

    public void creditarTaxa() {
        this.setSaldo(this.getSaldo() * JUROS_MENSAL);
    }
}
