public class ExistentUserException extends Exception{

    private int nif;

    public ExistentUserException(){
        super();
    }

    public ExistentUserException(int nif){
        super();
        this.nif = nif;
    }

    public int getNIF(){
        return this.nif;
    }

}
