import java.util.ArrayList;

public class Microondas extends Eletronico{

    private int potencia;
    private int temporizador;

    private static ArrayList<Microondas> listaMicroondas = new ArrayList<>();

    @Override
    public Microondas readOne(int codigo) {
        return null;
    }

    @Override
    public ArrayList<Object> readAll() {
        return null;
    }

    @Override
    public void create() {

    }

    @Override
    public void delete() {

    }

    @Override
    public void update() {

    }
}
