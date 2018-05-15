


public abstract class Atividade {

    private String nome;


    //CONSTRUCTORS

    public Atividade(String nome){
        this.nome = nome;
    }

    public Atividade(){
        this.nome = "";
    }

    public  Atividade(Atividade object){
        this.nome = object.getNome();
    }



    //METHODS

    public String getNome(){
        return this.nome;
    }

    public void setNome(String name){
        this.nome = name;   //Correto???
    }

    public abstract double deduct(Fatura f); //sera especificado em cada uma das subclasses


    //Nao ha setter para o deduct, porque isso e uma caracteristica de cada atividade
    //que nao pode ser alterada.
}
