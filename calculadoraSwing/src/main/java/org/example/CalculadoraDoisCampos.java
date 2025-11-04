package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculadoraDoisCampos extends JFrame implements ActionListener {
    private JTextField campo1, campo2, resultado;
    private JButton somar, subtrair, multiplicar, dividir;
    private JButton[] botoesNumericos;
    private JTextField campoAtivo; // Para saber qual campo está com foco

    public CalculadoraDoisCampos() {
        setTitle("Calculadora Dois Campos");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 4, 5, 5));

        // Campos
        campo1 = new JTextField();
        campo2 = new JTextField();
        resultado = new JTextField();
        resultado.setEditable(false);

        // Detecta qual campo está ativo
        campo1.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                campoAtivo = campo1;
            }
        });
        campo2.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                campoAtivo = campo2;
            }
        });

        add(new JLabel("Número 1:"));
        add(campo1);
        add(new JLabel("Número 2:"));
        add(campo2);

        // Botões numéricos
        botoesNumericos = new JButton[10];
        for (int i = 9; i >= 7; i--) {
            botoesNumericos[i] = new JButton(String.valueOf(i));
            botoesNumericos[i].addActionListener(this);
            add(botoesNumericos[i]);
        }

        // Botões de operação
        somar = new JButton("+");
        for (int i = 6; i >= 4; i--) {
            botoesNumericos[i] = new JButton(String.valueOf(i));
            botoesNumericos[i].addActionListener(this);
            add(botoesNumericos[i]);
        }
        subtrair = new JButton("-");
        for (int i = 3; i >= 1; i--) {
            botoesNumericos[i] = new JButton(String.valueOf(i));
            botoesNumericos[i].addActionListener(this);
            add(botoesNumericos[i]);
        }
        multiplicar = new JButton("*");
        dividir = new JButton("/");

        somar.addActionListener(this);
        subtrair.addActionListener(this);
        multiplicar.addActionListener(this);
        dividir.addActionListener(this);

        add(somar);
        add(subtrair);
        add(multiplicar);
        add(dividir);

        add(new JLabel("Resultado:"));
        add(resultado);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object fonte = e.getSource();

        // Se clicou em número, adiciona ao campo ativo
        for (int i = 0; i <= 9; i++) {
            if (fonte == botoesNumericos[i]) {
                if (campoAtivo != null) {
                    campoAtivo.setText(campoAtivo.getText() + i);
                }
                return;
            }
        }

        // Operações
        try {
            double num1 = Double.parseDouble(campo1.getText());
            double num2 = Double.parseDouble(campo2.getText());
            double res = 0;

            if (fonte == somar) res = num1 + num2;
            else if (fonte == subtrair) res = num1 - num2;
            else if (fonte == multiplicar) res = num1 * num2;
            else if (fonte == dividir) {
                if (num2 == 0) {
                    resultado.setText("Erro: divisão por zero");
                    return;
                }
                res = num1 / num2;
            }

            resultado.setText(String.valueOf(res));
        } catch (NumberFormatException ex) {
            resultado.setText("Entrada inválida");
        }
    }

    public static void main(String[] args) {
        new CalculadoraDoisCampos();
    }
}
