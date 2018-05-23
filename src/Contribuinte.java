import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Contribuinte extends IdentidadeFiscal implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Lista que contem o NIF dos dependentes
     */
    private List<Integer> dependentes;



    //Constructors

    /**
     * Contrutor do Contribuinte vazio
     */
    public Contribuinte(){

        super();
        this.dependentes = new ArrayList<>();
    }

    /**
     * Contrutor Parametrizado de um Contribuinte
     * @param nif NIF do Contribuinte
     * @param nome Nome do Contribuinte
     * @param email Email do Contribuinte
     * @param morada Morada do Contribuinte
     * @param password Password do Contribuinte
     * @param coeficiente Coeficiente do Contribuinte
     * @param faturas Faturas do Contribuinte
     * @param dependentes Lista de Dependentes
     * @param atividades Lista de atividades
     */
    public Contribuinte(int nif, String nome, String email, String morada, String password,
                        double coeficiente, List<Fatura> faturas, int[] dependentes,
                        List<Atividade> atividades) {
        super(nif, nome, email, morada, password, coeficiente, atividades, faturas);
        this.dependentes = new ArrayList<>();
        for (int dep : dependentes)
            this.dependentes.add(dep);
    }

    /**
     * Construtor do Contribuinte atraves de um Objeto
     * @param object Contribuinte
     */
    public Contribuinte(Contribuinte object){

        super(object);
        this.dependentes = new ArrayList<>();
        this.dependentes = object.getDependentes();

    }


    /**
     * Retorna uma lista de NIFs dos dependentes do Contribuinte
     * @return Lista de inteiros
     */
    public List<Integer> getDependentes() {
        return new ArrayList<>(this.dependentes);
    }

    /**
     * Cria lista de NIFs dos dependentes
     * @param dependentes
     */
    public void setDependentes(List<Integer> dependentes) {
        this.dependentes = new ArrayList<>(dependentes);
    }

    /**
     * Conta o numero de dependentes
     * @return numero de dependentes
     */
    public int getNumDependentes(){
        return dependentes.size();
    }

    /**
     * Adiciona o NIF de um dependente ao Contribuinte
     * @param dependente NIF do dependente
     */
    public void addDependente(int dependente){
        this.dependentes.add(dependente);
    }

    /**
     * Remove dependete do Contribuinte
     * @param dependente NIF do dependente
     */
    public void removeDependente(int dependente){
        if (this.dependentes.contains(dependente))
            this.dependentes.remove(dependente);
    }

    /**
     * {@inheritDoc}
     * @return
     */
    public Contribuinte clone(){
        return new Contribuinte(this);
    }

    /**
     * {@inheritDoc}
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Contribuinte that = (Contribuinte) o;
        return Objects.equals(getDependentes(), that.getDependentes());
    }

    /**
     * {@inheritDoc}
     * @return
     */
    @Override
    public String toString() {
        return super.toString() + "Contribuinte{" +
                "dependentes=" + dependentes +
                '}';
    }

    /**
     * Calculo do total gasto por um Contribuinte
     * @return
     */
    public double totalGasto(){

        List<Fatura> faturas = this.getFaturas();
        double total =0;

        for(Fatura fat : faturas){
            total += fat.getValor();
        }
        return total;
    }

    /**
     * String que contem as opçoes que um Contribuinte tem no sistema
     * @return String
     */
    public String menu() {
        
        return "1. Facturas\n" +
               "2. Montante de dedução fiscal acumulado\n" +
               "3. Associar classificação de atividade económica a uma factura\n" +
               "4. Corrigir a classificação de atividade económica de uma factura\n" +
               "5. Adicionar dependente\n" +
               "0. Sair da App\n";
    }
}
