import java.util.Scanner;
import java.util.stream.IntStream;

//5) Diagonal principal de uma matriz 4x4, faça
// um programa que Leia uma matriz 4x4 e
// exiba os elementos da diagonal principal.
public class Exercicio5 {
    private static final int TAMANHO = 4;
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int[][] numeros = new int[TAMANHO][TAMANHO];


        for(int i=0; i < TAMANHO; i++){
            for (int j = 0; j < TAMANHO; j++){
                System.out.printf("Digite o valor [" + i + "][" + j + "]: ");
                numeros[i][j] = ler.nextInt();
            }
        }
        IntStream.range(0, TAMANHO)
                .map(i -> numeros[i][i])
                .forEach(value -> System.out.printf( value + " "));
    }
}
