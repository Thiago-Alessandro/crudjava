import java.util.ArrayList;

public class DBPessoa implements ICrud<Integer, Pessoa>{

    private static ArrayList<Pessoa> pessoas = new ArrayList<>();


    @Override
    public Pessoa readOne(Integer codigo) {
        for(Pessoa pessoa : pessoas){
            if(pessoa.getCodigo() == codigo){
                return pessoa;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Pessoa> readAll() {
        return pessoas;
    }

    @Override
    public Pessoa create(Pessoa object) {
        object.setCodigo(pessoas.size() + 1);
        pessoas.add(object);
        return object;
    }

    @Override
    public boolean delete(Pessoa object) {
        return pessoas.remove(object);
    }

    @Override
    public Pessoa update(Pessoa object) {
        for(Pessoa pessoa : pessoas){
            if(pessoa.getCodigo() == object.getCodigo()){
                int index = pessoas.indexOf(pessoa);
                pessoas.remove(pessoa);
                pessoas.add(index, object);
                return object;
            }
        }
        return null;
    }
}
