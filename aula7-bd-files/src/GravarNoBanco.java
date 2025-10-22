import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class GravarNoBanco {
    public static void main(String[] args) {
        // Lista de pessoas
        List<Pessoa> pessoas = new ArrayList<>();
        Pessoa pessoa1 = new Pessoa("Leão", "leao@email.com", "1980-03-14");
        pessoas.add(new Pessoa("Ana", "ana@email.com", "1990-05-10"));
        pessoas.add(new Pessoa("Bruno", "bruno@email.com", "1985-08-22"));
        pessoas.add(pessoa1);

        // Dados do banco alterar para o seu banco
        String url = "jdbc:mysql://cleberleao.com:3306/cleberleao_aula_2025_2?useSSL=false&serverTimezone=UTC";
        String usuario = "cleberleao_cleberleao_aula"; // ou outro usuário
        String senha = "Configs11@";

        String sql = "INSERT INTO pessoas (nome, email, nascimento) VALUES (?, ?, ?)";

        try (Connection con = DriverManager.getConnection(url, usuario, senha);
             PreparedStatement ps = con.prepareStatement(sql)) {

            for (Pessoa p : pessoas) {
                ps.setString(1, p.getNome());
                ps.setString(2, p.getEmail());
                ps.setString(3, p.getNascimento());
                ps.executeUpdate();
            }

            System.out.println("Dados gravados com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
