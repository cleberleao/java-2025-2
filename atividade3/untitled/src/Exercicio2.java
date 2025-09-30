import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;

public class Exercicio2 {
    //2) Maior e menor elemento, crie
    // um programa que leia 10 números
    // inteiros e mostre qual é o maior e
    // o menor valor.
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int[] numeros = new int[10];

        for(int i=0; i < numeros.length; i++){
            System.out.printf("Digite um numero: ");
            numeros[i]= ler.nextInt();
        }

//        OptionalInt maior = Arrays.stream(numeros).max();
//        OptionalInt menor = Arrays.stream(numeros).min();

        System.out.println("O numero maior foi: " + Arrays.stream(numeros).max().getAsInt());
        System.out.println("O numero menor foi: " + Arrays.stream(numeros).min().getAsInt());


    }
}
