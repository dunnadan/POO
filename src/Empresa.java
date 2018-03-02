import java.util.ArrayList;

public class Empresa extends IdentidadeFiscal implements java.io.Serializable {

    //Constructors
    public Empresa(){

        this.atividades = new ArrayList<String>();
        this.faturas = new ArrayList<String>();
        this.faturas_obj = new ArrayList<Fatura>();
    }

    public Empresa(int nif, String nome, String email, String morada, String password, double coeficiente, String[] faturas, String[] atividades){
        
        this.atividades = new ArrayList<String>();
        this.faturas = new ArrayList<String>();
        this.faturas_obj = new ArrayList<Fatura>();

        this.nif = nif;
        this.nome = nome;
        this.email = email;
        this.morada = morada;
        this.password = password;
        this.coeficiente = coeficiente;

        for(String fat : faturas)
            this.faturas.add(fat);

        for(String atv : atividades)
            this.atividades.add(atv);
    }

    public Empresa(Empresa object){
        
        this.atividades = new ArrayList<String>();
        this.faturas = new ArrayList<String>();
        this.faturas_obj = new ArrayList<Fatura>();

        this.nif = object.getNIF();
        this.nome = object.getNome();
        this.email = object.getEmail();
        this.morada = object.getMorada();
        this.password = object.getPassword();
        this.coeficiente = object.getCoeficiente();
        this.atividades = object.getAtividades();
        this.faturas_obj = object.getFaturasObject();
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

    
}
