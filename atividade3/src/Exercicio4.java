import java.util.Scanner;
//4) Soma dos elementos de uma matriz 3x3,
// faça um programa que leia uma matriz 3x3 de
// números inteiros e calcule a soma de todos os elementos.
public class Exercicio4 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int[][] numeros = new int[3][3];
        int soma = 0;

        for(int i=0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                System.out.printf("Digite o valor [" + i + "][" + j + "]: ");
                numeros[i][j] = ler.nextInt();
                soma += numeros[i][j];
            }
        }
        System.out.printf("Valor Total é: " + soma);
    }
}
