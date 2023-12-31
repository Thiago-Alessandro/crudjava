import java.util.ArrayList;

public class Aluno extends Pessoa{

    private String matricula;
    private String instituicaoEnsino;

    public Aluno(String cpf, String nome, int idade, String matricula, String instituicaoEnsino) {
        super(cpf, nome, idade);
        this.matricula = matricula;
        this.instituicaoEnsino = instituicaoEnsino;
    }

    public void setInstituicaoEnsino(String instituicaoEnsino) {
        this.instituicaoEnsino = instituicaoEnsino;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return  "\n     ALUNO" +
                "\nCodigo: " + getCodigo() +
                "\nNome: " + getNome() +
                "\nCPF: " + getCpf() +
                "\nIdade: " + getIdade() +
                "\nMatricula: " + matricula +
                "\nInstituicao de ensino: " + instituicaoEnsino + "\n";
    }

}
