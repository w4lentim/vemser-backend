public abstract class Conta implements Movimentacao {
    
    private Cliente cliente;
    private String numeroDaConta;
    private String agencia;
    private Double saldo;

    public Conta(Cliente cliente, String numeroDaConta, String agencia, Double saldo) {
        this.cliente = cliente;
        this.numeroDaConta = numeroDaConta;
        this.agencia = agencia;
        this.saldo = saldo;
    }

    @Override
    public boolean sacar(Double valor) {
        if ((this.getSaldo()) >= valor && valor > 0) {
            this.setSaldo(this.getSaldo() - valor);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean depositar(Double valor) {
        if (valor > 0) {
            this.setSaldo(this.getSaldo() + valor);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean transferir(Conta numeroConta, Double valor) {
        if (this.sacar(valor)) {
            return numeroConta.depositar(valor);
        } else {
            return false;
        }
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

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
}