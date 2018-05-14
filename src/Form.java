import java.util.*;

public class Form implements Screen<List<String>> {

    private final String name;
    private final List<String> fields;
    private final List<String> answers;

    public Form(String name, List<String> fields){
        this.name = name;
        this.fields = fields;
        this.answers = new ArrayList<>();
    }

    @Override
    public void execute(){
        System.out.println("**** " + this.name + " ****");
        Scanner is = new Scanner(System.in);
        for(int i=0; i<this.fields.size(); i++){
            System.out.println(this.fields.get(i));
            this.answers.add(is.nextLine());
        }
        is.close();
    }

    @Override
    public List<String> getResult(){
        return new ArrayList<>(this.answers);
    }
}
