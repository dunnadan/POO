import java.util.ArrayList;
import java.util.List;

public class Empresa extends IdentidadeFiscal  implements java.io.Serializable {

    //Constructors
    public Empresa(){
        super();

    }

    public Empresa(int nif, String nome, String email, String morada, String password, double coeficiente, List<String> faturas, List<String> atividades){
        
        super(nif,nome,email,morada,password,coeficiente,faturas,atividades);
    }

    public Empresa(Empresa object){
        
        super(object);
    }

    //Methods
    public void associaFatura(Contribuinte cont, Fatura fat){
        
        if(! cont.faturas_obj.contains(fat)){
            cont.faturas_obj.add(fat);
            fat.setNIFCliente(cont.getNIF());
            fat.setNIFEmitente(this.getNIF());
            this.addFaturasObject(fat);
            
            if (! cont.faturas.contains(fat.getNumero()))
                cont.faturas.add(fat.getNumero());
            
            if (! this.faturas.contains(fat.getNumero()))
                this.faturas.add(fat.getNumero());
        }
    }

    public Empresa clone(){
        return new Empresa(this);
    }
}
