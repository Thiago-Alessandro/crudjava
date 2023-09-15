public abstract class Eletronico{

    private double preco;
    private String marca;
    private int codigo;

    public Eletronico (double preco, String marca){
        this.preco = preco;
        this.marca = marca;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
