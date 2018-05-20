import java.io.*;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class ControlClass implements Serializable {

    private static final long serialVersionUID = 1L;
	private Map<Integer, IdentidadeFiscal> userMap;
    private IdentidadeFiscal user;

    public ControlClass() {
        this.userMap = new HashMap<>();

    }

    //Insere Identidade Fiscal no Hash Map
    private void insert_IDFiscal(IdentidadeFiscal id) {
        this.userMap.put(id.getNIF(), id.clone());
    }


    public void login(Integer nif, String pass) throws NonExistentUserException, WrongPasswordException {

        IdentidadeFiscal user = this.userMap.get(nif);
        
        if(user == null) 
            throw new NonExistentUserException();
        
        if(!user.auth(pass)) 
            throw new WrongPasswordException();
        
            this.user = user;
    }

    public void inserirIDFiscal(IdentidadeFiscal id) {
        this.userMap.put(id.getNIF(), id);
    }

    public void makeEmpresa(int nif,
                            String nome,
                            String email,
                            String morada,
                            String password,
                            double coeficiente,
                            List<Atividade> atividades,
                            List<Fatura> faturas ){
        Empresa empresa = new Empresa(nif,nome,email,morada,password,coeficiente, atividades,faturas);
        inserirIDFiscal(empresa);

    }
    public void makeContribuinte(int nif, String nome, String email, String morada, String password,
                                 double coeficiente, List<Fatura> faturas, int[] dependentes,
                                 List<Atividade> atividades){

        Contribuinte contribuinte = new Contribuinte(nif, nome, email, morada, password, coeficiente, faturas, dependentes, atividades);
        inserirIDFiscal(contribuinte);
    }

    public IdentidadeFiscal getIDFiscal(Integer nif) {
        return this.userMap.get(nif);
    }

    public IdentidadeFiscal getUser(){
        return this.user;
    }

    public static void actions(int ctl){
        System.out.println(ctl);
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
    public List<Fatura> listFatEmpresaData(IdentidadeFiscal individual) throws IndividualInsteadOfEmpresaException {

        if(!(this.user instanceof Empresa)) throw new IndividualInsteadOfEmpresaException();
        return ((Empresa) this.user).faturasContribuinteData(individual.getNIF());
        }

    public List<Fatura> listFatEmpresaValor(IdentidadeFiscal individual) throws IndividualInsteadOfEmpresaException {

        if(!(this.user instanceof Empresa)) throw new IndividualInsteadOfEmpresaException();
        return ((Empresa) this.user).faturasContribuinteValor(individual.getNIF());
    }

    //total faturado num intervalo de tempo
    public double valorFaturadoTempo(LocalDateTime inicio, LocalDateTime fim) throws  IndividualInsteadOfEmpresaException{

        if(!(this.user instanceof Empresa)) throw new IndividualInsteadOfEmpresaException();
        return ((Empresa) this.user).totalFaturadoTempo(inicio,fim);
    }

    //lista de faturas de uma empresa ordenada por data
    public List<Fatura> fatEmpresaData() throws  IndividualInsteadOfEmpresaException{

        if(!(this.user instanceof Empresa)) throw new IndividualInsteadOfEmpresaException();
        return ((Empresa) this.user).faturasEmpresaData();
    }

    //lista de faturas de uma empresa ordenada por valor
    public List<Fatura> fatEmpresaValor() throws  IndividualInsteadOfEmpresaException{

        if(!(this.user instanceof Empresa)) throw new IndividualInsteadOfEmpresaException();
        return ((Empresa) this.user).faturasEmpresaValor();
    }

    //criaçao de fatura por parte de uma empresa
    public void criaFatura(String numero, int nif_emitente, int nif_cliente,
                           String descricao,Atividade atividade, double valor) throws IndividualInsteadOfEmpresaException, NonExistentUserException{

        if(!(this.user instanceof Empresa)) throw new IndividualInsteadOfEmpresaException();
        if(this.userMap.get(nif_cliente) == null) throw new NonExistentUserException();
        ((Empresa) this.user).makeFatura(numero, nif_emitente, nif_cliente, descricao, atividade, valor);
    }

    //relaçao das 10 empresas
    //TODO calcular o total de deduçao delas
    public List<Empresa> relacaoEmpresas() throws NotAdminExeption{

        if(!(this.user instanceof Admin)) {
            throw new NotAdminExeption();
        }

        List<IdentidadeFiscal> listaEmpresas = this.userMap.values().stream().filter(l -> l instanceof Empresa).collect(Collectors.toList());
        List<Empresa> lista = (List<Empresa>)(List<?>) listaEmpresas;
        lista.sort(new EmpresaComparatorValor());
        List<Empresa> listafinal = lista.stream().limit(10).collect(Collectors.toList());

        return listafinal;
    }

    public List<Contribuinte> relaçaoContribuintes() throws NotAdminExeption{
        if(!(this.user instanceof Admin)) {
            throw new NotAdminExeption();
        }
        List<IdentidadeFiscal> listaContribuinte= this.userMap.values().stream().filter(l -> l instanceof Contribuinte).collect(Collectors.toList());
        List<Contribuinte> lista = (List<Contribuinte>)(List<?>) listaContribuinte;
        lista.sort(new ContribuinteComparatorValor());

        List<Contribuinte> listafinal = lista.stream().limit(10).collect(Collectors.toList());

        return listafinal;
    }


}

