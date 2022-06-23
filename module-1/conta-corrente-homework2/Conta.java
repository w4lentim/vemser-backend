public abstract class Conta implements Movimentacao {

    private Cliente cliente;
    private String numeroDaConta;
    private Integer agencia;
    private Double saldo;
    
    public Conta(Cliente cliente, String numeroDaConta, Integer agencia, Double saldo) {
        this.cliente = cliente;
        this.numeroDaConta = numeroDaConta;
        this.agencia = agencia;
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public String getNumeroDaConta() {
        return numeroDaConta;
    }
    public void setNumeroDaConta(String numeroDaConta) {
        this.numeroDaConta = numeroDaConta;
    }
    public Integer getAgencia() {
        return agencia;
    }
    public void setAgencia(Integer agencia) {
        this.agencia = agencia;
    }
    public Double getSaldo() {
        return saldo;
    }
    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public boolean sacar(Double valor) {
        if (valor <= (this.getSaldo()) && valor > 0) {
            this.setSaldo(this.getSaldo() - valor);
            return true;
        } else {
            return false;
        }
    }

    public boolean depositar(Double valor) {
        if (valor > 0) {
            this.setSaldo(this.getSaldo() + valor);
            return true;
        } else {
            return false;
        }
    }

    public boolean transferir(Conta numeroConta, Double valor) {
        if (this.sacar(valor)) {
            return numeroConta.depositar(valor);
        } else {
            return false;
        }
    }
}
