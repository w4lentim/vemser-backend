public class Carro implements Operacoes {
    
    private Integer idCarro;
    private String nomeCarro;
    private String marca;
    private String classe;
    private Integer qntPassageiros;
    private Integer kmRodados;
    private Double precoDiaria;

    public Carro(Integer idCarro, String nomeCarro, String marca, String classe, Integer qntPassageiros, Integer kmRodados, Double precoDiaria) {
        this.idCarro = idCarro;
        this.nomeCarro = nomeCarro;
        this.marca = marca;
        this.classe = classe;
        this.qntPassageiros = qntPassageiros;
        this.kmRodados = kmRodados;
        this.precoDiaria = precoDiaria;
    }

    public void alugar(Integer id) {
        if (listaCarros != null) {
            
        }
    }

    public Integer getIdCarro() {
        return idCarro;
    }

    public void setIdCarro(Integer idCarro) {
        this.idCarro = idCarro;
    }

    public String getNomeCarro() {
        return nomeCarro;
    }

    public void setNomeCarro(String nomeCarro) {
        this.nomeCarro = nomeCarro;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public Integer getQntPassageiros() {
        return qntPassageiros;
    }

    public void setQntPassageiros(Integer qntPassageiros) {
        this.qntPassageiros = qntPassageiros;
    }

    public Integer getKmRodados() {
        return kmRodados;
    }

    public void setKmRodados(Integer kmRodados) {
        this.kmRodados = kmRodados;
    }

    public Double getPrecoDiaria() {
        return precoDiaria;
    }

    public void setPrecoDiaria(Double precoDiaria) {
        this.precoDiaria = precoDiaria;
    }
}
