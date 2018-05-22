import java.io.Serializable;

public class AtividadeTransportes extends Atividade implements Serializable{

    private static final long serialVersionUID = 1L;

	public AtividadeTransportes(){
        super();
    }

    public AtividadeTransportes(String nome){
        super(nome);
    }

    public AtividadeTransportes(AtividadeTransportes object){
        super(object);
    }


    public AtividadeTransportes clone(){
        return new AtividadeTransportes(this);
    }

    public double deduct(Fatura f){

        double x = f.getValor();
        return x * 0.15;
    }

    @Override
    public String toString(){
        return "Transporte";
    }
}
