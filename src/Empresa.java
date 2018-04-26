import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Empresa extends IdentidadeFiscal  implements java.io.Serializable {

    //Constructors
    public Empresa(){


    }

    public Empresa(int nif,
                   String nome,
                   String email,
                   String morada,
                   String password,
                   double coeficiente,
                   List<String> atividades,
                   List<Fatura> faturas ){
        
        super(nif,nome,email,morada,password,coeficiente, atividades,faturas);
    }

    public Empresa(Empresa object){
        
        super(object);
    }

    //Methods
    public double totalFaturado(List<Fatura> faturas){

        double valor = 0 ;

        for(Fatura fat : faturas) {
            valor += fat.getValor();
        }
        return valor;
    }

    public double totalFaturadoTempo(List<Fatura> faturas, LocalDateTime inicio, LocalDateTime fim){

        ArrayList<Fatura> faturaAux = new ArrayList<>();

        for (Fatura fat : faturas){
            if(fat.getData().isBefore(fim) && fat.getData().isAfter(inicio)) {
                faturaAux.add(fat);
            }
        }
        return totalFaturado(faturaAux);
    }

    @Override
    public Empresa clone(){
        return new Empresa(this);
    }

    public Fatura makeFatura(String numero,
                             int nif_emitente,
                             int nif_cliente,
                             String tipo,
                             String descricao,
                             String atividade,
                             double valor){

        Fatura fatura = new Fatura(numero, nif_emitente, nif_cliente, tipo, descricao, atividade, valor);

        return fatura;
    }
}
