import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Fatura implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
	private String numero;
    private int nif_emitente;
    private int nif_cliente;
    private String descricao;
    private List<Atividade> historico;
    private double valor;
    private LocalDate data;

    /**
     * Construtor vazio
     */
    public Fatura(){

        this.numero = "";
        this.nif_emitente = 0;
        this.nif_cliente = 0;
        this.descricao = "";
        this.historico = new ArrayList<>();
        this.valor = 0;
        this.data = LocalDate.now();

    }

    /**
     * Construtor parametrizado
     * @param numero numero da fatura
     * @param nif_emitente nif do emitente
     * @param nif_cliente nif do cliente
     * @param descricao descriçao da fatura
     * @param atividade ativiade associada
     * @param valor valor da fatura
     */
    public Fatura(String numero, int nif_emitente, int nif_cliente, String descricao, Atividade atividade, double valor){

        this.numero = numero;
        this.nif_emitente = nif_emitente;
        this.nif_cliente = nif_cliente;
        this.descricao = descricao;
        this.historico = new ArrayList<>();
        this.valor = valor;
        this.data = LocalDate.now();

        this.historico.add(atividade);
    }

    /**
     * Contrutor po objeto
     * @param object objeto
     */
    public Fatura(Fatura object){

        this.numero = object.getNumero();
        this.nif_emitente = object.getNIFEmitente();
        this.nif_cliente = object.getNIFCliente();
        this.descricao = object.getDescricao();
        this.historico = object.getHistorico();
        this.valor = object.getValor();
        this.data = object.getData();   

    }

    //Methods
    public String getNumero(){
        return this.numero;
    }

    public void setNumero(String num){
        this.numero = num;
    }

    public int getNIFEmitente() {
        return this.nif_emitente;
    }

    public void setNIFEmitente(int nif) {
        this.nif_emitente = nif;
    }

    public LocalDate getData() {
        return this.data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public int getNIFCliente() {
        return this.nif_cliente;
    }

    public void setNIFCliente(int nif) {
        this.nif_cliente = nif;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Atividade> getHistorico() {
        return new ArrayList<>(this.historico);
    }

    public void setHistorico(Atividade atividade) {
        this.historico.add(atividade);
    }

    public void setHistorico(String atividade) {

        if (atividade.toUpperCase().equals("LAZER")){
            Atividade atv = new AtividadeLazer("Lazer");
            this.historico.add(atv);
        }
        if (atividade.toUpperCase().equals("SAUDE")){
            Atividade atv = new AtividadeSaude("Saude");
            this.historico.add(atv);
        }
        if (atividade.toUpperCase().equals("EDUCACAO") || atividade.toUpperCase().equals("EDUCAÇAO")){
            Atividade atv = new AtividadeEducacao("Educaçao");
            this.historico.add(atv);
        }
        if (atividade.toUpperCase().equals("ALIMENTACAO") || atividade.toUpperCase().equals("ALIMENTAÇAO")){
            Atividade atv = new AtividadeAlimentacao("Alimentaçao");
            this.historico.add(atv);
        }
        if (atividade.toUpperCase().equals("TRANSPORTE")){
            Atividade atv = new AtividadeTransportes("Transporte");
            this.historico.add(atv);
        }
        if (atividade.toUpperCase().equals("PENDENTE")){
            Atividade atv = new AtividadePendente("Pendente");
            this.historico.add(atv);
        }
    }

    public double getValor() {
        return this.valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Atividade getAtividadeAtual(){
        return this.historico.get(this.historico.size() - 1).clone();
    }

    /**
     * {@inheritDoc}
     * @return
     */
    @Override
    public Fatura clone(){
        return new Fatura(this);
    }

    /**
     * {@inheritDoc}
     * @param o objeto
     * @return
     */
    public boolean equals(Object o){

        if(this == o) return true;
        if(o == null || this.getClass()!=o.getClass()) return false;
        Fatura f = (Fatura) o;
        return ((this.numero.equals(f.getNumero()))
                && (this.nif_emitente == f.nif_emitente)
                && (this.nif_cliente == f.nif_cliente)
                && this.descricao.equals(f.getDescricao())
                && (this.historico.equals(f.getHistorico()))
                && (this.valor == f.getValor())
                && (this.data.equals(f.getData())));
    }

    /**
     * {@inheritDoc}
     * @return
     */
    @Override
    public String toString() {
        return "Numero = " + numero +
               "\nNif Emitente = " + nif_emitente +
               "\nNif Cliente = " + nif_cliente +
               "\nDescricao = " + descricao +
               "\nAtividade = " + this.getAtividadeAtual() +
               "\nValor = " + valor +
               "\nData = " + data + "\n\n";
    }
}
