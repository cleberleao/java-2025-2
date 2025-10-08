import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LerDadosDoBanco {
    public static void main(String[] args) {
        String url = "jdbc:mysql://cleberleao.com:3306/cleberleao_aula_2025_2?useSSL=false&serverTimezone=UTC";
        String usuario = "cleberleao_cleberleao_aula"; // ou outro usuário
        String senha = "Configs11@";

        String sql = "SELECT id, nome, email, nascimento FROM pessoas";

        try (Connection con = DriverManager.getConnection(url, usuario, senha);
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("=== Lista de Pessoas ===");
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String nascimento = rs.getString("nascimento"); // como String para simplificar

                System.out.println(id + " - " + nome + " - " + email + " - " + nascimento);
            }

        } catch (Exception e) {
            System.out.println("Erro ao ler dados: " + e.getMessage());
        }
    }
}

