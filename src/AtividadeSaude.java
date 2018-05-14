

public class AtividadeSaude extends Atividade{


    public double deduct(Fatura f){

        double x = f.getValor();
        return x * 0.15;
    }

}

