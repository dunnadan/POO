import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DR {

    private static Map<Integer,IdentidadeFiscal> db = new HashMap<>();

    private static void newDataBase(String id_fiscal_file, String fatura_file){
        
        ArrayList<ArrayList<String>> id_fiscal = CSVReader.readFile(id_fiscal_file);

        for (ArrayList<String> id : id_fiscal){
            
            if (id.get(0).toLowerCase().equals("contribuinte")){
                Contribuinte cont = new Contribuinte();

                cont.setNIF(Integer.valueOf(id.get(1)));
                cont.setNome(id.get(2));
                cont.setEmail(id.get(3));
                cont.setMorada(id.get(4));
                cont.setPassword(id.get(5));
                cont.setCoeficiente(Double.valueOf(id.get(6)));

                for (String atv : id.get(7).split(","))
                    cont.addAtividades(atv.toUpperCase());

                if (id.size() > 8)
                    for (String dep : id.get(8).split(","))
                        cont.addDependente(Integer.valueOf(dep));

                db.put(cont.getNIF(), cont);
            }

            else {
                Empresa emp = new Empresa();

                emp.setNIF(Integer.valueOf(id.get(1)));
                emp.setNome(id.get(2));
                emp.setEmail(id.get(3));
                emp.setMorada(id.get(4));
                emp.setPassword(id.get(5));
                emp.setCoeficiente(Double.valueOf(id.get(6)));

                for (String atv : id.get(7).split(","))
                    emp.addAtividades(atv.toUpperCase());

                db.put(emp.getNIF(), emp);
            }
        }

        ArrayList<ArrayList<String>> fatura_list = CSVReader.readFile(fatura_file);

        for (ArrayList<String> fat : fatura_list){

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            Fatura fatura = new Fatura();

            fatura.setNumero(fat.get(0));
            fatura.setNIFEmitente(Integer.valueOf(fat.get(1)));
            fatura.setNIFCliente(Integer.valueOf(fat.get(2)));
            fatura.setDescricao(fat.get(3));

            for (String atv : fat.get(4).split(","))
                fatura.setHistorico(atv.toUpperCase());

            fatura.setValor(Double.valueOf(fat.get(5)));
            
            LocalDate date = LocalDate.parse(fat.get(6), formatter);
            fatura.setData(date);

            IdentidadeFiscal emp = db.get(fatura.getNIFEmitente());
            IdentidadeFiscal cont = db.get(fatura.getNIFCliente());

            emp.addFaturas(fatura);
            cont.addFaturas(fatura);
        }

        DataBase.saveData(db);
    }

    public static void main(String args[]){
        newDataBase("/home/leonardo/id_fiscal.csv", "/home/leonardo/fatura.csv");
    }
}