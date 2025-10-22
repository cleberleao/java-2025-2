import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GravarObjetosEmArquivo {
    public static void main(String[] args) {
        List<Pessoa> pessoas = new ArrayList<>();
        Pessoa pessoa1 = new Pessoa("Leão", "leao@email.com", "1980-3-14");
        pessoas.add(new Pessoa("Ana", "ana@email.com", "1990-5-20"));
        pessoas.add(new Pessoa("Bruno", "bruno@email.com","1985-8-15"));
        pessoas.add(pessoa1);

        String caminhoArquivo = "pessoas.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo))) {
            for (Pessoa p : pessoas) {
                writer.write(p.toString());
                writer.newLine();
            }
            System.out.println("Arquivo gerado com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
}

