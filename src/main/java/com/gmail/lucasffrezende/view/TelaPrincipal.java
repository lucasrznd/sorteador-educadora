package com.gmail.lucasffrezende.view;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

public class TelaPrincipal extends javax.swing.JFrame {

    private DefaultTableModel tableModel;

    public TelaPrincipal() {
        initComponents();

        Image icon = new ImageIcon(this.getClass().getResource("/images/logo_educadora.png")).getImage();
        this.setIconImage(icon);

        // Tabela de Nomes e Bairros
        tableModel = new DefaultTableModel();
        tableModel = (DefaultTableModel) tbtModel.getModel();
        tableModel.addColumn("Nome");
        tableModel.addColumn("Bairro");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelNome = new javax.swing.JLabel();
        nomeField = new javax.swing.JTextField();
        bairroField = new javax.swing.JTextField();
        labelBairro = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();
        sairButton = new javax.swing.JButton();
        sortearButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbtModel = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuAjustes = new javax.swing.JMenu();
        menuLimpar = new javax.swing.JMenuItem();
        menuAjuda = new javax.swing.JMenu();
        menuInfo = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("sorteadorEducadora - Tela Principal");
        setResizable(false);

        labelNome.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelNome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/1. nome.png"))); // NOI18N
        labelNome.setText("Nome");

        nomeField.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        nomeField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nomeFieldKeyPressed(evt);
            }
        });

        bairroField.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        bairroField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bairroFieldKeyPressed(evt);
            }
        });

        labelBairro.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelBairro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/2. bairro.png"))); // NOI18N
        labelBairro.setText("Bairro");

        addButton.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        addButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/3. add.png"))); // NOI18N
        addButton.setText("Adicionar");
        addButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        sairButton.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        sairButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/5. sair.png"))); // NOI18N
        sairButton.setText("Sair");
        sairButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sairButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairButtonActionPerformed(evt);
            }
        });

        sortearButton.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        sortearButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/4. sortear.png"))); // NOI18N
        sortearButton.setText("Sortear");
        sortearButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sortearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortearButtonActionPerformed(evt);
            }
        });

        tbtModel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jScrollPane1.setViewportView(tbtModel);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/background_capa.png"))); // NOI18N

        menuAjustes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/6. ajustes.png"))); // NOI18N
        menuAjustes.setText("Ajustes");
        menuAjustes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        menuLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/7. limpar.png"))); // NOI18N
        menuLimpar.setText("Limpar");
        menuLimpar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLimparActionPerformed(evt);
            }
        });
        menuAjustes.add(menuLimpar);

        jMenuBar1.add(menuAjustes);

        menuAjuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/8. ajuda.png"))); // NOI18N
        menuAjuda.setText("Ajuda");
        menuAjuda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        menuInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/9. info.png"))); // NOI18N
        menuInfo.setText("Informações");
        menuInfo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuInfoActionPerformed(evt);
            }
        });
        menuAjuda.add(menuInfo);

        jMenuBar1.add(menuAjuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77)
                        .addComponent(sortearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(sairButton, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nomeField, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(labelNome, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(150, 150, 150)
                                .addComponent(bairroField, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(226, 226, 226)
                                .addComponent(labelBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(170, 170, 170))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {addButton, sairButton, sortearButton});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {labelBairro, labelNome});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bairroField, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelNome, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(nomeField, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(sairButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(sortearButton, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {addButton, sairButton, sortearButton});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
        adicionarNomeBairro();
    }//GEN-LAST:event_addButtonActionPerformed

    private void sairButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairButtonActionPerformed

        System.exit(0);
    }//GEN-LAST:event_sairButtonActionPerformed

    private void sortearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortearButtonActionPerformed
        // TODO add your handling code here:
        if (tableModel.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Nenhum dado foi adicionado à tabela!", "Autenticação", JOptionPane.WARNING_MESSAGE);
        } else {
            sortearNomes();
        }
    }//GEN-LAST:event_sortearButtonActionPerformed

    private void menuLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuLimparActionPerformed
        // TODO add your handling code here:
        limparTabela();
    }//GEN-LAST:event_menuLimparActionPerformed

    private void menuInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuInfoActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Programa desenvolvido por Lucas Ferreira Rezende", "Informações do Programador", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_menuInfoActionPerformed

    private void nomeFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomeFieldKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            bairroField.requestFocus();
        }
    }//GEN-LAST:event_nomeFieldKeyPressed

    private void bairroFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bairroFieldKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            addButton.requestFocus();
        }
    }//GEN-LAST:event_bairroFieldKeyPressed

    private void adicionarNomeBairro() {
        String nome = nomeField.getText();
        String bairro = bairroField.getText();

        if (nome.isEmpty() || bairro.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.");
            return;
        }

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
            resultado.append("Nome: ").append(nome).append(" | Bairro: ").append(bairro).append("\n");
            JOptionPane.showMessageDialog(null, "Nomes Sorteados:\n" + resultado.toString());

        }
    }

    private void limparTabela() {
        tableModel.setRowCount(0);
    }

    public static void main(String args[]) {

        try {
            //here you can put the selected theme class name in JTattoo
            UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");

        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JTextField bairroField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelBairro;
    private javax.swing.JLabel labelNome;
    private javax.swing.JMenu menuAjuda;
    private javax.swing.JMenu menuAjustes;
    private javax.swing.JMenuItem menuInfo;
    private javax.swing.JMenuItem menuLimpar;
    private javax.swing.JTextField nomeField;
    private javax.swing.JButton sairButton;
    private javax.swing.JButton sortearButton;
    private javax.swing.JTable tbtModel;
    // End of variables declaration//GEN-END:variables
}
