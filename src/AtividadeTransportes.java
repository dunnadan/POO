import java.io.Serializable;

public class AtividadeTransportes extends Atividade implements Serializable{

    private static final long serialVersionUID = 1L;
    /**
     * Construtor Vazio de Atividade
     */
	public AtividadeTransportes(){
        super();
    }

    /**
     * Contrutor Atividade
     * @param nome nome da atividade
     */
    public AtividadeTransportes(String nome){
        super(nome);
    }

    /**
     * Contrutor por Objeto
     * @param object Atividade
     */
    public AtividadeTransportes(AtividadeTransportes object){
        super(object);
    }

    /**
     * {@inheritDoc}
     * @return
     */
    public AtividadeTransportes clone(){
        return new AtividadeTransportes(this);
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

    /**
     * {@inheritDoc}
     * @return
     */
    @Override
    public String toString(){
        return "Transporte";
    }
}
