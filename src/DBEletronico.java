import java.util.ArrayList;

public class DBEletronico implements ICrud<Integer, Eletronico>{

    ArrayList<Eletronico> eletronicos = new ArrayList<>();

    @Override
    public Eletronico readOne(Integer codigo) {
        for(Eletronico eletronico : eletronicos){
            if(eletronico.getCodigo() == codigo){
                return eletronico;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Eletronico> readAll() {
        return eletronicos;
    }

    @Override
    public Eletronico create(Eletronico object) {
        object.setCodigo(eletronicos.size() + 1);
        eletronicos.add(object);
        return object;
    }

    @Override
    public boolean delete(Eletronico object) {
        return eletronicos.remove(object);
    }

    @Override
    public Eletronico update(Eletronico object) {
        Eletronico oldObject = readOne(object.getCodigo());
        if(oldObject != null){
           eletronicos.set(eletronicos.indexOf(oldObject), object);
            return object;
        }
//        for (Eletronico eletronico : eletronicos){
//            if(eletronico.getCodigo() == object.getCodigo()){
//                int index = eletronicos.indexOf(eletronico);
//                eletronicos.remove(eletronico);
//                eletronicos.add(index, object);
//                return object;
//            }
//        }
        return null;
    }
}
