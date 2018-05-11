


public abstract class Atividade {


    private String nome;
    private Boolean deduct; //diz se deduz ou não valor fiscal



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
