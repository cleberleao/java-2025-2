import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ordenar {
    public static void main(String[] args) {
        int[] inteiros= {91,53,41,22,77,60,14,32,89};
        for(int i=0; i< inteiros.length - 1; i++){
            for (int j = 0; j < inteiros.length -1 - i; j++){
                if(inteiros[j] > inteiros[j+1]){
                    int temporario = inteiros[j];
                    inteiros[j] = inteiros[j+1];
                    inteiros[j+1]=temporario;
                }
            }
        }
        for (int i=0; i < inteiros.length; i++){
            System.out.printf(" " + inteiros[i]);
        }

        List<Integer> numeros = new ArrayList<>();
        numeros.add(18);
        numeros.add(15);
        numeros.add(80);
        numeros.add(55);
        System.out.println("\n Não Ordenada");
        for(Integer num:numeros){
            System.out.printf(" " + num);
        }
        Collections.sort(numeros);
        System.out.println("\n Ordenada");
        for(Integer num:numeros){
            System.out.printf(" " + num);
        }
    }
}