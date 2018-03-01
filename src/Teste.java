import java.io.*;
import java.util.ArrayList;

public class Teste {
	
	public static void serialize(){
		
		int[] dep = {123, 321, 555};
		String[] atv = {"edu", "lazer"};

		ArrayList<Contribuinte> cont_out = new ArrayList<Contribuinte>();
		cont_out.add(new Contribuinte(291306098, "leo", "leo@gmail", "irmas missionarias", "123456", 0.3, dep, atv));
		cont_out.add(new Contribuinte(501035446, "bruna", "bruna@gmail", "coimbra", "0334563", 0.6, dep, atv));
		cont_out.add(new Contribuinte(127453216, "mae", "mae@gmail", "poços", "0001263", 0.6, dep, atv));

		try {
			FileOutputStream fileOut = new FileOutputStream("/tmp/cont.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(cont_out);
			out.close();
			fileOut.close();
		}
		
		catch (IOException i){
			i.printStackTrace();
		}
	}

	public static void deserialize(){
		ArrayList<Contribuinte> cont_in = new ArrayList<Contribuinte>();

		try {
			FileInputStream fileIn = new FileInputStream("/tmp/cont.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			cont_in = (ArrayList<Contribuinte>) in.readObject();
			in.close();
			fileIn.close();
		}
		
		catch(IOException i){
			i.printStackTrace();
			return;
		}

		catch(ClassNotFoundException c){
			c.printStackTrace();
			return;
		}

		System.out.println("Deserialized object");

		for (Contribuinte cont : cont_in){

			System.out.println("NIF: " + cont.getNIF());
			System.out.println("Nome: " + cont.getNome());
			System.out.println("Morada: " + cont.getMorada());
			System.out.println("Dependentes: " + cont.getDependentes().toString());
			System.out.println("Atividades: " + cont.getAtividades().toString());
			System.out.println();
		}
	}
}