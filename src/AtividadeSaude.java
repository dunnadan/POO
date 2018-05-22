import java.io.Serializable;

public class AtividadeSaude extends Atividade implements Serializable{


    private static final long serialVersionUID = 1L;

	public AtividadeSaude(){
        super();
    }

    public AtividadeSaude(String nome){
        super(nome);
    }

    public AtividadeSaude(AtividadeSaude object){
        super(object);
    }


    public AtividadeSaude clone(){
        return new AtividadeSaude(this);
    }

    public double deduct(Fatura f){

        double x = f.getValor();
        return x * 0.15;
    }

    @Override
    public String toString(){
        return "Saúde";
    }

}

