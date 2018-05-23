import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Empresa extends IdentidadeFiscal  implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

	//Constructors

    /**
     * Construtor Empresa vazio
     */
    public Empresa(){
        
        super();
    }

    /**
     * Construtor Empresa parametrizado
     * @param nif
     * @param nome
     * @param email
     * @param morada
     * @param password
     * @param coeficiente
     * @param atividades
     * @param faturas
     */
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

    /**
     * Construtor Empresa através de um objeto
     * @param object
     */
    public Empresa(Empresa object){
        
        super(object);
    }

    //Methods

    /**
     * Total Faturado por uma Empresa
     * @param faturas
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
     * @param inicio
     * @param fim
     * @return Valor faturado
     */
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

    /**
     * {@inheritDoc}
     * @return Empresa
     */
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


    /**
     * Filtra as faturas de uma empresa tendo em conta um contribuinte individual
     * @param nif
     * @return Lista de faturas
     */
   public List<Fatura> faturasContribuinte(int nif){
        return this.getFaturas().stream()
                .filter(f -> f.getNIFCliente() == nif)
                .collect(Collectors.toList());
    }

    /**
     * Ordena as faturas de um contribuinte por valor
     * @param nif
     * @return Lista de faturas
     */
   public List<Fatura> faturasContribuinteValor(int nif){
       List<Fatura> l = this.faturasContribuinte(nif);
       l.sort(new FaturaComparatorValor());
       return l;
   }

    /**
     * Ordena as faturas de um contribuinte por data
     * @param nif
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
     * @return
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
        return super.toString();
    }

    /**
     * {@inheritDoc}
     * @param o
     * @return
     */
    public boolean equals(Object o){
        return super.equals(o);
    }

    /**
     * Imprime no terminal as opçoes que uma Empresa tem no sistema
     * @return String com opçoes
     */
    public String menu() {
        
        return "1. Criar facturas\n" +
               "2. Listagem de facturas de um contribuinte ordenada por data\n" +
               "3. Listagem de facturas de um contribuinte ordenada por valor\n" +
               "4. Listagem de facturas da empresa ordenada por valor\n" +
               "5. Listagem de facturas da empresa ordenada por data\n" +
               "6. Total faturado num período de tempo\n" +
               "0. Sair da App\n";
    }
}
