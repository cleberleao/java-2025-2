package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculadoraWindows extends JFrame implements ActionListener {
    private JTextField display;
    private String operador = "";
    private double num1 = 0;
    private boolean limparDisplay = false;

    public CalculadoraWindows() {
        setTitle("Calculadora");
        setSize(320, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Display
        display = new JTextField("0");
        display.setFont(new Font("Arial", Font.BOLD, 28));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

        // Painel de botões
        JPanel painel = new JPanel(new GridLayout(6, 4, 5, 5));

        String[] botoes = {
                "%", "CE", "C", "⌫",
                "1/x", "x²", "√", "÷",
                "7", "8", "9", "×",
                "4", "5", "6", "-",
                "1", "2", "3", "+",
                "+/-", "0", ".", "="
        };

        for (String texto : botoes) {
            JButton btn = new JButton(texto);
            btn.setFont(new Font("Arial", Font.PLAIN, 18));
            btn.addActionListener(this);
            painel.add(btn);
        }

        add(painel, BorderLayout.CENTER);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        if (comando.matches("[0-9]") || comando.equals(".")) {
            if (limparDisplay || display.getText().equals("0")) {
                display.setText(comando);
                limparDisplay = false;
            } else {
                display.setText(display.getText() + comando);
            }
        } else if (comando.equals("+") || comando.equals("-") || comando.equals("×") || comando.equals("÷")) {
            num1 = Double.parseDouble(display.getText());
            operador = comando;
            limparDisplay = true;
        } else if (comando.equals("=")) {
            double num2 = Double.parseDouble(display.getText());
            double resultado = 0;
            switch (operador) {
                case "+": resultado = num1 + num2; break;
                case "-": resultado = num1 - num2; break;
                case "×": resultado = num1 * num2; break;
                case "÷": resultado = num2 != 0 ? num1 / num2 : Double.NaN; break;
            }
            display.setText(formatar(resultado));
            limparDisplay = true;
        } else if (comando.equals("C")) {
            display.setText("0");
            num1 = 0;
            operador = "";
        } else if (comando.equals("CE")) {
            display.setText("0");
        } else if (comando.equals("⌫")) {
            String texto = display.getText();
            if (texto.length() > 1) {
                display.setText(texto.substring(0, texto.length() - 1));
            } else {
                display.setText("0");
            }
        } else if (comando.equals("%")) {
            double valor = Double.parseDouble(display.getText());
            display.setText(formatar(valor / 100));
        } else if (comando.equals("√")) {
            double valor = Double.parseDouble(display.getText());
            display.setText(formatar(Math.sqrt(valor)));
        } else if (comando.equals("x²")) {
            double valor = Double.parseDouble(display.getText());
            display.setText(formatar(valor * valor));
        } else if (comando.equals("1/x")) {
            double valor = Double.parseDouble(display.getText());
            if (valor != 0) {
                display.setText(formatar(1 / valor));
            } else {
                display.setText("Erro");
            }
        } else if (comando.equals("+/-")) {
            double valor = Double.parseDouble(display.getText());
            display.setText(formatar(-valor));
        }
    }

    private String formatar(double valor) {
        if (valor == (long) valor) {
            return String.format("%d", (long) valor);
        } else {
            return String.format("%s", valor);
        }
    }

    public static void main(String[] args) {
        new CalculadoraWindows();
    }
}