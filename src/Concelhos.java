import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class Concelhos {
    /**
     * Lista que contém os concelhos do interior
     */
    private static final List<String> concelhos = new ArrayList<>();
    static {
        concelhos.add("Vila Real");
        concelhos.add("Bragança");
        concelhos.add("Vila Pouca de Aguiar");
        concelhos.add("Alijó");
        concelhos.add("Murça");
        concelhos.add("Boticas");
        concelhos.add("Valpaços");
        concelhos.add("Mirandela");
        concelhos.add("Sabrosa");
        concelhos.add("Chaves");
        concelhos.add("Peso da Régua");
    }

    /**
     * Verifica se o concelho é do interior
     * @param c concelho
     * @return boolean
     */
    public static boolean contemConcelho(String c){
        return concelhos.contains(c);
    }


}
