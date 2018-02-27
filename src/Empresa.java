import java.util.ArrayList;

public class Empresa {
    private int NIF;
    private String email;
    private String nome;
    private String morada;
    private String password;
    private ArrayList<Fatura> faturasemi;
    private float fatorded;

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

    public void setFaturasemi(ArrayList<Fatura> faturasemi) {
        this.faturasemi = faturasemi;
    }

    public float getFatorded() {
        return fatorded;
    }

    public void setFatorded(float fatorded) {
        this.fatorded = fatorded;
    }

    public ArrayList<Fatura> getFaturasemi() {
        ArrayList<Fatura> faturas = new ArrayList<>();
        for(Fatura f: this.faturasemi){
            faturas.add(new Fatura(f.clone()));
        }
        return faturas;
    }


}
