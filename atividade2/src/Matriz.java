import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Matriz {
    public static void main(String[] args) {
        System.out.println("Trabalhando com Matriz");
        int[][] numero = new int[2][2];
        Scanner ler = new Scanner(System.in);
        for(int i=0; i < numero.length; i++){
           for(int j=0; j < numero[i].length; j++){
               System.out.printf("Digite um numero: ");
               numero[i][j]= parseInt(ler.nextLine());
           }
        }
    }
}
