import java.util.Comparator;

public class FaturaComparatorValor implements Comparator<Fatura> {
    /**
     * Compara o valor de duas faturas
     * @param o1 Fatura
     * @param o2 Fatura
     * @return inteiro correspondente à comparação
     */
    @Override
    public int compare(Fatura o1, Fatura o2) {
        return -Double.compare(o1.getValor(),o2.getValor());
    }
}
