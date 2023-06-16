package View;

import Controller.MenuRelatorioController;
import Model.GerarRelatorio;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;

public class MenuRelatorio extends javax.swing.JFrame {

    private final MenuRelatorioController controller;
    private GerarRelatorio relatorio;

    public MenuRelatorio() {
        initComponents();
        this.controller = new MenuRelatorioController(this);
        controller.importarTabela();
        this.relatorio = new GerarRelatorio(this);
        centralizarTexto();

        // Setar ícone do programa
        Image icon = new ImageIcon(this.getClass().getResource("/images/logo_educadora.png")).getImage();
        this.setIconImage(icon);
    }

    public static void designTela() {
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");

        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    public void centralizarTexto() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);

        for (int columnIndex = 0; columnIndex < jTable.getColumnCount(); columnIndex++) {
            jTable.getColumnModel().getColumn(columnIndex).setCellRenderer(centerRenderer);
        }
    }

    public void mensagemSimples(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }

    public void mensagemErro(String msg) {
        JOptionPane.showMessageDialog(null, msg, "Erro", JOptionPane.ERROR_MESSAGE);
    }

    public void mensagemAviso(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Aviso", JOptionPane.INFORMATION_MESSAGE);
    }

    public void mensagemSorteio(String msg) {
        JOptionPane.showMessageDialog(null, msg, "Resultado do Sorteio", JOptionPane.INFORMATION_MESSAGE);
    }

    public void mensagemUltimosSorteio(String msg) {
        JOptionPane.showMessageDialog(null, msg, "Últimos sorteados", JOptionPane.INFORMATION_MESSAGE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        lbBackground = new javax.swing.JLabel();
        labelNome = new javax.swing.JLabel();
        fieldNome = new javax.swing.JTextField();
        gerarValeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("sorteadorEducadora - Gerar Vale-Brinde");
        setResizable(false);

        jTable.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Bairro", "Data-Hora", "Locutor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable);

        lbBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/background_capa_relatorio.png"))); // NOI18N

        labelNome.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelNome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/1. nome.png"))); // NOI18N
        labelNome.setText("Nome");

        fieldNome.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        fieldNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldNomeActionPerformed(evt);
            }
        });
        fieldNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldNomeKeyPressed(evt);
            }
        });

        gerarValeButton.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        gerarValeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/15. vale_brinde.png"))); // NOI18N
        gerarValeButton.setText("Gerar Vale-Brinde");
        gerarValeButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        gerarValeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gerarValeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbBackground)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(300, 300, 300)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(labelNome, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(gerarValeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(lbBackground)
                .addGap(30, 30, 30)
                .addComponent(labelNome, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(fieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(gerarValeButton, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void fieldNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldNomeActionPerformed

    private void fieldNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldNomeKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldNomeKeyPressed

    private void gerarValeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gerarValeButtonActionPerformed
        // TODO add your handling code here:      
        relatorio.gerarRelatorioPDF();
    }//GEN-LAST:event_gerarValeButtonActionPerformed

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
        // TODO add your handling code here:
        System.out.println(controller.tabelaMouseClicked(evt, jTable));
    }//GEN-LAST:event_jTableMouseClicked

    public static void main(String args[]) {

        designTela();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuRelatorio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField fieldNome;
    private javax.swing.JButton gerarValeButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel lbBackground;
    // End of variables declaration//GEN-END:variables

    public JTextField getFieldNome() {
        return fieldNome;
    }

    public void setFieldNome(JTextField fieldNome) {
        this.fieldNome = fieldNome;
    }

    public JTable getjTable() {
        return jTable;
    }

    public void setjTable(JTable jTable) {
        this.jTable = jTable;
    }

}
