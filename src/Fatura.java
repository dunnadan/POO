import java.time.LocalDateTime;

public class Fatura {

    private int NIFemitente;
    private String tipoemitente;
    private LocalDateTime datadespesa;
    private int NIFcliente;
    private String descricao;
    private String atividade;
    private float despesa;

    // private ArrayList<efatura.Fatura> asPrimas;

    public Fatura(Fatura fatura) {

    }

    public int getNIFemitente() {
        return NIFemitente;
    }

    public void setNIFemitente(int NIFemitente) {
        this.NIFemitente = NIFemitente;
    }

    public String getTipoemitente() {
        return tipoemitente;
    }

    public void setTipoemitente(String tipoemitente) {
        this.tipoemitente = tipoemitente;
    }

    public LocalDateTime getDatadespesa() {
        return datadespesa;
    }

    public void setDatadespesa(LocalDateTime datadespesa) {
        this.datadespesa = datadespesa;
    }

    public int getNIFcliente() {
        return NIFcliente;
    }

    public void setNIFcliente(int NIFcliente) {
        this.NIFcliente = NIFcliente;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getAtividade() {
        return atividade;
    }

    public void setAtividade(String atividade) {
        this.atividade = atividade;
    }

    public float getDespesa() {
        return despesa;
    }

    public void setDespesa(float despesa) {
        this.despesa = despesa;
    }

    @Override
    public Fatura clone(){
        return new Fatura(this);
    }

}
