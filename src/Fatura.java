import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Fatura implements java.io.Serializable {

    private String numero;
    private int nif_emitente;
    private int nif_cliente;
    private String tipo;
    private String descricao;
    private String atividade;
    private double valor;
    private LocalDate data;

    //Constructors
    public Fatura(){

    }

    public Fatura(String numero, int nif_emitente, int nif_cliente, String tipo, String descricao, String atividade, double valor, String data){

        this.numero = numero;
        this.nif_emitente = nif_emitente;
        this.nif_cliente = nif_cliente;
        this.tipo = tipo;
        this.descricao = descricao;
        this.atividade = atividade;
        this.valor = valor;
        this.data = LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
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

    public String getAtividade() {
        return this.atividade;
    }

    public void setAtividade(String atividade) {
        this.atividade = atividade;
    }

    public double getValor() {
        return this.valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Fatura clone(){
        return new Fatura(this);
    }
}
