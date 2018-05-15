import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class JavaFatura implements Serializable {

    private Map<Integer, IdentidadeFiscal> userMap;
    private IdentidadeFiscal user;

    public JavaFatura() {
        this.userMap = new HashMap<>();

    }

    public void insert_IDFiscal(IdentidadeFiscal id) {
        this.userMap.put(id.getNIF(), id.clone());
    }

    public boolean login(Integer nif, String pass) {

        if (this.userMap.isEmpty()) return false;
        this.user = this.userMap.get(nif).clone();
        return this.userMap.get(nif).getPassword().equals(pass);
    }

    public void makeIDFiscal(IdentidadeFiscal id) {
        this.userMap.put(id.getNIF(), id);
    }

    public IdentidadeFiscal getIDFiscal(Integer nif) {
        return this.userMap.get(nif);
    }

    public void saveState() throws IOException {
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("state.txt"));
        os.writeObject(this);
        os.flush();
        os.close();
    }

    public JavaFatura loadState() throws IOException, ClassNotFoundException {

        JavaFatura javaFatura = new JavaFatura();
        ObjectInputStream is = new ObjectInputStream(new FileInputStream("state.txt"));
        javaFatura = (JavaFatura) is.readObject();
        is.close();

        return javaFatura;
    }
}

