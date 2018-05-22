import java.util.Scanner;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.time.format.DateTimeFormatter;

public class ControlClass {

    public static void actions(IdentidadeFiscal id_fiscal, int ctl) {
        if (id_fiscal instanceof Contribuinte){

            Contribuinte cont = (Contribuinte) id_fiscal;
            
            switch(ctl){
                case 1:
                    System.out.println(id_fiscal.getFaturas() + "\n");
                    break;

                case 2:
                    break;

                case 3:
                    break;

                case 4:
                    break;

                case 5:
                    addDependente(cont);
                    break;

                case 0:
                    break;

                default: 
                    actions(id_fiscal, ctl);
                    break;
            }

        }

        else if (id_fiscal instanceof Empresa){

            Empresa emp = (Empresa) id_fiscal;

            switch(ctl){
                case 1:
                    criaFatura(emp);
                    break;

                case 2:
                    System.out.println(listFatEmpresaData(emp));
                    break;

                case 3:
                    System.out.println(listFatEmpresaValor(emp));
                    break;

                case 4:
                    System.out.println(fatEmpresaValor(emp));
                    break;

                case 5:
                    System.out.println(fatEmpresaData(emp));
                    break;

                case 6:
                    System.out.println(valorFaturadoTempo(emp));
                    break;

                case 0:
                    break;

                default: 
                    actions(id_fiscal, ctl);
                    break;
            }            
        }

        else {

            Admin adm = (Admin) id_fiscal;


        }
    }

    //********************************* FUNCIONALIDADES DAS EMPRESAS ********************************//

    //lista das faturas de uma empresa referentes a um determinado contribuinte
    private static List<Fatura> listFatEmpresaData(Empresa individual) {

        Scanner sc = new Scanner(System.in);

        System.out.print("NIF contribuinte: ");
        List<Fatura> ret = individual.faturasContribuinteData(Integer.valueOf(sc.nextLine()));
        sc.close();

        return ret;         
        }

    private static List<Fatura> listFatEmpresaValor(Empresa individual){

        Scanner sc = new Scanner(System.in);

        System.out.print("NIF contribuinte: ");
        List<Fatura> ret = individual.faturasContribuinteValor(Integer.valueOf(sc.nextLine()));
        sc.close();

        return ret;
    }

    //total faturado num intervalo de tempo
    private static double valorFaturadoTempo(Empresa individual){
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Data de início: dd/mm/yyyy");
        LocalDateTime inicio = LocalDateTime.parse(sc.nextLine(), formatter);

        System.out.println("Data de término: dd/mm/yyyy");
        LocalDateTime fim = LocalDateTime.parse(sc.nextLine(), formatter);

        sc.close();

        return individual.totalFaturadoTempo(inicio,fim);

        
    }

    //lista de faturas de uma empresa ordenada por data
    private static List<Fatura> fatEmpresaData(Empresa individual){
        List<Fatura> ret = individual.faturasEmpresaData();

        return ret;
    }

    //lista de faturas de uma empresa ordenada por valor
    private static List<Fatura> fatEmpresaValor(Empresa individual){
        List<Fatura> ret = individual.faturasEmpresaValor();

        return ret;
    }

    //criaçao de fatura por parte de uma empresa
    private static void criaFatura(Empresa individual) {

        Scanner sc = new Scanner(System.in);
        Atividade atv;
        String num = Integer.toString(individual.getFaturas().size()+1);

        System.out.print("NIF: ");
        int nif = Integer.valueOf(sc.nextLine());

        System.out.print("Valor: ");
        double valor = Double.parseDouble(sc.nextLine());

        System.out.print("Descrição: ");
        String descricao = sc.nextLine();
        
        if (individual.getNumAtividades() > 1)
            atv = new AtividadePendente();
        
        else
            atv = individual.getAtividades().get(0);

        Fatura fat = new Fatura(num, individual.getNIF(), nif, descricao, atv, valor);

        try {
            Contribuinte cont = AppFunc.getContribuinte(nif);
            cont.addFaturas(fat);
            individual.addFaturas(fat); 
            System.out.println("Fatura nº: " + individual.getFaturas().size() + " criada com sucesso!\n");
        }

        catch (NonExistentUserException e){
            System.out.println("Erro: Usuário não existe\n");
        }

        finally {
            sc.close();
        }
    }

    

    /*
    //relaçao das 10 empresas
    //TODO calcular o total de deduçao delas
    private static void relacaoEmpresas(){

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

    private static void addDependente(Contribuinte id){
        Scanner sc = new Scanner(System.in);

        System.out.print("NIF dependente: ");
        id.addDependente(Integer.valueOf(sc.nextLine()));
        System.out.println("Dependente adicionado!\n");

        sc.close();
    }


}

