public class AtividadePendente extends Atividade {


    public AtividadePendente(){
        super();
    }

    public AtividadePendente(String nome){
        super(nome);
    }

    public AtividadePendente(AtividadePendente object){
        super(object);
    }


    public AtividadePendente clone(){
        return new AtividadePendente(this);
    }


}
