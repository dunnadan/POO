import java.util.ArrayList;

public class Contribuinte implements java.io.Serializable {
    
    private int nif;
    private String nome;
    private String email;
    private String morada;
    private String password;
    private double coeficiente;
    private ArrayList<Integer> dependentes;
    private ArrayList<String> atividades;
    private transient ArrayList<Fatura> futuras;

    //Constructors
    public Contribuinte(){
        this.atividades = new ArrayList<String>();
        this.dependentes = new ArrayList<Integer>();
    }

    public Contribuinte(int nif, String nome, String email, String morada, String password, 
                        double coeficiente, int[] dependentes, String[] atividades){
        
        this.dependentes = new ArrayList<Integer>();
        this.atividades = new ArrayList<String>();

        this.nif = nif;
        this.nome = nome;
        this.email = email;
        this.morada = morada;
        this.password = password;
        this.coeficiente = coeficiente;

        for(int dep : dependentes)
            this.dependentes.add(dep);

        for(String atv : atividades)
            this.atividades.add(atv);
    }

    public Contribuinte(Contribuinte object){
        
        this.dependentes = new ArrayList<Integer>();
        this.atividades = new ArrayList<String>();

        this.nif = object.getNIF();
        this.nome = object.getNome();
        this.email = object.getEmail();
        this.morada = object.getMorada();
        this.password = object.getPassword();
        this.coeficiente = object.getCoeficiente();
        this.dependentes = object.getDependentes();
        this.atividades = object.getAtividades();
        this.futuras = object.getFaturas();
    }


    //Methods
    public int getNIF() {
        return this.nif;
    }

    public void setNIF(int nif) {
        this.nif = nif;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMorada() {
        return this.morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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

    public double getCoeficiente() {
        return this.coeficiente;
    }

    public void setCoeficiente(double coeficiente) {
        this.coeficiente = coeficiente;
    }

    public ArrayList<String> getAtividades() {
        return this.atividades;
    }

    public void setAtividades(ArrayList<String> atividades) {
        this.atividades = atividades;
    }

    public void addAtividades(String atividade){
        this.atividades.add(atividade);
    }

    public void removeAtividades(String atividade){
        if (this.atividades.contains(atividade))
            this.atividades.remove(atividade);
    }

    public ArrayList<Fatura> getFaturas(){
        return this.faturas;
    }

    public void setFaturas(ArrayList<Fatura> faturas){
        this.faturas = faturas;
    }
}
