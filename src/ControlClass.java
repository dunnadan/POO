import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ControlClass implements Serializable {

    private Map<Integer, IdentidadeFiscal> userMap;
    private IdentidadeFiscal user;

    public ControlClass() {
        this.userMap = new HashMap<>();

    }

    //Insere Identidade Fiscal no Hash Map
    public void insert_IDFiscal(IdentidadeFiscal id) {
        this.userMap.put(id.getNIF(), id.clone());
    }


    public void login(Integer nif, String pass) throws NonExistentUserException, WrongPasswordException {

        IdentidadeFiscal user = this.userMap.get(nif);
        if(user == null) throw new NonExistentUserException();
        if(!user.getPassword().equals(pass)) throw new WrongPasswordException();
        this.user = user;
    }

    public void makeIDFiscal(IdentidadeFiscal id) {
        this.userMap.put(id.getNIF(), id);
    }

    public IdentidadeFiscal getIDFiscal(Integer nif) {
        return this.userMap.get(nif);
    }



    //********************************* SAVE AND LOAD STATE FILE ************************************//

    public void saveState() throws IOException {
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("state.txt"));
        os.writeObject(this);
        os.flush();
        os.close();
    }


    public ControlClass loadState() throws IOException, ClassNotFoundException {

        ObjectInputStream is = new ObjectInputStream(new FileInputStream("state.txt"));
        ControlClass controlClass = (ControlClass) is.readObject();
        is.close();
        return controlClass;
    }

    //********************************* END OF SAVE AND LOAD ****************************************//


    //********************************* FUNCIONALIDADES DAS EMPRESAS ********************************//

    //lista das faturas de uma empresa referentes a um determinado contribuinte
    public List<Fatura> listFatEmpresa(IdentidadeFiscal individual) throws IndividualInsteadOfEmpresaException {
        if(!(this.user instanceof Empresa)) throw new IndividualInsteadOfEmpresaException();
        return ((Empresa) this.user).faturasContribuinte(individual.getNIF());
        }




}

