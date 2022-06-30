public class Funcionario extends Usuario {
    
    private Integer idFuncionario;
    private String matricula;


    public Funcionario(Integer idFuncionario, String matricula) {
        this.idFuncionario = idFuncionario;
        this.matricula = matricula;
    }

    public Integer getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public void imprimir() {
        System.out.println("Nome do funcionário: " + this.getNome() + "\nMatrícula do Funcionário: " + this.getMatricula());
    }
}
