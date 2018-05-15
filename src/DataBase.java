import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class DataBase {
	
	public static void saveData(String filePath, JavaFatura sourceList){

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

	public static <E> ArrayList<E> loadData(String filePath){

		ArrayList<E> sourceList = new ArrayList<E>();

		try {
			FileInputStream fileIn = new FileInputStream(filePath);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			sourceList = (ArrayList) in.readObject();
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
}