public class ContaCorrente extends Conta implements Impressao {

    private Double chequeEspecial;

    public ContaCorrente(Cliente cliente, String numeroDaConta, Integer agencia, Double saldo, Double chequeEspecial) {
        super(cliente, numeroDaConta, agencia, saldo);
        this.chequeEspecial = chequeEspecial;
    }

    public void setChequeEspecial(Double valor) {
        this.chequeEspecial = valor;
    }

    public Double retornarSaldoComChequeEspecial() {
        Double saldoTotal = this.getSaldo() + this.chequeEspecial;
        return saldoTotal;
    }

    @Override
    public boolean saque(Double valor) {
        if (valor <= (this.retornarSaldoComChequeEspecial()) && valor > 0) {
            this.setSaldo(this.getSaldo() - valor);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void imprimirDadosConta() {
        System.out.println("Cliente: " + this.getCliente() +
                "\nNúmero da conta: " + this.getNumeroDaConta() +
                "\nNúmero da agência: " + this.getAgencia() +
                "\nSaldo R$: " + this.getSaldo() +
                "\nCheque Especial R$: " + this.chequeEspecial);
    }
}
