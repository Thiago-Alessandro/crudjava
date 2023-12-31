public class Microondas extends Eletronico{

    private int potencia = 100;
    private int temporizador = 0;

    public Microondas(double preco, String marca) {
        super(preco, marca);
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    @Override
    public String toString() {
        return  "\n     MICROONDAS" +
                "\nCodigo: " + getCodigo() +
                "\nPreco: " + getPreco() +
                "\nMarca: " + getMarca() +
                "\nPotencia: " + potencia +
                "\nTemporizador: " + temporizador + "\n";
    }

}
