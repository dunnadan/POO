import java.util.Comparator;

public class FaturaComparatorValor implements Comparator<Fatura> {
    @Override
    public int compare(Fatura o1, Fatura o2) {
        return -Double.compare(o1.getValor(),o2.getValor());
    }
}
