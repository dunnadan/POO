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
        id.addAtividades(addAtividade_IO());
        
        if (db.putIfAbsent(id.getNIF(), id) == null)
            return;
        else
            throw new ExistentUserException(id.getNIF());
    }

    private static Atividade addAtividade_IO(){
        Scanner sc = new Scanner(System.in);
        Atividade atv;

        System.out.println("Escolha uma atividade");
        System.out.println("1. Alimentação\n2. Educação\n3. Lazer\n4. Saúde\n");

        switch(Integer.valueOf(sc.nextLine())){

            case 1:
                atv = new AtividadeAlimentacao();
                break;

            case 2:
                atv = new AtividadeEducacao();
                break;

            case 3:
                atv = new AtividadeLazer();
                break;

            case 4:
                atv = new AtividadeSaude();
                break;

            default:
                System.out.println("Opção inválida");
                atv = addAtividade_IO();
                break;
        }

        sc.close();
        return atv;
    }
}