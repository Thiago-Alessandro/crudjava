public class Forno extends Eletronico{

    private double temperaturaMax;
    private boolean ligado = false;
    private boolean luzInternaLigada = false;

    public Forno(double preco, String marca, double temperaturaMax) {
        super(preco, marca);
        this.temperaturaMax = temperaturaMax;
    }

    public void setLuzInternaLigada(boolean luzInternaLigada) {
        this.luzInternaLigada = luzInternaLigada;
    }

    public void setLigado(boolean ligado) {
        this.ligado = ligado;
    }

    public void setTemperaturaMax(double temperatura) {
        this.temperaturaMax = temperatura;
    }

    @Override
    public String toString() {
        return  "\n     FORNO" +
                "\nCodigo: " + getCodigo() +
                "\nPreco: " + getPreco() +
                "\nMarca: " + getMarca() +
                "\nTemperatura máxima: " + temperaturaMax+
                "\nLuz ligada: " + luzInternaLigada +
                "\nForno ligado: " + ligado + "\n";
    }

}
