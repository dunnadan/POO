import java.util.ArrayList;

public class IdentidadeFiscal implements java.io.Serializable {
    
    private int nif;
    private String nome;
    private String email;
    private String morada;
    private String password;
    private double coeficiente;
    private ArrayList<String> atividades;
    private ArrayList<String> faturas;
    private transient ArrayList<Fatura> faturas_obj;

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

    public ArrayList<String> getFaturas(){
        return this.faturas;
    }

    public void setFaturas(ArrayList<String> faturas){
        this.faturas = faturas;
    }

    public void addFaturas(String fatura){
        this.faturas.add(fatura);
    }

    public void removeFaturas(String fatura){
        if (this.faturas.contains(fatura))
            this.faturas.remove(fatura);
    }

    public ArrayList<Fatura> getFaturasObject(){
        return this.faturas_obj;
    }

    public void setFaturasObject(ArrayList<Fatura> faturas_obj){
        this.faturas_obj = faturas_obj;
    }

    public void addFaturasObject(Fatura object){
        this.faturas_obj.add(object);
    }

    public void removeFaturasObject(Fatura fatura){
        if (this.faturas_obj.contains(fatura))
            this.faturas_obj.remove(fatura);
    }

    //usaremos para autenticar uma identidade fiscal na hora de logar na app
    public boolean auth(String password){
        return (this.password == password);
    }
}
