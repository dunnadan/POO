import java.io.Serializable;

public class AtividadePendente extends Atividade implements Serializable{


    private static final long serialVersionUID = 1L;


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

    @Override
    public String toString(){
        return "Pendente";
    }


}
