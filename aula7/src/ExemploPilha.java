import java.util.Stack;

public class ExemploPilha {
    public static void main(String[] args) {
        Stack<String> pilha = new Stack<>();

        pilha.push("Prato 1");
        pilha.push("Prato 2");
        pilha.push("Prato 3");
        pilha.push("Prato 4");
        pilha.push("Prato 5");

        System.out.println("Topo da pilha: " + pilha.peek());

        pilha.pop();
        System.out.println("Após remover: " + pilha);
    }
}