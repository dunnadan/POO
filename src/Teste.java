import java.util.ArrayList;

public class Teste {

	public static ArrayList<Fatura> main(String[] args){

		ArrayList<Fatura> fat_out = new ArrayList<Fatura>();
		fat_out.add(new Fatura("291306098", 501035446, 127453216, "edu", "livro", "edu",  0.3));
		fat_out.add(new Fatura("291306098", 501035446, 127453216, "edu", "jornal", "edu",  0.1));

		DataBase.saveData("/tmp/fat.ser", fat_out);

		ArrayList<Fatura> fat_in = DataBase.loadData("/tmp/fat.ser");

		return fat_in;

	}
}