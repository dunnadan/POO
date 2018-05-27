import java.util.Scanner;

public class StartApp {

    private static Scanner sc = new Scanner(System.in);

    /**
     * Menu principal da aplicação
     */
    private static String main_menu(){

        return "1. Login\n" +
               "2. Registrar-se\n" +
               "0. Sair da App\n";
    }

    /**
     * Inicia a aplicação
     */
    private static void start() {
        
        System.out.println("Escolha uma opção");
        System.out.println(main_menu());
        switch(sc.nextInt()){

            case 1: AppFunc.enter();
                    break;

            case 2: AppFunc.register();
                    start();
                    break;

            case 0: System.exit(0);

            default: System.out.println("Opção inválida\n");
                     start();
                     break;
        }
    }


    public static void main(String[] args) {
    DR.newDataBase("/home/BrunoMartins/POO/POO/src/id_fiscal.csv", "/home/BrunoMartins/POO/POO/src/fatura.csv");
        start();
    }
}