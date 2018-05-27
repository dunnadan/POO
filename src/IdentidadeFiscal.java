import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

public abstract class IdentidadeFiscal implements java.io.Serializable {


    private static final long serialVersionUID = 1L;
    /**
     * NIF da identidade
     */
	private int nif;
    /**
     * Nome da identidade
     */
    private String nome;
    /**
     * email da identidade
     */
    private String email;
    /**
     * morada da identidade
     */
    private String morada;
    /**
     * password da conta
     */
    private String password;
    /**
     * coeficiente associado à identidade
     */
    private double coeficiente;

    /**
     * lista de atividades possiveis de dedução
     */
    private List<Atividade> atividades;
    /**
     * lista de faturas associadas à identidade
     */
    private List<Fatura> faturas;


    /**
     * Contrutor Identidade Fiscal vazio
     */
    public IdentidadeFiscal() {
        this.nif = 0;
        this.nome = "";
        this.email = "";
        this.morada = "";
        this.password = "";
        this.coeficiente = 0;
        this.atividades = new ArrayList<>();
        this.faturas = new ArrayList<>();
    }

    /**
     * Construtor parametrizado de uma Identidade Fiscal
     * @param nif NIF da Identidade Fiscal
     * @param nome Nome da Identidade Fiscal
     * @param email Email da Identidade Fiscal
     * @param morada Morada da Identidade Fiscal
     * @param password Password da conta
     * @param coeficiente Coeficente da Identidade Fiscal
     * @param atividades Atividdades deduziveis
     * @param faturas Lista de Faturas
     */
    public IdentidadeFiscal(int nif, String nome, String email, String morada,
                            String password, double coeficiente,
                            List<Atividade> atividades, List<Fatura> faturas) {


        this.nif = nif;
        this.nome = nome;
        this.email = email;
        this.morada = morada;
        this.password = password;
        this.coeficiente = coeficiente;
        this.atividades = new ArrayList<>();
        this.faturas = new ArrayList<>();

        for (Fatura fat : faturas) {
            this.faturas.add(fat.clone());
        }

        this.atividades.addAll(atividades);
    }

    /**
     * Contrutor por objeto de uma Identidade Fiscal
     * @param object Identidade Fiscal
     */
    public IdentidadeFiscal(IdentidadeFiscal object) {

        this.atividades = object.getAtividades();
        this.faturas = object.getFaturas();
        this.nif = object.getNIF();
        this.nome = object.getNome();
        this.email = object.getEmail();
        this.morada = object.getMorada();
        this.password = object.getPassword();
        this.coeficiente = object.getCoeficiente();
        this.atividades = object.getAtividades();
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

    public List<Atividade> getAtividades() {
        return new ArrayList<>(this.atividades);
    }

    public int getNumAtividades(){
        return this.atividades.size();
    }

    public void setAtividades(ArrayList<Atividade> atividades) {
        this.atividades = new ArrayList<>(atividades);
    }

    public void addAtividades(Atividade atividade) {

        for (Atividade atv : this.atividades){
            if (atv.getClass() == atividade.getClass())
                return;
        }

        this.atividades.add(atividade);
    }

    /**
     * Adiciona uma atividade à lista que contém as ativiades que o contribuinte pode deduzir despezas
     * @param atividade nome da atividade
     */
    public void addAtividades(String atividade) {

        if (atividade.toUpperCase().equals("LAZER")){
            Atividade atv = new AtividadeLazer("Lazer");
            this.addAtividades(atv);
        }
        if (atividade.toUpperCase().equals("SAUDE")){
            Atividade atv = new AtividadeSaude("Saude");
            this.addAtividades(atv);
        }
        if (atividade.toUpperCase().equals("EDUCACAO") || atividade.toUpperCase().equals("EDUCAÇAO")){
            Atividade atv = new AtividadeEducacao("Educaçao");
            this.addAtividades(atv);
        }
        if (atividade.toUpperCase().equals("ALIMENTACAO") || atividade.toUpperCase().equals("ALIMENTAÇAO")){
            Atividade atv = new AtividadeAlimentacao("Alimentaçao");
            this.addAtividades(atv);
        }
        if (atividade.toUpperCase().equals("TRANSPORTE")){
            Atividade atv = new AtividadeTransportes("Transporte");
            this.addAtividades(atv);
        }
        if (atividade.toUpperCase().equals("PENDENTE")){
            Atividade atv = new AtividadePendente("Pendente");
            this.addAtividades(atv);
        }
    }

    /**
     * Remove uma Atividade da lista que contem as atividades deduziveis
     * @param atividade atividade
     */
    public void removeAtividades(Atividade atividade) {
        if (this.atividades.contains(atividade))
            this.atividades.remove(atividade);
    }


    public List<Fatura> getFaturas() {
        List<Fatura> newfaturas = new ArrayList<>();
        for (Fatura fat : this.faturas) {
            newfaturas.add(fat.clone());
        }
        return newfaturas;
    }

    public void setFaturas(ArrayList<Fatura> faturas) {

        ArrayList<Fatura> newfaturas = new ArrayList<>();

        for (Fatura fat : faturas) {
            newfaturas.add(fat.clone());
        }

        this.faturas = newfaturas;
    }

    /**
     * Adiciona uma Fatura à lista de faturas de um contribuinte
     * @param object Fatura
     */
    public void addFaturas(Fatura object) {

        this.faturas.add(object);
    }

    /**
     * Retira uma Fatura da lista de faturas de um contribuinte
     * @param fatura
     */
    public void removeFaturas(Fatura fatura) {

        if (this.faturas.contains(fatura))
            this.faturas.remove(fatura);
    }


    /**
     * Metodo que autentica um utilizador quando entra na plataforma
     * @param password Password da conta
     * @return Verdadeiro ou Falso
     */
    public boolean auth(String password) {

        return (this.password.equals(password));
    }

    /**
     * {@inheritDoc}
     * @return
     */
    public abstract IdentidadeFiscal clone();

    /**
     * {@inheritDoc}
     * @param o
     * @return
     */
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

    /**
     * {@inheritDoc}
     * @return
     */
    public String toString() {

        return "NIF: " + this.nif + "\n" +
                "Nome: " + this.nome + "\n" +
                "Password: " + this.password + "\n" +
                "Morada: " + this.morada + "\n" +
                "Email: " + this.email + "\n" +
                "Coeficiente: " + this.coeficiente + "\n" +
                "Atividade: " + this.atividades.toString() + "\n" +
                "Faturas: " + this.faturas.toString() + "\n\n";
    }

    public abstract String menu();
}
