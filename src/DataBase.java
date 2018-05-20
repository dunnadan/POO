import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;

public class DataBase {
	
	public static void saveData(Map<Integer,IdentidadeFiscal> source){

		try {
			FileOutputStream fileOut = new FileOutputStream("database.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(source);
			out.close();
			fileOut.close();
		}
		
		catch (IOException i){
			i.printStackTrace();
		}
	}

	public static Map<Integer,IdentidadeFiscal> loadData(){

		Map<Integer,IdentidadeFiscal> source = new HashMap<Integer,IdentidadeFiscal>();

		try {
			FileInputStream fileIn = new FileInputStream("database.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			source = (Map<Integer,IdentidadeFiscal>) in.readObject();
			in.close();
			fileIn.close();
		}	
		
		catch(IOException i){
			i.printStackTrace();
		}

		catch(ClassNotFoundException c){
			c.printStackTrace();
		}

		return source;
	}
}