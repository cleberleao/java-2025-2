import java.time.LocalDate;

class Pessoa {
    private String nome;
    private String email;
    private String nascimento;

    public Pessoa(String nome, String email, String nascimento) {
        this.nome = nome;
        this.email = email;
        this.nascimento = nascimento;
    }

    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public String getNascimento() { return nascimento; }

    @Override
    public String toString() {
        return nome + ";" + email + ";" + nascimento;
    }
}