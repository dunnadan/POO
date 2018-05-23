import java.util.*;
import java.util.stream.Collectors;

public class AppFunc {

    private static IdentidadeFiscal id_fiscal;
    public static Map<Integer, IdentidadeFiscal> db = DataBase.loadData();

    private static void login(Integer nif, String password) throws WrongPasswordException, NonExistentUserException {

        id_fiscal = db.get(nif);

        if (id_fiscal == null)
            throw new NonExistentUserException();

        else if (!(id_fiscal.auth(password)))
            throw new WrongPasswordException();

        else
            System.out.println("Login successful\n");
    }


    public static Contribuinte getContribuinte(int nif) throws NonExistentUserException {

        IdentidadeFiscal cont = db.get(nif);

        if (cont != null && cont instanceof Contribuinte) {
            return (Contribuinte) cont;
        } else
            throw new NonExistentUserException();
    }

    public static List<Empresa> getAllEmpresas(){
        return db.values().stream().filter(Empresa.class::isInstance).map(Empresa.class::cast)
                .collect(Collectors.toList());
    }

    public static List<Contribuinte> getAllContribuintes(){
        return db.values().stream().filter(Contribuinte.class::isInstance).map(Contribuinte.class::cast)
                .collect(Collectors.toList());
    }



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
        } catch (ExistentUserException e) {
            System.out.println("Usuários " + e.getNIF() + " já existe.");
        } finally {
            sc.close();
        }
    }

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
        } catch (NonExistentUserException e) {
            System.out.println("Erro: " + e);
        } catch (WrongPasswordException p) {
            System.out.println("Erro: " + p);
        } finally {
            DataBase.saveData(db);
            sc.close();
        }
    }
}