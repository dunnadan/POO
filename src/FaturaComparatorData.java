import java.util.Comparator;

public class FaturaComparatorData implements Comparator<Fatura> {

    /**
     * Compara a data de duas Faturas
     * @param o1 Fatura
     * @param o2 Fatura
     * @return inteiro correspondente à comparação
     */
    public int compare(Fatura o1, Fatura o2) {
        if(o1.getData().isAfter(o2.getData())) return -1;
            else return 1;

    }
}
