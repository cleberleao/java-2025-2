package entidade;

public class Aluno extends Pessoa {
    private String curso;

    public Aluno(){

    }

    public Aluno(String nome, int idade, String curso) {
        super(nome, idade); // Chama o construtor da superclasse Pessoa
        this.curso = curso;
    }

    public void estudar() {
        System.out.println(getNome() + " está estudando " + curso + ".");
    }

    @Override
    public void apresentar() {
        System.out.println("Sou um aluno.");
    }

}
