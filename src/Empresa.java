import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Empresa extends IdentidadeFiscal  implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private String concelho;

	//Constructors

    /**
     * Construtor Empresa vazio
     */
    public Empresa(){
        super();
        this.concelho ="";
    }

    /**
     * Construtor Empresa parametrizado
     * @param nif NIF da Empresa
     * @param nome Nome da Empresa
     * @param email Email da Empresa
     * @param morada Morada da Empresa
     * @param password Password da conta
     * @param coeficiente Coeficiente da Empresa
     * @param atividades Atividades da Empresa
     * @param faturas Faturas da Empresa
     * @param concelho Concelho da Empresa
     */
    public Empresa(int nif,
                   String nome,
                   String email,
                   String morada,
                   String password,
                   double coeficiente,
                   List<Atividade> atividades,
                   List<Fatura> faturas, String concelho ){
        
      super(nif,nome,email,morada,password,coeficiente, atividades,faturas);
      this.concelho = concelho;
    }

    /**
     * Construtor Empresa através de um objeto
     * @param object Empresa
     */
    public Empresa(Empresa object){
        
        super(object);
        this.concelho = object.getConcelho();
    }

    //Methods

    public String getConcelho() {
        return this.concelho;
    }

    public void setConcelho(String c){
        this.concelho = c;
    }

    /**
     * Total Faturado por uma Empresa
     * @param faturas Faturas da Empresa
     * @return Valor faturado
     */
    public double totalFaturado(List<Fatura> faturas){

        double valor = 0 ;

        for(Fatura fat : faturas) {
            valor += fat.getValor();
        }
        return valor;
    }

    /**
     * Total faturado por uma Empresa num intervalo de tempo
     * @param inicio inicio do periodo
     * @param fim fim do periodo
     * @return Valor faturado
     */
    public double totalFaturadoTempo(LocalDate inicio, LocalDate fim){

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

    /**
     * {@inheritDoc}
     * @return Empresa
     */
    public Empresa clone(){
        return new Empresa(this);
    }

    /**
     * Filtra as faturas de uma empresa tendo em conta um contribuinte individual
     * @param nif NIF do contribuinte
     * @return Lista de faturas
     */
   public List<Fatura> faturasContribuinte(int nif){
        return this.getFaturas().stream()
                .filter(f -> f.getNIFCliente() == nif)
                .collect(Collectors.toList());
    }

    /**
     * Ordena as faturas de um contribuinte por valor
     * @param nif NIF do contribuinte
     * @return Lista de faturas
     */
   public List<Fatura> faturasContribuinteValor(int nif){
       List<Fatura> l = this.faturasContribuinte(nif);
       l.sort(new FaturaComparatorValor());
       return l;
   }

    /**
     * Ordena as faturas de um contribuinte por data
     * @param nif NIF do contribuinte
     * @return Lista de faturas
     */
    public List<Fatura> faturasContribuinteData(int nif){

       List<Fatura> l = this.faturasContribuinte(nif);
       l.sort(new FaturaComparatorData());

       return l;
    }

    /**
     * Ordena as faturas da empresa por valor
     * @return Lista de faturas
     */
    public List<Fatura> faturasEmpresaValor(){

        List<Fatura> l = this.getFaturas();
        l.sort(new FaturaComparatorValor());

        return l;
    }

    /**
     * Ordena as faturas da empresa por data
     * @return Lista de faturas
     */
    public List<Fatura> faturasEmpresaData(){

        List<Fatura> l = this.getFaturas();
        l.sort(new FaturaComparatorData());

        return l;
    }

    /**
     * {@inheritDoc}
     * @return
     */
    public String toString() {
        return super.toString()+this.concelho+"\n";
    }

    /**
     * {@inheritDoc}
     * @param o Objeto
     * @return
     */
    public boolean equals(Empresa o){
        return super.equals(o) && this.concelho.equals(o.getConcelho());
    }

    /**
     * Opçoes que uma Empresa tem no sistema
     * @return String com opçoes
     */
    public String menu() {
        
        return "1. Criar facturas\n" +
               "2. Listagem de facturas de um contribuinte ordenada por data\n" +
               "3. Listagem de facturas de um contribuinte ordenada por valor\n" +
               "4. Listagem de facturas da empresa ordenada por valor\n" +
               "5. Listagem de facturas da empresa ordenada por data\n" +
               "6. Total faturado num período de tempo\n" +
               "7. Minhas faturas\n" +
               "8. Adicionar atividade\n" +
               "9. Minhas atividades\n" +
               "0. Sair da App\n";
    }
}
