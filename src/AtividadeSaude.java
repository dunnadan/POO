import java.io.Serializable;

public class AtividadeSaude extends Atividade implements Serializable{


    private static final long serialVersionUID = 1L;
    /**
     * Construtor Vazio de Atividade
     */
	public AtividadeSaude(){
        super();
    }

    /**
     * Contrutor Atividade
     * @param nome nome da atividade
     */
    public AtividadeSaude(String nome){
        super(nome);
    }
    /**
     * Contrutor por Objeto
     * @param object Atividade
     */
    public AtividadeSaude(AtividadeSaude object){
        super(object);
    }

    /**
     * {@inheritDoc}
     * @return
     */
    public AtividadeSaude clone(){
        return new AtividadeSaude(this);
    }

    /**
     * Fator de dedução
     * @param f Fatura
     * @return valor deduzido
     */
    public double deduct(Fatura f){

        double x = f.getValor();
        return x * 0.15;
    }

    @Override
    public String toString(){
        return "Saúde";
    }

}

