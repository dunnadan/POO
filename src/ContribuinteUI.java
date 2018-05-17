public class ContribuinteUI implements UI {

    private final ControlClass javaFactura;

    public ContribuinteUI(ControlClass javaFactura){
        this.javaFactura = javaFactura;
    }

    @Override
    public void run(){
        System.out.println("Logged in as Contribuinte Individual");
    }
}