import java.util.Scanner;
import java.util.Map;

public class Registro {

    private static Scanner sc = new Scanner(System.in);

    /**
     * Faz o cadastro de um novo contribuinte
     * @param db Base de dados
     */

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

    /**
     * Faz o cadastro de uma nova empresa
     * @param sb Base de dados
     */
    public static void empresa(Map<Integer,IdentidadeFiscal> db) throws ExistentUserException{
        
        Empresa id = new Empresa();

        System.out.print("Nome: ");
        id.setNome(sc.nextLine());

        System.out.print("NIF: ");
        id.setNIF(Integer.valueOf(sc.nextLine()));

        System.out.print("Email: ");
        id.setEmail(sc.nextLine());

        System.out.print("Password: ");
        id.setPassword(sc.nextLine());

        System.out.print("Concelho: ");
        id.setConcelho(sc.nextLine());

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