package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculadoraColorida extends JFrame implements ActionListener {
    JTextField campo1, campo2, resultado;
    JButton somar, subtrair, multiplicar, dividir, um, dois, tres;

    public CalculadoraColorida() {
        setTitle("🧮 Calculadora Colorida");
        setSize(450, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(8, 4, 5, 5));
        getContentPane().setBackground(new Color(240, 248, 255)); // cor de fundo

        // Estilo dos campos
        campo1 = new JTextField();
        campo2 = new JTextField();
        resultado = new JTextField();
        resultado.setEditable(false);
        resultado.setBackground(new Color(230, 230, 250)); // lilás claro

        // Labels
        add(new JLabel("🔢 Número 1:"));
        add(campo1);
        add(new JLabel("🔢 Número 2:"));
        add(campo2);

        // Botões com emojis
        somar = new JButton("➕");
        subtrair = new JButton("➖");
        multiplicar = new JButton("✖️");
        dividir = new JButton("➗");
        um = new JButton("1");
        dois = new JButton("2");
        tres = new JButton("3");

        // Cores dos botões
        somar.setBackground(new Color(144, 238, 144));       // verde claro
        subtrair.setBackground(new Color(255, 182, 193));    // rosa claro
        multiplicar.setBackground(new Color(173, 216, 230)); // azul claro
        dividir.setBackground(new Color(255, 255, 153));     // amarelo claro

        // Eventos
        somar.addActionListener(this);
        subtrair.addActionListener(this);
        multiplicar.addActionListener(this);
        dividir.addActionListener(this);
        um.addActionListener(this);
        dois.addActionListener(this);
        tres.addActionListener(this);

        add(um);
        add(dois);
        add(tres);
        add(somar);
        add(subtrair);
        add(multiplicar);
        add(dividir);


        add(new JLabel("📄 Resultado:"));
        add(resultado);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        double num1 = 0;
        double num2 = 0;
        double res = 0;

        try {
            if(e.getSource() == um){
                num1 = Double.parseDouble("1");
            }
            if (e.getSource() == dois){
                num2 = Double.parseDouble("2");
            }

            if (e.getSource() == somar) {
                res = num1 + num2;
            } else if (e.getSource() == subtrair) {
                res = num1 - num2;
            } else if (e.getSource() == multiplicar) {
                res = num1 * num2;
            } else if (e.getSource() == dividir) {
                if (num2 == 0) {
                    resultado.setText("⚠️ Erro: divisão por zero!");
                    resultado.setBackground(Color.PINK);
                    return;
                }
                res = num1 / num2;
            }

            resultado.setText("✅ " + res);
            resultado.setBackground(new Color(230, 230, 250)); // volta ao normal
        } catch (NumberFormatException ex) {
            resultado.setText("❌ Entrada inválida!");
            resultado.setBackground(Color.PINK);
        }
    }

    public static void main(String[] args) {
        new CalculadoraColorida();
    }
}