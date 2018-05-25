import java.io.Serializable;

public class AtividadePendente extends Atividade implements Serializable{


    private static final long serialVersionUID = 1L;

    /**
     * Construtor Vazio de Atividade
     */
	public AtividadePendente(){
        super();
    }

    /**
     * Contrutor Atividade
     * @param nome nome da atividade
     */
    public AtividadePendente(String nome){
        super(nome);
    }
    /**
     * Contrutor por Objeto
     * @param object Atividade
     */
    public AtividadePendente(AtividadePendente object){
        super(object);
    }

    /**
     * {@inheritDoc}
     * @return
     */
    public AtividadePendente clone(){
        return new AtividadePendente(this);
    }

    /**
     * {@inheritDoc}
     * @return
     */
    @Override
    public String toString(){
        return "Pendente";
    }


}
