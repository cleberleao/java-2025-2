import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {
//1) Soma dos elementos de um array, crie um programa
// que leia 5 números inteiros, armazene em um array e exiba a
// soma de todos os elementos.
        Scanner ler = new Scanner(System.in);
        int[] numeros = new int[5];
        int soma = 0;

        for(int i=0; i < numeros.length; i++){
            System.out.printf("Digite um numero: ");
            numeros[i]= ler.nextInt();
            soma += numeros[i];
        }

        System.out.println("A soma dos valores ");
        System.out.println("É = " + soma);
    }
}