import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Empresa extends IdentidadeFiscal  implements java.io.Serializable {

    //Constructors
    public Empresa(){


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

    public double compareTo(Fatura compareFatura) {

        double compareQuantity = ((Fatura) compareFatura).getValor();

        //ascending order
        return super(valor) - compareQuantity;

    public double listaFaturas(ArrayList<Fatura> faturas){
        List<Fatura> newfat = new ArrayList<>();
        double max=0;
        for (Fatura ft: newfat ){
            if(ft.getValor()>max) max=ft.getValor();
        }
    }
}
