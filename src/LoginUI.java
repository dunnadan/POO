import java.util.*;

public class LoginUI implements UI {

    private final ControlClass javaFactura;

    /**
     * \brief Constructor for the loginUI
     * @param controlClass The instance of the business logic
     */
    LoginUI(ControlClass controlClass){
        this.javaFactura = controlClass;
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
        } catch (NonExistentUserException | WrongPasswordException e) {
            System.out.println("Invalid credentials");
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
        return new Credentials(Integer.parseInt(answers.get(0)), answers.get(1));
    }

    /**
     * \brief Wrapper class to pass the credentials gotten from the form
     */
    private final class Credentials {

        private final Integer nif;
        private final String pass;

        /**
         * \brief Parametrised constructor
         * @param nif  nif
         * @param pass password
         */
        private Credentials(Integer nif, String pass){
            this.nif = nif;
            this.pass = pass;
        }

        /**
         * \brief Returns the NIF
         * @return The NIF
         */
        private Integer getNif(){
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