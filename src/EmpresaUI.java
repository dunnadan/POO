public class EmpresaUI implements UI {

    private final ControlClass javaFactura;

    public EmpresaUI(ControlClass javaFactura){

        this.javaFactura = javaFactura;
    }

    @Override
    public void run(){
        System.out.println("Logged in as Contribuinte Empresarial");
    }
}