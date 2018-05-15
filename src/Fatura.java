import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Fatura implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
	private String numero;
    private int nif_emitente;
    private int nif_cliente;
    private String tipo;
    private String descricao;
    private Atividade atividade;
    private double valor;
    private LocalDateTime data;

    //Constructors
    public Fatura(){

        this.numero = "";
        this.nif_emitente = 0;
        this.nif_cliente = 0;
        this.tipo = "";
        this.descricao = "";
        this.atividade = null;
        this.valor = 0;
        this.data = LocalDateTime.now();

    }

    public Fatura(String numero, int nif_emitente, int nif_cliente, String tipo, String descricao, Atividade atividade, double valor){

        this.numero = numero;
        this.nif_emitente = nif_emitente;
        this.nif_cliente = nif_cliente;
        this.tipo = tipo;
        this.descricao = descricao;
        this.atividade = atividade;
        this.valor = valor;
        this.data = LocalDateTime.now();
    }

    public Fatura(Fatura object){

        this.numero = object.getNumero();
        this.nif_emitente = object.getNIFEmitente();
        this.nif_cliente = object.getNIFCliente();
        this.tipo = object.getTipo();
        this.descricao = object.getDescricao();
        this.atividade = object.getAtividade();
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

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

    public Atividade getAtividade() {
        return this.atividade;
    }

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }

    public double getValor() {
        return this.valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public Fatura clone(){
        return new Fatura(this);
    }

    public boolean equals(Object o){

        if(this == o) return true;
        if(o == null || this.getClass()!=o.getClass()) return false;
        Fatura f = (Fatura) o;
        return (this.numero == f.getNumero()
            &&this.nif_emitente == f.nif_emitente
            &&this.nif_cliente == f.nif_cliente
            &&this.tipo == f.tipo
            &&this.descricao == f.getDescricao()
            &&this.atividade == f.getAtividade()
            &&this.valor == f.getValor()
            &&this.data == f.getData());
    }

    @Override
    public String toString() {
        return "Fatura{" +
                "numero='" + numero + '\'' +
                ", nif_emitente=" + nif_emitente +
                ", nif_cliente=" + nif_cliente +
                ", tipo='" + tipo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", atividade=" + atividade +
                ", valor=" + valor +
                ", data=" + data +
                '}';
    }
}
