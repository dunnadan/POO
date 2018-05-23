import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Contribuinte extends IdentidadeFiscal implements java.io.Serializable {
    
    private static final long serialVersionUID = 1L;
    private List<Integer> dependentes;



    //Constructors

    public Contribuinte(){

        super();
        this.dependentes = new ArrayList<>();
    }

    public Contribuinte(int nif, String nome, String email, String morada, String password,
                        double coeficiente, List<Fatura> faturas, int[] dependentes,
                        List<Atividade> atividades) {
        super(nif, nome, email, morada, password, coeficiente, atividades, faturas);
        this.dependentes = new ArrayList<>();
        for (int dep : dependentes)
            this.dependentes.add(dep);
    }

    public Contribuinte(Contribuinte object){

        super(object);
        this.dependentes = new ArrayList<>();
        this.dependentes = object.getDependentes();

    }


    //Methods
    public List<Integer> getDependentes() {
        return new ArrayList<>(this.dependentes);
    }

    public void setDependentes(List<Integer> dependentes) {
        this.dependentes = dependentes;
    }

    public int getNumDependentes(){
        return dependentes.size();
    }

    public void addDependente(int dependente){
        this.dependentes.add(dependente);
    }

    public void removeDependente(int dependente){
        if (this.dependentes.contains(dependente))
            this.dependentes.remove(dependente);
    }

    public Contribuinte clone(){
        return new Contribuinte(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Contribuinte that = (Contribuinte) o;
        return Objects.equals(getDependentes(), that.getDependentes());
    }


    @Override
    public String toString() {
        return super.toString() + "Contribuinte{" +
                "dependentes=" + dependentes +
                '}';
    }

    public double totalGasto(){

        List<Fatura> faturas = this.getFaturas();
        double total =0;

        for(Fatura fat : faturas){
            total += fat.getValor();
        }
        return total;
    }

    public String menu() {
        
        return "1. Facturas\n" +
               "2. Montante de dedução fiscal acumulado\n" +
               "3. Associar classificação de atividade económica a uma factura\n" +
               "4. Corrigir a classificação de atividade económica de uma factura\n" +
               "5. Adicionar dependente\n" +
               "6. Meus dependentes\n" +
               "0. Sair da App\n";
    }
}
