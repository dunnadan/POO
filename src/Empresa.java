import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Empresa extends IdentidadeFiscal  implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

	//Constructors
    public Empresa(){


    }

    public Empresa(int nif,
                   String nome,
                   String email,
                   String morada,
                   String password,
                   double coeficiente,
                   List<Atividade> atividades,
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

    public double totalFaturadoTempo(LocalDateTime inicio, LocalDateTime fim){

        List<Fatura> faturas = new ArrayList<>();
        faturas = this.getFaturas();
        List<Fatura> faturaAux = new ArrayList<>();

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
                             String descricao,
                             Atividade atividade,
                             double valor){

        return new Fatura(numero, nif_emitente, nif_cliente, descricao, atividade, valor);
    }

   public List<Fatura> faturasContribuinte(int nif){
        return this.getFaturas().stream()
                .filter(f -> f.getNIFCliente() == nif)
                .collect(Collectors.toList());
    }

   public List<Fatura> faturasContribuinteValor(int nif){
       List<Fatura> l = this.faturasContribuinte(nif);
       l.sort(new FaturaComparatorValor());
       return l;
   }

    public List<Fatura> faturasContribuinteData(int nif){

       List<Fatura> l = this.faturasContribuinte(nif);
       l.sort(new FaturaComparatorData());

       return l;
    }

    //retorna as faturas de uma empresa ordenadas por valor
    public List<Fatura> faturasEmpresaValor(){

        List<Fatura> l = this.getFaturas();
        l.sort(new FaturaComparatorValor());

        return l;
    }

    public List<Fatura> faturasEmpresaData(){

        List<Fatura> l = this.getFaturas();
        l.sort(new FaturaComparatorData());

        return l;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public boolean equals(Object o){
        return super.equals(o);
    }



}
