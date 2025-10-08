import java.util.LinkedList;
import java.util.Queue;

public class ExemploFila {
    public static void main(String[] args) {
        Queue<String> fila = new LinkedList<>();

        fila.add("Cliente 1");
        fila.add("Cliente 2");
        fila.add("Cliente 3");

        System.out.println("Primeiro da fila: " + fila.peek());

        fila.poll();
        System.out.println("Após atender: " + fila);
    }
}

