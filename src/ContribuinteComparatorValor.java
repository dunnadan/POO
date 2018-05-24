import java.util.Comparator;

public class ContribuinteComparatorValor implements Comparator<Contribuinte> {

    /**
     * Compara o total gasto entre dois contribuintes
     * @param o1 Contribuinte
     * @param o2 Contribuinte
     * @return Valor dderivado da comparação
     */
    @Override
    public int compare(Contribuinte o1, Contribuinte o2) {
        return Double.compare(o1.totalGasto(),o2.totalGasto());
    }
}
