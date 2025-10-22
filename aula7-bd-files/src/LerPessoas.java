import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LerPessoas {

    public static void main(String[] args) {
        Path arquivo = Path.of("pessoas.txt"); // Ex.: Ana;ana@email.com;1990-05-10
        List<Pessoa> pessoas = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(arquivo)) {
            String linha;
            while ((linha = br.readLine()) != null) {
                linha = linha.trim();
                if (linha.isEmpty()) continue; // ignora linhas vazias

                String[] partes = linha.split(";"); // separa pelos ";"
                if (partes.length == 3) {
                    String nome = partes[0];
                    String email = partes[1];
                    String nascimento = partes[2]; // formato AAAA-MM-DD
                    pessoas.add(new Pessoa(nome, email, nascimento));
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
        }

        // Exibe os dados lidos
        for (Pessoa p : pessoas) {
            System.out.println(p);
        }
    }
}
