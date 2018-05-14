public class EmpresaUI implements UI {

    private final JavaFatura javaFactura;

    public EmpresaUI(JavaFatura javaFactura){

        this.javaFactura = javaFactura;
    }

    @Override
    public void run(){
        System.out.println("Logged in as Contribuinte Empresarial");
    }
}