


public abstract class Atividade {


    private String nome;
    private Boolean deduct; //diz se deduz ou não valor fiscal

    public Atividade(String nome, Boolean deduct){
        this.nome = nome;
        this.deduct = deduct;
    }

    public Atividade(){
        this.nome = "";
        this.deduct = false;
    }

    public  Atividade(Atividade object){
        this.nome = object.getNome();
        this.deduct = object.getDeduct();
    }

    //methods

    public String getNome(){
        return this.nome;
    }


    public void setNome(String name){
        this.nome = name;   //Correto???
    }


    public Boolean getDeduct(){   //Clone boolean???
        return this.deduct;
    }




    //Nao ha setter para o deduct, porque isso e uma caracteristica de cada atividade
    //que nao pode ser alterada.
}
