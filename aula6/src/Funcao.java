public class Funcao {
    public static int soma(int x, int y){
        return x + y;
    }
    public static void imprimir(String valor) {
        System.out.println(valor);
    }
    public static void meuNome(){
        System.out.println("Cleber");
    }

    public static void main(String[] args) {
        int somatorio = soma(102, 67);
        imprimir("A soma é: " + somatorio);
        imprimir("Qualquer coisa ");
        meuNome();
    }

}
