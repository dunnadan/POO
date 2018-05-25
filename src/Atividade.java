public abstract class Atividade {

    /**
     * Nome da atividade
     */
    private String nome;


    //CONSTRUCTORS

    /**
     * Contrutor Atividade
     * @param nome nome da atividade
     */
    public Atividade(String nome){
        this.nome = nome;
    }

    /**
     * Construtor Vazio de Atividade
     */
    public Atividade(){
        this.nome = "";
    }

    /**
     * Contrutor por Objeto
     * @param object Atividade
     */
    public  Atividade(Atividade object){
        this.nome = object.getNome();
    }



    //METHODS

    /**
     * Retorna o nome da Atividade
     * @return nome da atividade
     */
    public String getNome(){
        return this.nome;
    }

    /**
     *
     * @param name
     */
    public void setNome(String name) {
        this.nome = name;
    }

    /**
     * {@inheritDoc}
     * @return
     */
    public abstract Atividade clone();


    }
