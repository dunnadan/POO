import java.util.List;
import java.util.ArrayList;

public class IdentidadeFiscal implements java.io.Serializable {


    private int nif;
    private String nome;
    private String email;
    private String morada;
    private String password;
    private double coeficiente;
    private List<String> atividades;
    private List<Fatura> faturas;
    // private  transient List<Fatura> faturas_obj;


    public IdentidadeFiscal() {
    }

    public IdentidadeFiscal(int nif, String nome, String email, String morada,
                            String password, double coeficiente,
                            List<String> atividades, List<Fatura> fatura) {

        this.nif = nif;
        this.nome = nome;
        this.email = email;
        this.morada = morada;
        this.password = password;
        this.coeficiente = coeficiente;
        this.atividades = new ArrayList<String>();
        this.faturas = new ArrayList<Fatura>();

        for (Fatura fat : faturas) {
            this.faturas.add(fat.clone());
        }

        for (String atv : atividades) {
            this.atividades.add(atv);
        }
    }


    public IdentidadeFiscal(IdentidadeFiscal object) {

        this.atividades = new ArrayList<String>();
        this.faturas = new ArrayList<Fatura>();
        //this.faturas_obj = new ArrayList<Fatura>();
        this.nif = object.getNIF();
        this.nome = object.getNome();
        this.email = object.getEmail();
        this.morada = object.getMorada();
        this.password = object.getPassword();
        this.coeficiente = object.getCoeficiente();
        this.atividades = object.getAtividades();
        //this.faturas_obj = object.getFaturasObject();
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

    public double getCoeficiente() {
        return this.coeficiente;
    }

    public void setCoeficiente(double coeficiente) {
        this.coeficiente = coeficiente;
    }

    public List<String> getAtividades() {
        return new ArrayList<>(this.atividades);
    }

    public void setAtividades(ArrayList<String> atividades) {
        this.atividades = new ArrayList<>(atividades);
    }

    public void addAtividades(String atividade) {
        this.atividades.add(atividade);
    }

    public void removeAtividades(String atividade) {
        if (this.atividades.contains(atividade))
            this.atividades.remove(atividade);
    }

    /*public List<String> getFaturas(){
        return new ArrayList<>(this.faturas);
    }

    public void setFaturas(ArrayList<String> faturas){
        this.faturas = new ArrayList<>(faturas);
    }

    public void addFaturas(String fatura){
        this.faturas.add(fatura);
    }

    public void removeFaturas(String fatura){
        if (this.faturas.contains(fatura))
            this.faturas.remove(fatura);
    }
*/

    public List<Fatura> getFaturas() {
        ArrayList<Fatura> newfaturas = new ArrayList<>();
        for (Fatura fat : this.faturas) {
            newfaturas.add(fat.clone());
        }
        return newfaturas;
    }


    public void setFaturasObject(ArrayList<Fatura> faturas_obj) {

        ArrayList<Fatura> newfaturas_obj = new ArrayList<>();
        for (Fatura fat : faturas_obj) {
            newfaturas_obj.add(fat.clone());
            this.faturas = newfaturas_obj;
        }
    }

    public void addFaturasObject(Fatura object) {

        this.faturas.add(object);
    }

    public void removeFaturasObject(Fatura fatura) {

        if (this.faturas.contains(fatura))
            this.faturas.remove(fatura);
    }

    //usaremos para autenticar uma identidade fiscal na hora de logar na app
    public boolean auth(String password) {

        return (this.password.equals(password));
    }

    @Override
    public IdentidadeFiscal clone() {

        return new IdentidadeFiscal(this);
    }

    public boolean equals(Object o) {

        if (this == o) return true;
        if ((o == null) || this.getClass() != o.getClass()) return false;

        IdentidadeFiscal idFiscal = (IdentidadeFiscal) o;

        return (this.nif == (idFiscal.getNIF()) && this.nome.equals(idFiscal.getNome())
                && this.email.equals(idFiscal.getEmail())
                && this.morada.equals(idFiscal.getMorada()) && this.password.equals(idFiscal.getPassword())
                && this.coeficiente == idFiscal.getCoeficiente() && this.atividades.equals(idFiscal.getAtividades())
                && this.faturas.equals(idFiscal.getFaturas()));
    }

    @Override
    public String toString() {


        return "NIF: " +
                this.nif + "\n" +
                "Nome: " +
                this.nome + "\n" +
                "Password: " +
                this.password + "\n" +
                "Morada: " +
                this.morada + "\n" +
                "Email: " +
                this.email + "\n" +
                "Coeficiente: " +
                this.coeficiente + "\n" +
                "Atividade: " +
                this.atividades.toString() + "\n" +
                "Faturas: " +
                this.faturas.toString();
    }
}
