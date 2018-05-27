import java.util.*;
import java.util.stream.Collectors;

public class AppFunc {

    private static IdentidadeFiscal id_fiscal;
    private static Map<Integer, IdentidadeFiscal> db = DataBase.loadData();

    /**
     * Autentica um usuário na aplicação
     * @param nif NIF do usuário
     * @param password Senha do usuário
     */
    private static void login(Integer nif, String password) throws WrongPasswordException, NonExistentUserException {

        id_fiscal = db.get(nif);

        if (id_fiscal == null)
            throw new NonExistentUserException();

        else if (!(id_fiscal.auth(password)))
            throw new WrongPasswordException();

        else
            System.out.println("Login successful\n");
    }


    /**
     * Busca um contribuinte na base de dados
     * @param nif NIF do contribuinte
     * @return O contribuinte procurado 
     */
    public static Contribuinte getContribuinte(int nif) throws NonExistentUserException {

        IdentidadeFiscal cont = db.get(nif);

        if (cont != null && cont instanceof Contribuinte) {
            return (Contribuinte) cont;
        }
        
        else
            throw new NonExistentUserException();
    }

    /**
     * Busca umq empresa na base de dados
     * @param nif NIF da empresa
     * @return A empresa procurado 
     */
    public static Empresa getEmpresa(int nif) throws NonExistentUserException {

        IdentidadeFiscal emp = db.get(nif);

        if (emp != null && emp instanceof Empresa) {
            return (Empresa) emp;
        }
        
        else
            throw new NonExistentUserException();
    }


    /**
     * Lista de todas as empresas na base da dados.
     * @return Lista com todas as empresas na base da dados
     */
    public static List<Empresa> getAllEmpresas(){
        List<Empresa> list = db.values().stream()
                .filter(identidadeFiscal -> identidadeFiscal instanceof Empresa)
                .map(identidadeFiscal -> (Empresa) identidadeFiscal).map(Empresa::clone)
                .collect(Collectors.toList());
        return list;
    }

    /**
     * Lista de todos os contribuintes na base da dados.
     * @return Lista com todos os contribuintes na base da dados
     */
    public static List<Contribuinte> getAllContribuintes(){
        return db.values().stream().filter(Contribuinte.class::isInstance).map(Contribuinte.class::cast)
                .map(Contribuinte::clone).collect(Collectors.toList());
    }


    /**
     * Faz o registro de um usuário na aplicação
     */
    public static void register() {

        Scanner sc = new Scanner(System.in);
        int ctl;

        System.out.println("Escolha uma opção");
        System.out.println("1. Contribuinte\n2. Empresa\n0. Sair da App");
        ctl = Integer.valueOf(sc.nextLine());

        try {
            switch (ctl) {

                case 1:
                    Registro.contribuinte(db);
                    DataBase.saveData(db);
                    break;

                case 2:
                    Registro.empresa(db);
                    DataBase.saveData(db);
                    break;

                case 0:
                    System.exit(0);

                default:
                    System.out.println("Opção inválida\n\n");
                    register();
            }
        } 
        
        catch (ExistentUserException e) {
            System.out.println("Usuário " + e.getNIF() + " já existe.");
        } 
        
        finally {
            sc.close();
        }
    }

    /**
     * Faz login na aplicação
     */
    public static void enter() {

        Scanner sc = new Scanner(System.in);
        int ctl = 1;

        try {
            System.out.print("NIF: ");
            int nif = Integer.valueOf(sc.nextLine());

            System.out.print("Password: ");
            String password = sc.nextLine();

            login(nif, password);

            while (ctl != 0) {
                System.out.println(id_fiscal.menu());
                ctl = Integer.valueOf(sc.nextLine());
                ControlClass.actions(id_fiscal, ctl);
            }
        }

        catch (NonExistentUserException e) {
            System.out.println("Erro: " + e);
        }

        catch (WrongPasswordException p) {
            System.out.println("Erro: " + p);
        }

        finally {
            DataBase.saveData(db);
            sc.close();
        }
    }
}