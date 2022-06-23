public class Contato {

    // Variáveis da classe;
    private String descricao;
    private String telefone;
    private Integer tipo; // Se o contato for 1, informar residencial, se for 2, comercial;

    public Contato (String descricao, String telefone, Integer tipo){
        this.descricao = descricao;
        this.telefone = telefone;
        this.tipo = tipo;
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

    // Retornando os dados ao usuário;
    void imprimirContato() {
        switch (getTipo()) {
            case 1 -> {
                System.out.printf("\nContato residencial: %s\n", this.getTelefone());
            }
            case 2 -> {
                System.out.printf("\nContato comercial: %s\n", this.getTelefone());
            }
            default -> {
                System.out.println("Tipo de contato inválido. É necessário informar um tipo válido!");
            }
        }
    }
}