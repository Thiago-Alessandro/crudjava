import java.util.ArrayList;

public interface ICrud<ID,T> { //5 (3 generica, 2 especializada)atributos para cadastro pode ser preenchido automaticamente eg id

    T readOne(ID codigo);
    ArrayList<T> readAll();
    T create(T object);
    boolean delete(T object);
    T update(T object);

}
