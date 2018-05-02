import java.util.Comparator;

public class FaturaComparatorData implements Comparator<Fatura> {
    public int compare(Fatura o1, Fatura o2) {
        if(o1.getData().isAfter(o2.getData())) return -1;
            else return 1;

    }
}
