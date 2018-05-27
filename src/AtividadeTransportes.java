import java.io.Serializable;

public class AtividadeTransportes extends Atividade implements Serializable {

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
    public double deduct(Fatura f) throws NonExistentUserException{

        double x = f.getValor();
        Contribuinte cont = AppFunc.getContribuinte(f.getNIFCliente());
        double ded = cont.getCoeficiente();
        if(Concelhos.contemConcelho(AppFunc.getEmpresa(f.getNIFEmitente()).getConcelho())) {
            ded +=0.05;
        }
        if(cont.getDependentes().size()>3) {
            ded +=0.05;
        }
        if(x*ded > 100) return 100;
        return x*ded;
    }
    /**
     * {@inheritDoc}
     * @return
     */
    @Override
    public String toString(){
        return "Transporte";
    }

    public boolean equals(Object o){
        if(this == o) 
            return true;
        
        if(o == null || this.getClass()!= o.getClass()) 
            return false;

        return (this.getClass() == o.getClass());
    }
}
