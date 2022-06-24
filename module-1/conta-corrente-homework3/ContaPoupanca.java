public class ContaPoupanca extends Conta implements Impressao {
    
    static final Double JUROS_MENSAL = 1.01;

    public ContaPoupanca(Cliente cliente, String numeroDaConta, String agencia, Double saldo) {
        super(cliente, numeroDaConta, agencia, saldo);
    }

    @Override
    public void imprimir() {
        System.out.println("Cliente: " + this.getCliente() +
        "\nNúmero da Conta Poupança: " + this.getNumeroDaConta() +
        "\nNúmero da agência: " + this.getAgencia() +
        "\nSaldo da conta: " + this.getSaldo() +
        "\nJuros mensal: " + this.creditarTaxa());
    }

    public String creditarTaxa() {
        this.setSaldo(this.getSaldo() * JUROS_MENSAL);
        return " " + getSaldo();
    }
}
