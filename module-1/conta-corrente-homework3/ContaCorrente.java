public class ContaCorrente extends Conta implements Impressao {
    
    private Double chequeEspecial;

    public ContaCorrente(Cliente cliente, String numeroDaConta, String agencia, Double saldo, Double chequeEspecial) {
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
    public boolean sacar(Double valor) {
        if ((this.retornarSaldoComChequeEspecial()) >= valor && valor > 0) {
            this.setSaldo(this.getSaldo() - valor);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void imprimir() {
        System.out.println("Cliente: " + this.getCliente() + "\nNúmero da Conta Corrente: " + this.getNumeroDaConta() + "\nNúmero da agência: " + this.getAgencia() + "\nSaldo da conta: " + this.getSaldo() + "\nSaldo cheque especial: " + this.chequeEspecial);
    }
}
