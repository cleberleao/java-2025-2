package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculadoraDoisCamposLayout extends JFrame implements ActionListener {
    private JTextField campo1, campo2, resultado;
    private JTextField campoAtivo; // Para saber qual campo está com foco
    private JButton[] botoesNumericos;
    private JButton somar, subtrair, multiplicar, dividir;

    public CalculadoraDoisCamposLayout() {
        setTitle("Calculadora Dois Campos");
        setSize(350, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Painel superior com os dois campos
        JPanel painelCampos = new JPanel(new GridLayout(3, 2, 5, 5));
        painelCampos.add(new JLabel("Número 1:"));
        campo1 = new JTextField();
        painelCampos.add(campo1);
        painelCampos.add(new JLabel("Número 2:"));
        campo2 = new JTextField();
        painelCampos.add(campo2);
        painelCampos.add(new JLabel("Resultado:"));
        resultado = new JTextField();
        resultado.setEditable(false);
        painelCampos.add(resultado);
        add(painelCampos, BorderLayout.NORTH);

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

        // Painel central para números (3 colunas)
        JPanel painelNumeros = new JPanel(new GridLayout(4, 3, 5, 5));
        String[] numeros = {"9", "8", "7", "6", "5", "4", "3", "2", "1", "0", ".", "C"};
        botoesNumericos = new JButton[numeros.length];
        for (int i = 0; i < numeros.length; i++) {
            botoesNumericos[i] = new JButton(numeros[i]);
            botoesNumericos[i].addActionListener(this);
            painelNumeros.add(botoesNumericos[i]);
        }

        // Painel lateral para operadores (um abaixo do outro)
        JPanel painelOperadores = new JPanel(new GridLayout(4, 1, 5, 5));
        somar = new JButton("+");
        subtrair = new JButton("-");
        multiplicar = new JButton("*");
        dividir = new JButton("/");

        somar.addActionListener(this);
        subtrair.addActionListener(this);
        multiplicar.addActionListener(this);
        dividir.addActionListener(this);

        painelOperadores.add(somar);
        painelOperadores.add(subtrair);
        painelOperadores.add(multiplicar);
        painelOperadores.add(dividir);

        // Adiciona os painéis
        JPanel painelCentro = new JPanel(new BorderLayout(10, 10));
        painelCentro.add(painelNumeros, BorderLayout.CENTER);
        painelCentro.add(painelOperadores, BorderLayout.EAST);
        add(painelCentro, BorderLayout.CENTER);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object fonte = e.getSource();

        // Se clicou em número ou ponto
        for (int i = 0; i < botoesNumericos.length; i++) {
            if (fonte == botoesNumericos[i]) {
                String textoBotao = botoesNumericos[i].getText();
                if (textoBotao.equals("C")) {
                    if (campoAtivo != null) campoAtivo.setText("");
                    return;
                }
                if (campoAtivo != null) {
                    campoAtivo.setText(campoAtivo.getText() + textoBotao);
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
        new CalculadoraDoisCamposLayout();
    }
}
