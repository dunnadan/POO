public class ContribuinteUI implements UI {

    private final JavaFatura javaFactura;

    public ContribuinteUI(JavaFatura javaFactura){
        this.javaFactura = javaFactura;
    }

    @Override
    public void run(){
        System.out.println("Logged in as Contribuinte Individual");
    }
}