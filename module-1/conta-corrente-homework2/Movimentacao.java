public interface Movimentacao {
    
    public boolean sacar(Double valor);
    public boolean depositar(Double valor);
    public boolean transferir(Conta numeroConta, Double valor);
    
}
