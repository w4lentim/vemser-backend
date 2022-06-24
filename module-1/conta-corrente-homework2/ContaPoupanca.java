public class ContaPoupanca extends Conta implements Impressao {
    
    static final Double JUROS_MENSAL = 1.01;

    public ContaPoupanca(Cliente cliente, String numeroDaConta, Integer agencia, Double saldo) {
        super(cliente, numeroDaConta, agencia, saldo);
    }

    @Override
    public void imprimir() {
        System.out.println("__________________"
        + "\nCliente: " + this.getCliente().getNome()
        + "\nNúmero da conta Poupança: " + this.getNumeroDaConta()
        + "\nNúmero da agência: " + this.getAgencia()
        + "\nSaldo: " + this.getSaldo()
        + "\nJuros mensal: " + creditarTaxa());
    }

    public String creditarTaxa() {
        this.setSaldo(this.getSaldo() * JUROS_MENSAL);
        return "" + getSaldo();
    }
}
