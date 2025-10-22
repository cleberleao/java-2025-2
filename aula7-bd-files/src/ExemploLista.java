import java.util.*;

public class ExemploLista {
    public static void main(String[] args) {
        ArrayList<String> lista = new ArrayList<>();

        lista.add("Item A");
        lista.add("Item B");
        lista.add("Item C");

        System.out.println("Lista completa: " + lista);

        lista.remove("Item B");
        System.out.println("Após remover: " + lista);

        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("Cleber");
        linkedList.add("Leão");

        linkedList.addFirst("Primeiro");
        linkedList.addLast("Ultimo");

        System.out.println("linked Lista completa: " + linkedList);

        //elimina dados repetidos, não permite inserir dados iguais
        Set<String> list = new HashSet<>();
        list.add("Cleber");
        list.add("Cleber");

        System.out.println("Set List completa: " + list);

    }
}