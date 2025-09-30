import java.util.Scanner;

public class Exercicio3 {
    //3) Inverter um array, faça um programa leia
    // 6 números inteiros e exiba-os na ordem inversa.
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int[] numeros = new int[6];

        for(int i=0; i < numeros.length; i++){
            System.out.printf("Digite um numero: ");
            numeros[i]= ler.nextInt();
        }
        System.out.printf("Ordem de inclusão ");
        for(int i=0; i < numeros.length; i++){
            System.out.printf(" " + numeros[i] );
        }
        System.out.printf("\n Ordem Inversa");
        for (int i = numeros.length -1; i >= 0; i--){
            System.out.printf(" " + numeros[i] );
        }
    }
}
