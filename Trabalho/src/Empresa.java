import java.util.ArrayList;

public class Empresa {
    private int NIF;
    private String email;
    private String nome;
    private String morada;
    private String password;
    private ArrayList<Fatura> faturasemi;
    private float fatorded;

    public ArrayList<Fatura> getFaturasemi() {
        ArrayList<Fatura> faturas = new ArrayList<>();
        for(Fatura f: this.faturasemi){
            faturas.add(new Fatura(f.clone()));
        }
        return faturas;
    }


}
