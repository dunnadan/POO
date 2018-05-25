import java.io.Serializable;

public class AtividadeEducacao extends Atividade implements Deduzivel, Serializable {


    private static final long serialVersionUID = 1L;

    /**
     * Construtor Vazio de Atividade
     */
	public AtividadeEducacao(){
        super();
    }

    /**
     * Contrutor Atividade
     * @param nome nome da atividade
     */
    public AtividadeEducacao(String nome){
        super(nome);
    }
    /**
     * Contrutor por Objeto
     * @param object Atividade
     */
    public AtividadeEducacao(AtividadeEducacao object){
        super(object);
    }

    /**
     * Fator de dedução
     * @param f Fatura
     * @return valor deduzido
     */
    public double deduct(Fatura f){
        double x = f.getValor();
        return x * 0.30;
    }

    /**
     * {@inheritDoc}
     * @return
     */
    public AtividadeEducacao clone(){
        return new AtividadeEducacao(this);
    }

    /**
     * {@inheritDoc}
     * @return
     */
    @Override
    public String toString(){
        return "Educação";
    }

}


