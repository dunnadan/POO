public class AtividadeAlimentacao extends Atividade{


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
}
