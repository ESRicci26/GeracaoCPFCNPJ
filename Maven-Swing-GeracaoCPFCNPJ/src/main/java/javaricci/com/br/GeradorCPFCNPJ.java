package javaricci.com.br;

import javax.swing.*;
import java.awt.*;

public class GeradorCPFCNPJ {
    private JTextArea textArea;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GeradorCPFCNPJ().criarMenu());
    }

    private void criarMenu() {
        JFrame frame = new JFrame("Gerador de CPF e CNPJ");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // JTextArea para exibir os resultados
        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(textArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Botões para gerar CNPJ e CPF
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        JButton gerarCNPJButton = new JButton("Gerar CNPJ");
        JButton gerarCPFButton = new JButton("Gerar CPF");

        gerarCNPJButton.addActionListener(e -> adicionarResultado("CNPJ Gerado: " + new GeraCNPJ().geraCNPJFim()));
        gerarCPFButton.addActionListener(e -> adicionarResultado("CPF Gerado: " + new GeraCPF().geraCPFFinal()));

        buttonPanel.add(gerarCNPJButton);
        buttonPanel.add(gerarCPFButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }

    private void adicionarResultado(String texto) {
        textArea.append(texto + "\n");
    }
}
