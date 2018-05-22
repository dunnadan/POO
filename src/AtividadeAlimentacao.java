import java.io.Serializable;

public class AtividadeAlimentacao extends Atividade implements Serializable{


    private static final long serialVersionUID = 1L;

	public AtividadeAlimentacao(){
        super();
    }

    public AtividadeAlimentacao(String nome){
        super(nome);
    }

    public AtividadeAlimentacao(AtividadeAlimentacao object){
        super(object);
    }

    public double deduct(Fatura f){

        double x = f.getValor();
        return x * 0.20;
    }

    public AtividadeAlimentacao clone(){
        return new AtividadeAlimentacao(this);
    }

    @Override
    public String toString(){
        return "Alimentação";
    }
}
