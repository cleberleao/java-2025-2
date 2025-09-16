import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class ServicoMilitar {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        String nome;
        String sexo;
        String saude;
        int idade;
        int qtde = 0;
        int contadorApto = 0;
        int contadorInapto = 0;
        System.out.println("Programa verifica Apto ao Exercíto");
        System.out.printf("Digite a quantidade de inserções: ");
        qtde = parseInt(ler.nextLine());
        while (qtde!=0){
            System.out.printf("Digite um nome: ");
            nome = ler.nextLine();
            System.out.printf("Digite o sexo M ou F: ");
            sexo = ler.nextLine().toLowerCase();
            System.out.printf("Digite a idade: ");
            idade = parseInt(ler.nextLine());
            System.out.printf("Digite condição de saúde : ");
            saude = ler.nextLine();
            if (sexo.equals("f")){
                contadorInapto++;
            } else if (sexo.equals("m") && idade<18){
                contadorInapto++;
            } else if (sexo.equals("m") && idade>=18){
                contadorApto++;
            } else{
                System.out.println("Digitou dados inválidos");
            }
            qtde--;
        }
        System.out.println("Quantidade de pessoas Aptas ao serviço Militar Obrigatório: " + contadorApto);
        System.out.println("Quantidade de pessoas inaptas ao serviço obrigatório: " + contadorInapto);
    }
}
