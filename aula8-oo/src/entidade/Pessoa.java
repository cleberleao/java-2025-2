package entidade;

public class Pessoa {
    private String nome;
    private int idade;
    // Atributo de classe: compartilha o mesmo valor entre todas as pessoas
    public static int totalDePessoas = 0;
    // Constante de classe (por convenção, UPPER_CASE)
    public static final String PAIS_PADRAO = "Brasil";

    // Construtor vazio (sem parâmetros)
    public Pessoa() {
        // valores iniciais simples
        nome = "Sem nome";
        idade = 0;
    }
    // Construtor com nome
    public Pessoa(String nome) {
        this.nome = nome;
        this.idade = 0;
    }
    // Construtor com nome e idade
    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void exibirDados(){
        System.out.println("Nome é: " + nome);
        System.out.println("Sua idade: " + idade);
    }
    public void fazerAniversario() {
        idade = idade + 1; // ou idade++;
    }
    public int calcularAnoNascimento(int anoAtual) {
        return anoAtual - idade;
    }
    public boolean temMesmaIdadeQue(Pessoa outra, Pessoa primeira) {
        return primeira.idade == outra.idade;
    }
    public void apresentar() {
        System.out.println("Sou uma pessoa.");
    }


}
