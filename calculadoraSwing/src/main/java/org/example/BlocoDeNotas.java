package org.example;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class BlocoDeNotas extends JFrame {
    private JTextArea areaTexto;
    private JFileChooser seletorArquivo;

    public BlocoDeNotas() {
        setTitle("Bloco de Notas");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Área de texto
        areaTexto = new JTextArea();
        areaTexto.setFont(new Font("Arial", Font.PLAIN, 16));
        JScrollPane scroll = new JScrollPane(areaTexto);
        add(scroll, BorderLayout.CENTER);

        // Menu
        JMenuBar menuBar = new JMenuBar();
        JMenu menuArquivo = new JMenu("Arquivo");
        JMenuItem salvarItem = new JMenuItem("Salvar");
        JMenuItem abrirItem = new JMenuItem("Abrir");
        JMenuItem sairItem = new JMenuItem("Sair");

        menuArquivo.add(abrirItem);
        menuArquivo.add(salvarItem);
        menuArquivo.addSeparator();
        menuArquivo.add(sairItem);
        menuBar.add(menuArquivo);
        setJMenuBar(menuBar);

        seletorArquivo = new JFileChooser();

        // Eventos
        salvarItem.addActionListener(e -> salvarArquivo());
        abrirItem.addActionListener(e -> abrirArquivo());
        sairItem.addActionListener(e -> System.exit(0));

        setVisible(true);
    }

    private void salvarArquivo() {
        int escolha = seletorArquivo.showSaveDialog(this);
        if (escolha == JFileChooser.APPROVE_OPTION) {
            File arquivo = seletorArquivo.getSelectedFile();
            try (BufferedWriter escritor = new BufferedWriter(new FileWriter(arquivo))) {
                escritor.write(areaTexto.getText());
                JOptionPane.showMessageDialog(this, "Arquivo salvo com sucesso!");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Erro ao salvar arquivo: " + ex.getMessage());
            }
        }
    }

    private void abrirArquivo() {
        int escolha = seletorArquivo.showOpenDialog(this);
        if (escolha == JFileChooser.APPROVE_OPTION) {
            File arquivo = seletorArquivo.getSelectedFile();
            try (BufferedReader leitor = new BufferedReader(new FileReader(arquivo))) {
                areaTexto.setText("");
                String linha;
                while ((linha = leitor.readLine()) != null) {
                    areaTexto.append(linha + "\n");
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Erro ao abrir arquivo: " + ex.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(BlocoDeNotas::new);
    }
}
