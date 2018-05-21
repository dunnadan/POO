import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;

public class AppFunc {

    private static IdentidadeFiscal id_fiscal;
    private static Map<Integer,IdentidadeFiscal> db = DataBase.loadData();
    private static Scanner sc = new Scanner(System.in);

    private static void login(Integer nif, String password) throws WrongPasswordException, NonExistentUserException{

        id_fiscal = db.get(nif);

        if (id_fiscal == null)
            throw new NonExistentUserException();
        
        else if  (!(id_fiscal.auth(password)))
            throw new WrongPasswordException();

        else 
            System.out.println("Login successful\n");
    }


    public static void register(){
        int ctl;

        System.out.println("Escolha uma opção");
        System.out.println("1. Contribuinte\n2. Empresa\n0. Sair da App");
        ctl = Integer.valueOf(sc.nextLine());

        switch(ctl){
            
            case 1:
                Registro.contribuinte(db);
                break;

            case 2:
                Registro.empresa(db);
                break;

            case 0:
                System.exit(0);

            default:
                System.out.println("Opção inválida\n\n");
                register();
        }
    }

    public static void enter() {

        int ctl = 1, nif;
        String password;


        try {
            System.out.print("NIF: ");
            nif = Integer.valueOf(sc.nextLine());
            System.out.print("Password: ");
            password = sc.nextLine();

            login(nif, password);
        }
        
        catch(NonExistentUserException e){
            e.printStackTrace();
        }
        
        catch(WrongPasswordException p){
            p.printStackTrace();
        }

        while(ctl != 0){
            System.out.println(id_fiscal.menu());
            
            ctl = Integer.valueOf(sc.nextLine());

            //ControlClass.actions(id_fiscal, ctl);
        }

        DataBase.saveData(db);
    }
}