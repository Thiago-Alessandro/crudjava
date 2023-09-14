import java.util.ArrayList;

public interface ICrud { //5 (3 generica, 2 especializada)atributos para cadastro pode ser preenchido automaticamente eg id

    Object readOne(int codigo);
    ArrayList<Object> readAll();
    void create();
    void delete();
    void update();

}
