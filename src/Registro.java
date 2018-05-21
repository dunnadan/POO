import java.util.Scanner;
import java.util.Map;

public class Registro {

    private static Scanner sc = new Scanner(System.in);

    public static void contribuinte(Map<Integer,IdentidadeFiscal> db){
        
        IdentidadeFiscal id = new Contribuinte();

        System.out.print("Nome: ");
        id.setNome(sc.nextLine());

        System.out.print("NIF: ");
        id.setNIF(Integer.valueOf(sc.nextLine()));

        System.out.print("Email: ");
        id.setEmail(sc.nextLine());

        System.out.print("Password: ");
        id.setPassword(sc.nextLine());

        System.out.print("Morada: ");
        id.setMorada(sc.nextLine());
        System.out.println();

        id.setCoeficiente(0.2);

        db.put(id.getNIF(), id);
        
        DataBase.saveData(db);
    }

    public static void empresa(Map<Integer,IdentidadeFiscal> db){
        
        IdentidadeFiscal id = new Empresa();

        System.out.print("Nome: ");
        id.setNome(sc.next());

        System.out.print("NIF: ");
        id.setNIF(sc.nextInt());

        System.out.print("Email: ");
        id.setEmail(sc.next());

        System.out.print("Morada: ");
        id.setMorada(sc.next());

        System.out.print("Password: ");
        id.setPassword(sc.next());
        System.out.println();

        id.setCoeficiente(0.2);

        db.put(id.getNIF(), id);
        
        DataBase.saveData(db);
    }
}