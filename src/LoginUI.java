import java.io.IOException;
import java.util.*;

public class LoginUI implements UI {

    private final JavaFatura javaFactura;

    /**
     * \brief Constructor for the loginUI
     * @param javaFatura The instance of the business logic
     */
    LoginUI(JavaFatura javaFatura){
        this.javaFactura = javaFatura;
        /*try{
            DataBase.saveData();//tem de ter parametros
        }catch(IOException e){
            e.printStackTrace();
        }
        */
    }
    /**
     * \brief Runs the user interface
     */
    public void run(){
        try{
            Credentials credentials = getCredentials();
            javaFactura.login(credentials.getNif(), credentials.getPass());
        }catch(NoSuchElementException e){
            System.out.println("Invalid credentials");
            e.printStackTrace();
            return;
        }
        /*IdentidadeFiscal u = this.javaFactura.getLoggedUser();
        if(u instanceof Admin){
            new AdminUI(javaFactura).run();
        }else if(u instanceof Contribuinte){
            new ContribuinteUI(javaFactura).run();
        }else if(u instanceof Empresa){
            new EmpresaUI(javaFactura).run();
        }*/
        System.out.println(getCredentials().nif + getCredentials().pass);
    }

    /**
     * \brief Gets the users credentials with a form
     * @return the users credentials
     */
    private Credentials getCredentials(){
        List<String> fields = new ArrayList<>();
        fields.add( "Nif: ");
        fields.add( "Password: ");
        Form login = new Form("Login", fields);
        login.execute();
        List<String> answers = login.getResult();
        return new Credentials(answers.get(0), answers.get(1));
    }

    /**
     * \brief Wrapper class to pass the credentials gotten from the form
     */
    private final class Credentials {

        private final String nif;
        private final String pass;

        /**
         * \brief Parametrised constructor
         * @param nif  nif
         * @param pass password
         */
        private Credentials(String nif, String pass){
            this.nif = nif;
            this.pass = pass;
        }

        /**
         * \brief Returns the NIF
         * @return The NIF
         */
        private String getNif(){
            return this.nif;
        }

        /**
         * \brief Returns the password
         * @return The password
         */
        private String getPass(){
            return this.pass;
        }
    }
}