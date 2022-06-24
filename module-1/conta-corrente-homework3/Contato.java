public class Contato {
    
    private String descricao;
    private String telefone;
    private Integer tipo;

    public Contato(String descricao, String telefone, Integer tipo) {
        this.descricao = descricao;
        this.telefone = telefone;
        this.tipo = tipo;
    }

    public void imprimirContato() {
        switch (getTipo()) {
            case 1 -> {
                System.out.println("\nContato Residencial: " + this.getTelefone());
            }
            case 2 -> {
                System.out.println("Contato Comercial: " + this.getTelefone());
                System.out.println("___________________________________");
            }
            default -> {
                System.out.println("Tipo de contato inválido. É necessário informar um tipo válido!");
            }
        }
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }
}
