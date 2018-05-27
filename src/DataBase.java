import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;

public class DataBase {

	/**
	 * Salva a base da dados da aplicação
	 * @param source HashMap (base de dados) a ser salvo
	 */
	
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

	/**
	 * Faz load da base de dados
	 * @return Base de dados
	 */
	public static Map<Integer,IdentidadeFiscal> loadData(){

		Map<Integer,IdentidadeFiscal> source = new HashMap<>();

		try {
			FileInputStream fileIn = new FileInputStream("database.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			source = (HashMap<Integer,IdentidadeFiscal>) in.readObject();
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