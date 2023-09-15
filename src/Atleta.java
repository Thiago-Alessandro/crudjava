public class Atleta extends Pessoa{

    private int quantiaMedalhas;
    private String modalidade;

    public Atleta(String cpf, String nome, int idade, int quantiaMedalhas, String modalidade) {
        super(cpf, nome, idade);
        this.quantiaMedalhas = quantiaMedalhas;
        this.modalidade = modalidade;

    }

    public void setQuantiaMedalhas(int quantiaMedalhas) {
        this.quantiaMedalhas = quantiaMedalhas;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    @Override
    public String toString() {
        return  "\n     ATLETA" +
                "\nCodigo: " + getCodigo() +
                "\nNome: " + getNome() +
                "\nCPF: " + getCpf() +
                "\nIdade: " + getIdade() +
                "\nMedalhas: " + quantiaMedalhas +
                "\nModalidade: " + modalidade + "\n";
    }
}
