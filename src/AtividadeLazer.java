import java.io.Serializable;

public class AtividadeLazer extends Atividade implements Serializable {


    private static final long serialVersionUID = 1L;

    /**
     * Construtor Vazio de Atividade
     */
	public AtividadeLazer(){
        super();
    }

    /**
     * Contrutor Atividade
     * @param nome nome da atividade
     */
    public AtividadeLazer(String nome){
        super("Lazer");
    }
    /**
     * Contrutor por Objeto
     * @param object Atividade
     */
    public AtividadeLazer(AtividadeLazer object){
        super(object);
    }

    /**
     * Fator de dedução
     * @param f Fatura
     * @return valor deduzido
     */
    public double deduct(Fatura f){ //Lazer, do genero de concertos, etc, não deduz, pelo menos aqui, hipoteticamente.
        return 0;
    }

    /**
     * {@inheritDoc}
     * @return
     */
    public AtividadeLazer clone(){
        return new AtividadeLazer(this);
    }

    /**
     * {@inheritDoc}
     * @return
     */
    @Override
    public String toString(){
        return "Lazer";
    }

    public boolean equals(Object o){
        if(this == o) 
            return true;
        
        if(o == null || this.getClass()!= o.getClass()) 
            return false;

        return (this.getClass() == o.getClass());    
    }

}

