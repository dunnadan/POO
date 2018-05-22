import java.io.Serializable;

public class AtividadeEducacao extends Atividade implements Deduzivel, Serializable {


    private static final long serialVersionUID = 1L;

	public AtividadeEducacao(){
        super();
    }

    public AtividadeEducacao(String nome){
        super(nome);
    }

    public AtividadeEducacao(AtividadeEducacao object){
        super(object);
    }


    public double deduct(Fatura f){
        double x = f.getValor();
        return x * 0.30;
    }

    public AtividadeEducacao clone(){
        return new AtividadeEducacao(this);
    }

    @Override
    public String toString(){
        return "Educação";
    }

}


