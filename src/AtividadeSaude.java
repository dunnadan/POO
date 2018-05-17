

public class AtividadeSaude extends Atividade{


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

}

