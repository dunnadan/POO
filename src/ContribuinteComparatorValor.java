import java.util.Comparator;

public class ContribuinteComparatorValor implements Comparator<Contribuinte> {

    @Override
    public int compare(Contribuinte o1, Contribuinte o2) {
        return Double.compare(o1.totalGasto(),o2.totalGasto());
    }
}
