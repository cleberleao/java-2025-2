package entidade;

public class Professor extends Pessoa {
    private String disciplina;

    public Professor(){

    }
    public Professor(String nome, int idade, String disciplina) {
        super(nome, idade);
        this.disciplina = disciplina;
    }

    public void ensinar() {
        System.out.println(getNome() + " está ensinando " + disciplina + ".");
    }

    @Override
    public void apresentar() {
        System.out.println("Sou um professor.");
    }


}
