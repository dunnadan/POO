public class AdminUI implements UI {

    private final JavaFatura javaFactura;

    AdminUI(JavaFatura javaFactura){
        this.javaFactura = javaFactura;
    }

    @Override
    public void run(){
        System.out.println("Logged in as admin");
    }
}
