import java.io.Serializable;

public class AtividadePendente extends Atividade implements Serializable {


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

    public double deduct(Fatura f){
        return 0;
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

    public boolean equals(Object o){
        if(this == o) 
            return true;
        
        if(o == null || this.getClass()!= o.getClass()) 
            return false;

        return (this.getClass() == o.getClass());
    }

}
