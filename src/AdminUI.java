public class AdminUI implements UI {

    private final ControlClass javaFactura;

    AdminUI(ControlClass javaFactura){
        this.javaFactura = javaFactura;
    }

    @Override
    public void run(){
        System.out.println("Logged in as admin");
    }
}
