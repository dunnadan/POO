public class AtividadeLazer extends Atividade{


    public AtividadeLazer(){
        super();
    }

    public AtividadeLazer(String nome){
        super(nome);
    }

    public AtividadeLazer(AtividadeLazer object){
        super(object);
    }

    public double deduct(Fatura f){ //Lazer, do genero de concertos, etc, não deduz, pelo menos aqui, hipoteticamente.
        return 0;
    }

    public AtividadeLazer clone(){
        return new AtividadeLazer(this);
    }

}

