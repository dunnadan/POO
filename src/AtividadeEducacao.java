import java.io.Serializable;

public class AtividadeEducacao extends Atividade implements Serializable {


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
    public double deduct(Fatura f) throws NonExistentUserException{

        double x = f.getValor();
        Contribuinte cont = AppFunc.getContribuinte(f.getNIFCliente());
        double ded = cont.getCoeficiente() + 0.1;
        if(Concelhos.contemConcelho(AppFunc.getEmpresa(f.getNIFEmitente()).getConcelho())) {
            ded +=0.05;
        }
        if(cont.getDependentes().size()>3) {
            ded +=0.05;
        }
        if(x*ded > 1000) return 1000;
        return x*ded;
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

    public boolean equals(Object o){
        if(this == o) 
            return true;
        
        if(o == null || this.getClass() != o.getClass()) 
            return false;

        return (this.getClass() == o.getClass());
    }

}


