import java.io.*;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.uitl.DateTimeFormatter;

public class ControlClass {

    public static void actions(IdentidadeFiscal id_fiscal, int ctl){
        if (id_fiscal instanceof Contribuinte){

            switch(ctl){

                case 1:
            }

        }

        else if (id_fiscal instanceof Empresa){

            Empresa emp = (Empresa) id_fiscal;
            listFatEmpresaData(emp);


        }

        else {


        }
    }

    //********************************* FUNCIONALIDADES DAS EMPRESAS ********************************//

    //lista das faturas de uma empresa referentes a um determinado contribuinte
    private static void listFatEmpresaData(Empresa individual) {
        List<Fatura> ret = individual.faturasContribuinteData(individual.getNIF());

        System.out.println(ret);         
        }

    private static void listFatEmpresaValor(Empresa individual){
        List<Fatura> ret = individual.faturasContribuinteValor(individual.getNIF());

        System.out.println(ret);
    }

    //total faturado num intervalo de tempo
    private static void valorFaturadoTempo(Empresa individual){
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/mm/yyyy");

        System.out.println("Data de início: dd/mm/yyyy");
        LocalDateTime inicio = LocalDateTime.parse(sc.nextLine(), formatter);

        System.out.println("Data de término: dd/mm/yyyy");
        LocalDateTime fim = LocalDateTime.parse(sc.nextLine(), formatter);

        System.out.println(individual.totalFaturadoTempo(inicio,fim));
    }

    //lista de faturas de uma empresa ordenada por data
    private static void fatEmpresaData(Empresa individual){
        List<Fatura> ret = individual.faturasEmpresaData();

        System.out.println(ret);
    }

    //lista de faturas de uma empresa ordenada por valor
    private static void fatEmpresaValor(Empresa individual){
        List<Fatura> ret = individual.faturasEmpresaValor();

        System.out.println(ret);
    }

    //criaçao de fatura por parte de uma empresa
    private static void criaFatura(String numero, int nif_emitente, int nif_cliente,
                           String descricao,Atividade atividade, double valor){

        if(this.userMap.get(nif_cliente) == null) throw new NonExistentUserException();
        ((Empresa) this.user).makeFatura(numero, nif_emitente, nif_cliente, descricao, atividade, valor);
    }

    //relaçao das 10 empresas
    //TODO calcular o total de deduçao delas
    private static List<Empresa> relacaoEmpresas() throws NotAdminExeption{

        if(!(this.user instanceof Admin)) {
            throw new NotAdminExeption();
        }

        List<IdentidadeFiscal> listaEmpresas = this.userMap.values().stream().filter(l -> l instanceof Empresa).collect(Collectors.toList());
        List<Empresa> lista = (List<Empresa>)(List<?>) listaEmpresas;
        lista.sort(new EmpresaComparatorValor());
        List<Empresa> listafinal = lista.stream().limit(10).collect(Collectors.toList());

        return listafinal;
    }

    private static List<Contribuinte> relaçaoContribuintes() throws NotAdminExeption{
        if(!(this.user instanceof Admin)) {
            throw new NotAdminExeption();
        }
        List<IdentidadeFiscal> listaContribuinte= this.userMap.values().stream().filter(l -> l instanceof Contribuinte).collect(Collectors.toList());
        List<Contribuinte> lista = (List<Contribuinte>)(List<?>) listaContribuinte;
        lista.sort(new ContribuinteComparatorValor());

        List<Contribuinte> listafinal = lista.stream().limit(10).collect(Collectors.toList());

        return listafinal;
    }

*/
}

