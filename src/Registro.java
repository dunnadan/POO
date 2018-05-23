import java.util.Scanner;
import java.util.Map;

public class Registro {

    private static Scanner sc = new Scanner(System.in);

    public static void contribuinte(Map<Integer,IdentidadeFiscal> db) throws ExistentUserException{
        
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

        if (db.putIfAbsent(id.getNIF(), id) == null)
            return;
        else
            throw new ExistentUserException(id.getNIF());
    }

    public static void empresa(Map<Integer,IdentidadeFiscal> db) throws ExistentUserException{
        
        IdentidadeFiscal id = new Empresa();

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
        id.addAtividades(ControlClass.addAtividade_IO());
        
        if (db.putIfAbsent(id.getNIF(), id) == null)
            return;
        else
            throw new ExistentUserException(id.getNIF());
    }

    
}