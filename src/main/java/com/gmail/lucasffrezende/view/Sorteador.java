package com.gmail.lucasffrezende.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Sorteador extends JFrame {

    private JTextField nomeField;
    private JTextField bairroField;
    private DefaultTableModel tableModel;

    public Sorteador() {
        setTitle("Sorteador");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        JPanel panel = new JPanel(new BorderLayout());

        // Campos de entrada
        JPanel inputPanel = new JPanel(new GridLayout(2, 2));
        inputPanel.add(new JLabel("Nome:"));
        nomeField = new JTextField();
        inputPanel.add(nomeField);
        inputPanel.add(new JLabel("Bairro:"));
        bairroField = new JTextField();
        inputPanel.add(bairroField);

        // Botão Adicionar
        JButton addButton = new JButton("Adicionar");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarNomeBairro();
            }
        });

        // Tabela de Nomes e Bairros
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Nome");
        tableModel.addColumn("Bairro");
        JTable table = new JTable(tableModel);

        // Botão Sortear
        JButton sortearButton = new JButton("Sortear");
        sortearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sortearNomes();
            }
        });

        // Botão Sair
        JButton sairButton = new JButton("Sair");
        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Layout do painel principal
        panel.add(inputPanel, BorderLayout.NORTH);
        panel.add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(sortearButton);
        buttonPanel.add(sairButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        getContentPane().add(panel);
        setVisible(true);
    }

    private void adicionarNomeBairro() {
        String nome = nomeField.getText();
        String bairro = bairroField.getText();
        tableModel.addRow(new Object[]{nome, bairro});
        nomeField.setText("");
        bairroField.setText("");
    }

    private void sortearNomes() {
        int numSorteios = Integer.parseInt(JOptionPane.showInputDialog("Quantos nomes deseja sortear?"));
        int numPessoas = tableModel.getRowCount();
        if (numSorteios > numPessoas) {
            JOptionPane.showMessageDialog(null, "Não há pessoas suficientes para sortear.");
            return;
        }

        List<Integer> indicesSorteados = new ArrayList<>();
        Random random = new Random();
        while (indicesSorteados.size() < numSorteios) {
            int indiceSorteado = random.nextInt(numPessoas);
            if (!indicesSorteados.contains(indiceSorteado)) {
                indicesSorteados.add(indiceSorteado);
            }
        }

        StringBuilder resultado = new StringBuilder();
        for (int indice : indicesSorteados) {
            String nome = (String) tableModel.getValueAt(indice, 0);
            String bairro = (String) tableModel.getValueAt(indice, 1);
            resultado.append("Nome: ").append(nome).append(", Bairro: ").append(bairro).append("\n");
            JOptionPane.showMessageDialog(null, "Nomes Sorteados:\n" + resultado.toString());

        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Sorteador();
            }
        });
    }
}
