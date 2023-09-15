import java.util.ArrayList;

public class Funcionario extends Pessoa{
    
    private String cadastro;
    private String profissao;

    public Funcionario(String cpf, String nome, int idade, String cadastro, String profissao) {
        super(cpf, nome, idade);
        this.cadastro = cadastro;
        this.profissao = profissao;
    }

    public void setCadastro(String cadastro) {
        this.cadastro = cadastro;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    @Override
    public String toString() {
        return  "\n     FUNCIONARIO" +
                "\nCodigo: " + getCodigo() +
                "\nNome: " + getNome() +
                "\nCPF: " + getCpf() +
                "\nIdade: " + getIdade() +
                "\nCadastro: " + cadastro +
                "\nProfissao: " + profissao + "\n";
    }

}
