import java.util.Comparator;

public class EmpresaComparatorValor implements Comparator<Empresa>{

    public int compare(Empresa o1, Empresa o2) {
        return Double.compare(o1.totalFaturado(o1.getFaturas()),o2.totalFaturado(o2.getFaturas()));
    }
}
