import java.util.ArrayList;
import java.util.HashMap;

public class Teste{

    public static void teste(){

    ArrayList<Fatura> fat = new ArrayList<>();
    ArrayList<Atividade> atv = new ArrayList<>();
    int[] dep = {123456789, 298765432};


    HashMap<Integer,IdentidadeFiscal> db = new HashMap<>();

    IdentidadeFiscal eu = new Contribuinte();

    eu.setNome("leonardo");
    eu.setNIF(209308066);
    eu.setPassword("123456");

    db.put(eu.getNIF(), eu);

    DataBase.saveData(db);

    }
}