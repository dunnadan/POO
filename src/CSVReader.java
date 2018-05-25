import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

    public static ArrayList<ArrayList<String>> readFile(String file){

        ArrayList<ArrayList<String>> ret = new ArrayList<ArrayList<String>>();
        
        try{
            FileReader csv_file = new FileReader(file);
            BufferedReader buffer = new BufferedReader(csv_file);
            String line;

            while ((line = buffer.readLine()) != null){
                
                ArrayList<String> list = new ArrayList<>();
                
                for (String field : line.split(";"))
                    list.add(field);

                ret.add(list);
            }

            buffer.close();
        }

        catch(FileNotFoundException e){
            e.printStackTrace();
        }

        catch(IOException i){
            i.printStackTrace();
        }

        return ret;
    }
}
