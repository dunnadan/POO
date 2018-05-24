public class Admin extends IdentidadeFiscal {

    /**
     * {@inheritDoc}
     * @return
     */
    @Override
    public IdentidadeFiscal clone() {
        return null;
    }

    public String menu() {
        
        return "1. Lista de facturas de uma determinada empresa\n" +
               "2. Total facturado por uma empresa num determinado período\n" +
               "3. Relação dos 10 contribuintes que mais gastam\n" +
               "4. Relação das 10 empresas que mais faturam em todo o sistema\n" +
               "0. Sair da App\n";
    }
}
