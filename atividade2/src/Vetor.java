import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Vetor {
    public static void main(String[] args) {
        System.out.println("Trabalhando com Vetor");
        String[] nomes = new String[2];
        int[] idade = new int[2];
        char[] sexo = new char[2];
        Scanner ler = new Scanner(System.in);

        for(int i=0; i!=2; i++){
            System.out.printf("Digite o nome: ");
            nomes[i] = ler.nextLine();
            System.out.printf("Digite a idade: ");
            idade[i]= parseInt(ler.nextLine());
            System.out.printf("Digite o sexo M ou F: ");
            sexo[i] = ler.nextLine().charAt(0);
        }
        for (int i=0; i!=nomes.length; i++){
            System.out.println(nomes[i]);
        }
        for (int i=0; i!=sexo.length; i++){
            System.out.println(sexo[i]);
        }
        for (int i=0; i!=idade.length; i++){
            System.out.println(idade[i]);
        }
    }
}
