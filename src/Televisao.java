public class Televisao extends Eletronico{

    private boolean ligada = false;
    private double polegadas;

    public Televisao(double preco, String marca, double polegadas) {
        super(preco, marca);
        this.polegadas = polegadas;
    }

    public void setPolegadas(double polegadas) {
        this.polegadas = polegadas;
    }

    @Override
    public String toString() {
        return  "\n     TELEVISAO" +
                "\nCodigo: " + getCodigo() +
                "\nPreco: " + getPreco() +
                "\nMarca: " + getMarca() +
                "\nPolegadas: " + polegadas+
                "\nTelevisao ligada: " + ligada + "\n";
    }

}
