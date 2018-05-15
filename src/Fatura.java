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
    private LocalDateTime data;

    //Constructors
    public Fatura(){

        this.numero = "";
        this.nif_emitente = 0;
        this.nif_cliente = 0;
        this.descricao = "";
        this.historico = new ArrayList<>();
        this.valor = 0;
        this.data = LocalDateTime.now();

    }

    public Fatura(String numero, int nif_emitente, int nif_cliente, String descricao, Atividade atividade, double valor){

        this.numero = numero;
        this.nif_emitente = nif_emitente;
        this.nif_cliente = nif_cliente;
        this.descricao = descricao;
        this.historico = new ArrayList<>();
        this.valor = valor;
        this.data = LocalDateTime.now();

        this.historico.add(atividade);
    }

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

    public LocalDateTime getData() {
        return this.data;
    }

    public void setData(LocalDateTime data) {
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

    public double getValor() {
        return this.valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Atividade getAtividadeAtual(){
        return this.historico.get(this.historico.size() - 1);
    }

    @Override
    public Fatura clone(){
        return new Fatura(this);
    }

    public boolean equals(Object o){

        if(this == o) return true;
        if(o == null || this.getClass()!=o.getClass()) return false;
        Fatura f = (Fatura) o;
        return ((this.numero.equals(f.getNumero()))
                && (this.nif_emitente == f.nif_emitente)
                && (this.nif_cliente == f.nif_cliente)
                && this.descricao.equals(f.getDescricao())
                && (this.historico == f.getHistorico())
                && (this.valor == f.getValor())
                && (this.data == f.getData()));
    }

    @Override
    public String toString() {
        return "Fatura:" + '\n' +
                "Numero= " + numero + '\n' +
                "Nif Emitente= " + nif_emitente + '\n' +
                "Nif Cliente= " + nif_cliente + '\n' +
                "Descricao= " + descricao + '\n' +
                "Atividade = " + this.getAtividadeAtual() + '\n' +
                "Valor = " + valor + '\n' +
                "Data = " + data;
    }
}
