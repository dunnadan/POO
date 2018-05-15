import java.util.Map;

public class JavaFatura {

    private Map<Integer,String> credenciais;
    private Map<Integer,IdentidadeFiscal> user;

    boolean login(Integer nif, String pass){
        return ;
    }

    public void makeIDFiscal(IdentidadeFiscal id){
        this.user.put(id.getNIF(),id);
    }

    public IdentidadeFiscal getIDFiscal(Integer nif){
        return this.user.get(nif);
    }


}
