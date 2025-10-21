import entidade.Aluno;
import entidade.Pessoa;
import entidade.Professor;

public class Main {
    public static void main(String[] args) {
        Pessoa pessoa1 = new Pessoa();
        Pessoa pessoa = new Pessoa("Cleber");
        pessoa.setIdade(45);
        pessoa.exibirDados();
        Pessoa.totalDePessoas++;
        System.out.println("Ano de Nascimento: " + pessoa.calcularAnoNascimento(2025));
        System.out.println("Total de pessoas: " + Pessoa.totalDePessoas);
        System.out.println("País padrão: " + Pessoa.PAIS_PADRAO);

        Pessoa pessoa2 = new Pessoa("José", 44);
        pessoa2.fazerAniversario();
        pessoa2.exibirDados();
        Pessoa.totalDePessoas++;
        boolean bool = pessoa2.temMesmaIdadeQue(pessoa2, pessoa);
        System.out.println(bool);
        System.out.println("Total de pessoas: " + Pessoa.totalDePessoas);
        System.out.println("País padrão: " + Pessoa.PAIS_PADRAO);

        System.out.println(pessoa1.getNome() + ", idade construtor vazio = " + pessoa1.getIdade());

        //Objeto Aluno
        Aluno aluno = new Aluno("Eduardo", 25, "ADS");
        //Objeto Professor
        Professor professor = new Professor("Clayton", 48, "PSC");

        aluno.estudar();

        professor.ensinar();

        Pessoa p1 = new Pessoa();
        Pessoa p2 = new Aluno();
        Pessoa p3 = new Professor();

        p1.apresentar(); // Sou uma pessoa.
        p2.apresentar(); // Sou um aluno.
        p3.apresentar(); // Sou um professor.


    }
}