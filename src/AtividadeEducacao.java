public class AtividadeEducacao extends Atividade implements Deduzivel {


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

}


