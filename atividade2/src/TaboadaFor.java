import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class TaboadaFor {
    public static void main(String[] args) {
        int n;
        String o;
        int t;
        Scanner ler = new Scanner(System.in);
        System.out.println("Programa Taboada");
        System.out.printf("Digite o numero da taboada: ");
        n = parseInt(ler.nextLine());
        System.out.printf("Digite a operação + - * / ");
        o = ler.nextLine();
        System.out.printf("Digite o fim da taboada: ");
        t = parseInt(ler.nextLine()) + 1;
        float resultado = 0e5f;
        for (int i=1;i!=t;i++){
            if(o.equals("+")){
                resultado = i + n;
            } else if(o.equals("-")){
                resultado = i - n;
            } else if(o.equals("*")){
                resultado = i * n;
            } else if(o.equals("/")){
                resultado = (float) i / n;
            } else {
                System.out.println("Operador Inválido");
            }
            System.out.println("Tabodada do "+ i + o + n + " = " + resultado);
        }
    }

}
