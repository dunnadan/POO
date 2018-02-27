import java.util.ArrayList;

public class Contribuinte {
    private int NIF;
    private String email;
    private String nome;
    private String morada;
    private String password;
    private int dependentes;
    private ArrayList<String> NIFdependentes;
    private float coeficiente;
    private ArrayList<String> Atvidadesposs;


    public int getNIF() {
        return NIF;
    }

    public void setNIF(int NIF) {
        this.NIF = NIF;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getDependetes() {
        return dependentes;
    }

    public void setDependentes(int dependentes) {
        this.dependentes = dependentes;
    }

    public ArrayList<String> getNIFdependentes() {
        return NIFdependentes;
    }

    public void setNIFdependentes(ArrayList<String> NIFdependentes) {
        this.NIFdependentes = NIFdependentes;
    }

    public float getCoeficiente() {
        return coeficiente;
    }

    public void setCoeficiente(float coeficiente) {
        this.coeficiente = coeficiente;
    }

    public ArrayList<String> getAtvidadesposs() {
        return new ArrayList<String>(this.Atvidadesposs);
    }

    public void setAtvidadesposs(ArrayList<String> atvidadesposs) {
        Atvidadesposs = atvidadesposs;
    }
}
