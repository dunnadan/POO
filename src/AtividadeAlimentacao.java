import java.io.Serializable;

public class AtividadeAlimentacao extends Atividade implements Serializable{


    private static final long serialVersionUID = 1L;

    /**
     * Construtor Vazio de Atividade
     */
	public AtividadeAlimentacao(){
        super();
    }

    /**
     * Contrutor Atividade
     * @param nome nome da atividade
     */
    public AtividadeAlimentacao(String nome){
        super(nome);
    }

    /**
     * Contrutor por Objeto
     * @param object Atividade
     */
    public AtividadeAlimentacao(AtividadeAlimentacao object){
        super(object);
    }

    /**
     * Fator de dedução
     * @param f Fatura
     * @return valor deduzido
     */
    public double deduct(Fatura f){

        double x = f.getValor();
        return x * 0.20;
    }

    /**
     * {@inheritDoc}
     * @return
     */
    public AtividadeAlimentacao clone(){
        return new AtividadeAlimentacao(this);
    }

    /**
     * {@inheritDoc}
     * @return
     */
    @Override
    public String toString(){
        return "Alimentação";
    }
}
