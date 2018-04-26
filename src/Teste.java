import java.io.*;
import java.util.ArrayList;

public class Teste {
	
	public static void serialize(){

		ArrayList<Fatura> fat_out = new ArrayList<Fatura>();
		fat_out.add(new Fatura("291306098", 501035446, 127453216, "edu", "livro", "edu",  0.3));

		try {
			FileOutputStream fileOut = new FileOutputStream("/tmp/fat.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(fat_out);
			out.close();
			fileOut.close();
		}
		
		catch (IOException i){
			i.printStackTrace();
		}
	}

	public static ArrayList<Fatura> deserialize(){
		ArrayList<Fatura> fat_in = new ArrayList<Fatura>();

		try {
			FileInputStream fileIn = new FileInputStream("/tmp/fat.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			fat_in = (ArrayList<Fatura>) in.readObject();
			in.close();
			fileIn.close();
		}
		
		catch(IOException i){
			i.printStackTrace();
		}

		catch(ClassNotFoundException c){
			c.printStackTrace();
		}

		System.out.println("Deserialized object");

		for (Fatura fat : fat_in){

			System.out.println("Numero: " + fat.getNumero());
			System.out.println("NIF Emitente: " + fat.getNIFEmitente());
			System.out.println("NIF Cliente: " + fat.getNIFCliente());
			System.out.println("Descrição: " + fat.getDescricao());
			System.out.println();
		}

		return fat_in;
	}

	public static ArrayList<Fatura> main(String[] args){

		ArrayList<Fatura> fat_out = new ArrayList<Fatura>();
		fat_out.add(new Fatura("291306098", 501035446, 127453216, "edu", "livro", "edu",  0.3));

		DataBase<Fatura> db = new DataBase<Fatura>();

		db.saveData("/tmp/fat.ser", fat_out);

		ArrayList<Fatura> fat_in = db.loadData("/tmp/fat1.ser");

		return fat_in;

	}

	//ArrayList<Fatura> x = DataBase.loadData<Fatura>("/tmp/fat.ser");
	//x<Fatura> = DataBase.loadData<Fatura>("/tmp/fat.ser");
}