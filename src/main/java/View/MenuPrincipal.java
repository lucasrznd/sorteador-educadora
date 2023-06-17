package View;

import Controller.MenuPrincipalController;
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;

public class MenuPrincipal extends javax.swing.JFrame {

    private final MenuPrincipalController controller;
    private int qtdParticipantes;
    private MenuRelatorio menuRelatorio = new MenuRelatorio();

    public MenuPrincipal() {
        initComponents();
        controller = new MenuPrincipalController(this);
        centralizarTexto();

        // Carregar locutores do banco
        controller.carregarLocutoresCadastrados();
        controller.importarItens();
        controller.importarEmpresas();

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

        for (int columnIndex = 0; columnIndex < tabelaSorteio.getColumnCount(); columnIndex++) {
            tabelaSorteio.getColumnModel().getColumn(columnIndex).setCellRenderer(centerRenderer);
        }
    }

    public void mensagemDesenvolvedor() {
        JOptionPane.showMessageDialog(null, "Programa desenvolvido por Lucas Ferreira Rezende", "Informações do Programador", JOptionPane.INFORMATION_MESSAGE);
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

        jCheckBox1 = new javax.swing.JCheckBox();
        labelNome = new javax.swing.JLabel();
        labelBairro = new javax.swing.JLabel();
        fieldNome = new javax.swing.JTextField();
        fieldBairro = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        sortearButton = new javax.swing.JButton();
        sairButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaSorteio = new javax.swing.JTable();
        lbBackground = new javax.swing.JLabel();
        boxLocutores = new javax.swing.JComboBox<>();
        boxEmpresa = new javax.swing.JComboBox<>();
        boxItem = new javax.swing.JComboBox<>();
        boxQuantidade = new javax.swing.JComboBox<>();
        lbBrinde = new javax.swing.JLabel();
        lbLocutor = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuOpcoes = new javax.swing.JMenu();
        menuLimpar = new javax.swing.JMenuItem();
        menuSalvar = new javax.swing.JMenuItem();
        menuImportar = new javax.swing.JMenuItem();
        menuVale = new javax.swing.JMenuItem();
        menuAjuda = new javax.swing.JMenu();
        menuInfo = new javax.swing.JMenuItem();
        menuUltimosSort = new javax.swing.JMenuItem();

        jCheckBox1.setText("jCheckBox1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("sorteadorEducadora - Tela Principal");
        setResizable(false);

        labelNome.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelNome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/1. nome.png"))); // NOI18N
        labelNome.setText("Nome");

        labelBairro.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelBairro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/2. bairro.png"))); // NOI18N
        labelBairro.setText("Bairro");

        fieldNome.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
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

        fieldBairro.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        fieldBairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldBairroActionPerformed(evt);
            }
        });
        fieldBairro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldBairroKeyPressed(evt);
            }
        });

        addButton.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        addButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/3. add.png"))); // NOI18N
        addButton.setText("Adicionar");
        addButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
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

        sairButton.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        sairButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/5. sair.png"))); // NOI18N
        sairButton.setText("Sair");
        sairButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sairButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairButtonActionPerformed(evt);
            }
        });

        tabelaSorteio.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tabelaSorteio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Bairro"
            }
        ));
        tabelaSorteio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane1.setViewportView(tabelaSorteio);

        lbBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/background_capa.png"))); // NOI18N

        boxLocutores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        boxEmpresa.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        boxEmpresa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        boxEmpresa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        boxItem.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        boxItem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        boxItem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        boxQuantidade.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        boxQuantidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));
        boxQuantidade.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lbBrinde.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbBrinde.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/13. brinde.png"))); // NOI18N
        lbBrinde.setText("Brinde");

        lbLocutor.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbLocutor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/14. locutor.png"))); // NOI18N
        lbLocutor.setText("Locutor");

        menuOpcoes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/6. ajustes.png"))); // NOI18N
        menuOpcoes.setText("Opções");
        menuOpcoes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        menuLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/7. limpar.png"))); // NOI18N
        menuLimpar.setText("Limpar");
        menuLimpar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLimparActionPerformed(evt);
            }
        });
        menuOpcoes.add(menuLimpar);

        menuSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/11. salvar.png"))); // NOI18N
        menuSalvar.setText("Salvar Dados");
        menuSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSalvarActionPerformed(evt);
            }
        });
        menuOpcoes.add(menuSalvar);

        menuImportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/10. importar.png"))); // NOI18N
        menuImportar.setText("Importar Dados");
        menuImportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuImportarActionPerformed(evt);
            }
        });
        menuOpcoes.add(menuImportar);

        menuVale.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/16.vale-brinde-menu.png"))); // NOI18N
        menuVale.setText("Gerar Vale-Brinde");
        menuVale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuValeActionPerformed(evt);
            }
        });
        menuOpcoes.add(menuVale);

        jMenuBar1.add(menuOpcoes);

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

        menuUltimosSort.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/12. ultimosSorteados.png"))); // NOI18N
        menuUltimosSort.setText("Últimos sorteados");
        menuUltimosSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuUltimosSortActionPerformed(evt);
            }
        });
        menuAjuda.add(menuUltimosSort);

        jMenuBar1.add(menuAjuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbBackground)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(205, 205, 205)
                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77)
                .addComponent(sortearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sairButton, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(164, 164, 164))
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(labelNome, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(labelBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(fieldBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(boxEmpresa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(boxQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(boxItem, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(lbBrinde)))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(boxLocutores, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lbLocutor)
                        .addGap(85, 85, 85))))
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
                .addComponent(lbBackground)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(labelNome, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(fieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(boxLocutores, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbLocutor))
                        .addGap(18, 18, 18)
                        .addComponent(fieldBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(boxQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(boxItem, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boxEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lbBrinde)
                        .addGap(66, 66, 66)))
                .addGap(18, 18, 18)
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
        controller.adicionarNomeBairro();
    }//GEN-LAST:event_addButtonActionPerformed

    private void sairButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairButtonActionPerformed

        System.exit(0);
    }//GEN-LAST:event_sairButtonActionPerformed

    private void sortearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortearButtonActionPerformed
        // TODO add your handling code here:
        qtdParticipantes = Integer.parseInt(JOptionPane.showInputDialog(null, "Quantas pessoas serão sorteadas?:", "Realizar Sorteio", JOptionPane.QUESTION_MESSAGE));
        controller.insertSorteio();
    }//GEN-LAST:event_sortearButtonActionPerformed

    private void menuLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuLimparActionPerformed
        // TODO add your handling code here:
        controller.limparTabela();
    }//GEN-LAST:event_menuLimparActionPerformed

    private void menuInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuInfoActionPerformed
        // TODO add your handling code here:
        mensagemDesenvolvedor();
    }//GEN-LAST:event_menuInfoActionPerformed

    private void fieldNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldNomeKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            fieldBairro.requestFocus();
        }
    }//GEN-LAST:event_fieldNomeKeyPressed

    private void fieldBairroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldBairroKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            addButton.requestFocus();
        }
    }//GEN-LAST:event_fieldBairroKeyPressed

    private void menuSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSalvarActionPerformed
        // TODO add your handling code here:
        this.controller.insertParticipante();
    }//GEN-LAST:event_menuSalvarActionPerformed

    private void menuImportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuImportarActionPerformed
        // TODO add your handling code here:
        controller.importarTabela();
    }//GEN-LAST:event_menuImportarActionPerformed

    private void menuUltimosSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuUltimosSortActionPerformed
        // TODO add your handling code here:
        //exibirUltimosSorteados();
        qtdParticipantes = Integer.parseInt(JOptionPane.showInputDialog(null, "Deseja visualizar quantos?:", "Últimos Sorteios", JOptionPane.QUESTION_MESSAGE));
        controller.ultimoSorteados();
    }//GEN-LAST:event_menuUltimosSortActionPerformed

    private void fieldBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldBairroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldBairroActionPerformed

    private void fieldNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldNomeActionPerformed

    private void menuValeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuValeActionPerformed
        // TODO add your handling code here:
        menuRelatorio.setVisible(true);
    }//GEN-LAST:event_menuValeActionPerformed

    public static void main(String args[]) {

        designTela();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JComboBox<String> boxEmpresa;
    private javax.swing.JComboBox<String> boxItem;
    private javax.swing.JComboBox<String> boxLocutores;
    private javax.swing.JComboBox<String> boxQuantidade;
    private javax.swing.JTextField fieldBairro;
    private javax.swing.JTextField fieldNome;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelBairro;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel lbBackground;
    private javax.swing.JLabel lbBrinde;
    private javax.swing.JLabel lbLocutor;
    private javax.swing.JMenu menuAjuda;
    private javax.swing.JMenuItem menuImportar;
    private javax.swing.JMenuItem menuInfo;
    private javax.swing.JMenuItem menuLimpar;
    private javax.swing.JMenu menuOpcoes;
    private javax.swing.JMenuItem menuSalvar;
    private javax.swing.JMenuItem menuUltimosSort;
    private javax.swing.JMenuItem menuVale;
    private javax.swing.JButton sairButton;
    private javax.swing.JButton sortearButton;
    private javax.swing.JTable tabelaSorteio;
    // End of variables declaration//GEN-END:variables

    public JTextField getFieldNome() {
        return fieldNome;
    }

    public void setFieldNome(JTextField fieldNome) {
        this.fieldNome = fieldNome;
    }

    public JTextField getFieldBairro() {
        return fieldBairro;
    }

    public void setFieldBairro(JTextField fieldBairro) {
        this.fieldBairro = fieldBairro;
    }

    public JTable getTabelaSorteio() {
        return tabelaSorteio;
    }

    public void setTabelaSorteio(JTable tabelaSorteio) {
        this.tabelaSorteio = tabelaSorteio;
    }

    public int getQtdParticipantes() {
        return qtdParticipantes;
    }

    public void setQtdParticipantes(int qtdParticipantes) {
        this.qtdParticipantes = qtdParticipantes;
    }

    public JComboBox<String> getBoxLocutores() {
        return boxLocutores;
    }

    public void setBoxLocutores(JComboBox<String> boxLocutores) {
        this.boxLocutores = boxLocutores;
    }

    public JComboBox<String> getBoxEmpresa() {
        return boxEmpresa;
    }

    public void setBoxEmpresa(JComboBox<String> boxEmpresa) {
        this.boxEmpresa = boxEmpresa;
    }

    public JComboBox<String> getBoxItem() {
        return boxItem;
    }

    public void setBoxItem(JComboBox<String> boxItem) {
        this.boxItem = boxItem;
    }

    public JComboBox<String> getBoxQuantidade() {
        return boxQuantidade;
    }

    public void setBoxQuantidade(JComboBox<String> boxQuantidade) {
        this.boxQuantidade = boxQuantidade;
    }

}
