package org.example;

import javax.swing.*;      // Importa componentes gráficos (JFrame, JButton, JTextField)
import java.awt.*;         // Importa classes para layout e cores
import java.awt.event.*;   // Importa classes para eventos (ActionListener)

public class CalcularSimples extends JFrame implements ActionListener {
    private JTextField display; // Campo para mostrar números e resultados
    private double num1 = 0;    // Primeiro número digitado
    private String operador = ""; // Operador (+, -, *, /)
    private boolean limparDisplay = false; // Indica se deve limpar o display após operação

    public CalcularSimples() {
        // Configuração da janela principal
        setTitle("Calculadora Simples"); // Título da janela
        setSize(300, 400);               // Largura e altura
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fecha ao clicar no X
        setLayout(new BorderLayout());   // Layout com regiões (NORTH, CENTER)

        // Display (parte superior)
        display = new JTextField("0");   // Cria campo com valor inicial "0"
        display.setFont(new Font("Arial", Font.BOLD, 24)); // Define fonte grande
        display.setHorizontalAlignment(JTextField.RIGHT);  // Alinha texto à direita
        display.setEditable(false);      // Usuário não pode digitar diretamente
        add(display, BorderLayout.NORTH); // Adiciona display na parte superior

        // Painel com botões
        JPanel painel = new JPanel(new GridLayout(5, 4, 5, 5)); // 5 linhas, 4 colunas

        // Botões da calculadora (incluindo "Limpar")
        String[] botoes = {
                "7", "8", "9", "+",
                "4", "5", "6", "-",
                "1", "2", "3", "*",
                "0", ".", "=", "/",
                "Limpar"// Botão extra para limpar tudo
        };

        // Criar e adicionar botões ao painel
        for (String texto : botoes) {
            JButton btn = new JButton(texto); // Cria botão com texto
            btn.setFont(new Font("Arial", Font.PLAIN, 18)); // Define fonte
            btn.addActionListener(this); // Adiciona evento ao botão
            painel.add(btn); // Adiciona botão ao painel
        }

        add(painel, BorderLayout.CENTER); // Adiciona painel no centro
        setVisible(true); // Torna a janela visível
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand(); // Texto do botão clicado

        // Se for número ou ponto decimal
        if (comando.matches("[0-9]") || comando.equals(".")) {
            if (limparDisplay || display.getText().equals("0")) {
                display.setText(comando); // Substitui conteúdo
                limparDisplay = false;
            } else {
                display.setText(display.getText() + comando); // Adiciona ao texto
            }
        }
        // Se for operador (+, -, *, /)
        else if (comando.equals("+") || comando.equals("-") || comando.equals("*") || comando.equals("/")) {
            num1 = Double.parseDouble(display.getText()); // Guarda primeiro número
            operador = comando; // Guarda operador
            limparDisplay = true; // Próxima entrada limpa display
        }
        // Se for igual (=)
        else if (comando.equals("=")) {
            double num2 = Double.parseDouble(display.getText()); // Segundo número
            double resultado = 0;

            // Calcula conforme operador
            switch (operador) {
                case "+":
                    resultado = num1 + num2;
                    break;
                case "-":
                    resultado = num1 - num2;
                    break;
                case "*":
                    resultado = num1 * num2;
                    break;
                case "/":
                    if (num2 != 0) {
                        resultado = num1 / num2;
                    }
                    break;
            }
            display.setText(String.valueOf(resultado)); // Mostra resultado
            limparDisplay = true;
        }
        // Se for "Limpar"
        else if (comando.equals("Limpar")) {
            display.setText("0"); // Reseta display
            num1 = 0;             // Reseta número
            operador = "";        // Reseta operador
        }
    }
    public static void main(String[] args) {
        new CalcularSimples();
    }
}