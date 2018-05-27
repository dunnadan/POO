import java.io.Serializable;

public class AtividadeSaude extends Atividade implements Serializable {


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
    public double deduct(Fatura f) throws NonExistentUserException{

        double x = f.getValor();
        Contribuinte cont = AppFunc.getContribuinte(f.getNIFCliente());
        double ded = cont.getCoeficiente() + 0.15;
        if(Concelhos.contemConcelho(AppFunc.getEmpresa(f.getNIFEmitente()).getConcelho())) {
            ded +=0.05;
        }
        if(cont.getDependentes().size()>3) {
            ded +=0.05;
        }
        if(x*ded > 1200) return 1200;
        return x*ded;
    }

    @Override
    public String toString(){
        return "Saúde";
    }

    public boolean equals(Object o){
        if(this == o) 
            return true;
        
        if(o == null || this.getClass()!= o.getClass()) 
            return false;

        return (this.getClass() == o.getClass());
    }

}

