public class AtividadeTransportes extends Atividade{

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
}
