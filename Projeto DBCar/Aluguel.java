public class Aluguel extends Carro {
    
    private Usuario usuario;
    private Carro carro;
    private Integer idAluguel;
    private Integer diaDoAluguel;
    private Integer diaDaEntrega;

    public Aluguel(Integer id, String nomeCarro, String marca, String classe, Integer qntPassageiros, Integer kmRodados, Double valorDouble, Usuario usuario, Carro carro, Integer idAluguel, Integer diaDoAluguel, Integer diaDaEntrega) {
        super(id, nomeCarro, marca, classe, qntPassageiros, kmRodados, valorDouble);
        this.usuario = usuario;
        this.carro = carro;
        this.idAluguel = idAluguel;
        this.diaDoAluguel = diaDoAluguel;
        this.diaDaEntrega = diaDaEntrega;
    }

    public Integer imprimirDiasComCarro() {
        Integer diasTotais = this.getDiaDaEntrega() - this.getDiaDoAluguel();
        return diasTotais;
    }

    public Double calcularDiarias() {
        Double valorDiarias = 0.0;
        if (carro.getClasse().equals("C")) {
            valorDiarias = imprimirDiasComCarro() * carro.getPrecoDiaria();
        } else if (carro.getClasse().equals("B")) {
            valorDiarias = imprimirDiasComCarro() * carro.getPrecoDiaria() * 1.2;
        } else if (carro.getClasse().equals("A")) {
            valorDiarias = imprimirDiasComCarro() * carro.getPrecoDiaria() * 1.5;
        } else {
            System.out.println("O carro informado não está disponível.");
        }
        return valorDiarias;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public Integer getIdAluguel() {
        return idAluguel;
    }

    public void setIdAluguel(Integer idAluguel) {
        this.idAluguel = idAluguel;
    }

    public Integer getDiaDoAluguel() {
        return diaDoAluguel;
    }

    public void setDiaDoAluguel(Integer diaDoAluguel) {
        this.diaDoAluguel = diaDoAluguel;
    }

    public Integer getDiaDaEntrega() {
        return diaDaEntrega;
    }

    public void setDiaDaEntrega(Integer diaDaEntrega) {
        this.diaDaEntrega = diaDaEntrega;
    } 
}