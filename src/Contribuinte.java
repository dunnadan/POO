import java.util.ArrayList;

public class Contribuinte extends IdentidadeFiscal implements java.io.Serializable {
    
    private ArrayList<Integer> dependentes;

    //Constructors
    public Contribuinte(){
        this.atividades = new ArrayList<>();
        this.dependentes = new ArrayList<>();
        this.faturas = new ArrayList<>();
        this.faturas_obj = new ArrayList<>();
    }

    public Contribuinte(int nif, String nome, String email, String morada, String password, double coeficiente, 
                        String[] faturas, int[] dependentes, String[] atividades){
        
        this.dependentes = new ArrayList<>();
        this.atividades = new ArrayList<>();
        this.faturas = new ArrayList<>();
        this.faturas_obj = new ArrayList<>();

        this.nif = nif;
        this.nome = nome;
        this.email = email;
        this.morada = morada;
        this.password = password;
        this.coeficiente = coeficiente;

        for(String fat : faturas)
            this.faturas.add(fat);

        for(int dep : dependentes)
            this.dependentes.add(dep);

        for(String atv : atividades)
            this.atividades.add(atv);
    }

    public Contribuinte(Contribuinte object){
        
        this.dependentes = new ArrayList<>();
        this.atividades = new ArrayList<>();
        this.faturas = new ArrayList<>();
        this.faturas_obj = new ArrayList<>();

        this.nif = object.getNIF();
        this.nome = object.getNome();
        this.email = object.getEmail();
        this.morada = object.getMorada();
        this.password = object.getPassword();
        this.coeficiente = object.getCoeficiente();
        this.dependentes = object.getDependentes();
        this.atividades = object.getAtividades();
        this.faturas_obj = object.getFaturasObject();
    }


    //Methods
    public ArrayList<Integer> getDependentes() {
        return this.dependentes;
    }

    public void setDependentes(ArrayList<Integer> dependentes) {
        this.dependentes = dependentes;
    }

    public int getNumDependentes(){
        return dependentes.size();
    }

    public void addDependente(int dependente){
        dependentes.add(dependente);
    }

    public void removeDependente(int dependente){
        if (this.dependentes.contains(dependente))
            this.dependentes.remove(dependente);
    }

    public Contribuinte clone(){
        return new Contribuinte(this);
    }
}
