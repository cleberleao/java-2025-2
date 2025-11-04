package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculadoraSimples extends JFrame implements ActionListener {
    JTextField campo1, campo2, resultado;
    JButton somar, subtrair, multiplicar, dividir, numero1;

    public CalculadoraSimples() {
        setTitle("Calculadora Simples");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2));

        // Campos de entrada
        add(new JLabel("Número 1:"));
        campo1 = new JTextField();
        add(campo1);

        add(new JLabel("Número 2:"));
        campo2 = new JTextField();
        add(campo2);

        // Botões
        somar = new JButton("+");
        subtrair = new JButton("-");
        multiplicar = new JButton("*");
        dividir = new JButton("/");
        numero1 = new JButton("1");

        somar.addActionListener(this);
        subtrair.addActionListener(this);
        multiplicar.addActionListener(this);
        dividir.addActionListener(this);
        numero1.addActionListener(this);

        add(somar);
        add(subtrair);
        add(multiplicar);
        add(dividir);
        add(numero1);

        // Resultado
        add(new JLabel("Resultado:"));
        resultado = new JTextField();
        resultado.setEditable(false);
        add(resultado);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            double num1 = Double.parseDouble(campo1.getText());
            double num2 = Double.parseDouble(campo2.getText());
            double res = 0;

            if (e.getSource() == somar) {
                res = num1 + num2;
            } else if (e.getSource() == subtrair) {
                res = num1 - num2;
            } else if (e.getSource() == multiplicar) {
                res = num1 * num2;
            } else if (e.getSource() == dividir) {
                if (num2 == 0) {
                    resultado.setText("Erro: divisão por zero");
                    return;
                }
                res = num1 / num2;
            }

            resultado.setText(String.valueOf(res));
        } catch (NumberFormatException ex) {
            resultado.setText("Erro: entrada inválida");
        }
    }

    public static void main(String[] args) {
        new CalculadoraSimples();
    }
}