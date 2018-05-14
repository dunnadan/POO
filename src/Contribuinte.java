import java.util.ArrayList;
import java.util.List;


public class Contribuinte extends IdentidadeFiscal implements java.io.Serializable {
    
    private static final long serialVersionUID = 1L;
    private List<Integer> dependentes;



    //Constructors

    //Construtor vazio
    public Contribuinte(){

        super();
        this.dependentes = new ArrayList<>();
    }


    //Construtor parameterizado
    public Contribuinte(int nif, String nome,
                        String email,
                        String morada,
                        String password,
                        double coeficiente,
                        List<Fatura> faturas,
                        int[] dependentes,
                        List<Atividade> atividades) {


        super(nif, nome, email, morada, password, coeficiente, atividades, faturas);

        for (int dep : dependentes)
            this.dependentes.add(dep);
    }


    //Construtor de copia
    public Contribuinte(Contribuinte object){

        super(object);
        this.dependentes = new ArrayList<>();
        this.dependentes = object.getDependentes();

    }


    //Methods
    public List<Integer> getDependentes() {
        return new ArrayList<>(this.dependentes);
    }

    public void setDependentes(ArrayList<Integer> dependentes) {
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
}
