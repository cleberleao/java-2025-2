import java.util.Scanner;

public class LerNomeSexoPessoas {
    public static void main(String[] args) {
//1. Escrever um programa que leia o nome e o
// sexo de 56 pessoas e informe o nome e se ela
// é homem ou mulher. No final informe total
// de homens e de mulheres.
        Scanner ler = new Scanner(System.in);
        String nome;
        String sexo;
        int i = 0;
        int contadorM = 0;
        int contadorF = 0;
        System.out.println("Programa verifica sexo M ou F");
        do{
            System.out.printf("Digite um nome: ");
            nome = ler.nextLine();
            System.out.printf("Digite o sexo M ou F: ");
            sexo = ler.nextLine().toLowerCase();
            if (sexo.equals("f")){
                System.out.println("Mulher seu nome é: " + nome);
                contadorF++;
            } else if (sexo.equals("m")){
                System.out.println("Homem seu nome é: " + nome);
                contadorM++;
            }else{
                System.out.println("Digitou sexo diferente de M ou F");
            }
            i++;
        } while (i!=3);

        System.out.println("Quantidade de Homens é: " + contadorM);
        System.out.println("Quantidade de mulheres é: " + contadorF);

    }
}