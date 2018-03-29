import java.io.*;
import java.util.ArrayList;

public class DataBase<T> {
	
	public static <T> void saveData(String filePath, ArrayList<T> sourceList){

		try {
			FileOutputStream fileOut = new FileOutputStream(filePath);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(sourceList);
			out.close();
			fileOut.close();
		}
		
		catch (IOException i){
			i.printStackTrace();
		}
	}

	public static <T> ArrayList<T> loadData(String filePath){

		ArrayList<T> sourceList = new ArrayList<T>();

		try {
			FileInputStream fileIn = new FileInputStream(filePath);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			sourceList = (ArrayList<T>) in.readObject();
			in.close();
			fileIn.close();
		}	
		
		catch(IOException i){
			i.printStackTrace();
		}

		catch(ClassNotFoundException c){
			c.printStackTrace();
		}

		return sourceList;
	}

	public static void printObject(ArrayList<Contribuinte> source_list){



		for (Contribuinte obj : source_list){

			System.out.println("NIF: " + obj.getNIF());
			System.out.println("Nome: " + obj.getNome());
			System.out.println("Morada: " + obj.getMorada());
			System.out.println("Dependentes: " + obj.getDependentes().toString());
			System.out.println("Atividades: " + obj.getAtividades().toString());
			System.out.println();
		}
	}

	public static ArrayList<Fatura> main(String[] args){

		ArrayList<Fatura> x = loadData("/tmp/fat.ser");

		return x;

	}

}