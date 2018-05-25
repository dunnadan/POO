import java.util.Scanner;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.time.format.DateTimeFormatter;

public class ControlClass {

    public static void actions(IdentidadeFiscal id_fiscal, int ctl) {
        if (id_fiscal instanceof Contribuinte){

            Contribuinte cont = (Contribuinte) id_fiscal;
            
            switch(ctl){
                case 1:
                    System.out.println(id_fiscal.getFaturas());
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

                case 6:
                    System.out.println(cont.getDependentes());
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

                case 7:
                    System.out.println(emp.getFaturas());
                    break;

                case 8:
                    emp.addAtividades(addAtividade_IO());
                    break;

                case 9:
                    System.out.println(emp.getAtividades());
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
        LocalDate inicio = LocalDate.parse(sc.nextLine(), formatter);

        System.out.println("Data de término: dd/mm/yyyy");
        LocalDate fim = LocalDate.parse(sc.nextLine(), formatter);

        sc.close();

        return individual.totalFaturadoTempo(inicio,fim);

        
    }

    //lista de faturas de uma empresa ordenada por data
    private static List<Fatura> fatEmpresaData(Empresa individual){

        return individual.faturasEmpresaData();
    }

    //lista de faturas de uma empresa ordenada por valor
    private static List<Fatura> fatEmpresaValor(Empresa individual){

        return individual.faturasEmpresaValor();
    }

    //TODO calcular o total de deduçao delas
    private static List<Empresa> relacao10Empresas() {

        return AppFunc.getAllEmpresas().stream().sorted(new EmpresaComparatorValor()).limit(10)
                .collect(Collectors.toList());
    }

    private static List<Contribuinte> relacao10Contribuintes() {

        return AppFunc.getAllContribuintes().stream()
                .sorted(new ContribuinteComparatorValor()).limit(10)
                .collect(Collectors.toList());
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

    public static Atividade addAtividade_IO(){
        Scanner sc = new Scanner(System.in);
        Atividade atv;

        System.out.println("Escolha uma atividade");
        System.out.println("1. Alimentação\n2. Educação\n3. Lazer\n4. Saúde\n");

        switch(Integer.valueOf(sc.nextLine())){

            case 1:
                atv = new AtividadeAlimentacao();
                break;

            case 2:
                atv = new AtividadeEducacao();
                break;

            case 3:
                atv = new AtividadeLazer();
                break;

            case 4:
                atv = new AtividadeSaude();
                break;

            default:
                System.out.println("Opção inválida");
                atv = addAtividade_IO();
                break;
        }

        sc.close();
        return atv;
    }

    


    private static void addDependente(Contribuinte id){
        Scanner sc = new Scanner(System.in);

        System.out.print("NIF dependente: ");
        id.addDependente(Integer.valueOf(sc.nextLine()));
        System.out.println("Dependente adicionado!\n");

        sc.close();
    }


}

