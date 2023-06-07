package com.gmail.lucasffrezende.view;

import com.gmail.lucasffrezende.entities.Participante;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

public class TelaPrincipal extends javax.swing.JFrame {

    private DefaultTableModel tableModel;
    private List<Integer> indicesSorteados = new ArrayList<>();
    private StringBuilder nomesBairrosSorteados = new StringBuilder();
    private Connection conexao;

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
        menuSalvar = new javax.swing.JMenuItem();
        menuImportar = new javax.swing.JMenuItem();
        menuAjuda = new javax.swing.JMenu();
        menuInfo = new javax.swing.JMenuItem();
        menuUltimosSort = new javax.swing.JMenuItem();

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

        menuSalvar.setText("Salvar Dados");
        menuSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSalvarActionPerformed(evt);
            }
        });
        menuAjustes.add(menuSalvar);

        menuImportar.setText("Importar Dados");
        menuImportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuImportarActionPerformed(evt);
            }
        });
        menuAjustes.add(menuImportar);

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

    private void menuSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSalvarActionPerformed
        // TODO add your handling code here:
        salvarDadosNoBanco();
    }//GEN-LAST:event_menuSalvarActionPerformed

    private void menuImportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuImportarActionPerformed
        // TODO add your handling code here:
        importarDados();
    }//GEN-LAST:event_menuImportarActionPerformed

    private void menuUltimosSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuUltimosSortActionPerformed
        // TODO add your handling code here:
        exibirUltimosSorteados();
    }//GEN-LAST:event_menuUltimosSortActionPerformed

    private void adicionarNomeBairro() {
        String nome = nomeField.getText();
        String bairro = bairroField.getText();

        if (nome.isEmpty() || bairro.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.");
            return;
        }

        // Verificar se o nome e bairro já existem na tabela
        if (isNomeBairroRepetido(nome, bairro)) {
            JOptionPane.showMessageDialog(null, "Nome e bairro já existem na tabela!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        tableModel.addRow(new Object[]{nome, bairro});
        nomeField.setText("");
        bairroField.setText("");
    }

    private boolean isNomeBairroRepetido(String nome, String bairro) {
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            String nomeTabela = (String) tableModel.getValueAt(i, 0);
            String bairroTabela = (String) tableModel.getValueAt(i, 1);

            if (nomeTabela.equals(nome) && bairroTabela.equals(bairro)) {
                return true;
            }
        }

        return false;
    }

    private void sortearNomes() {
        // Obter a quantidade de pessoas a serem sorteadas
        int quantidadeSorteio = Integer.parseInt(JOptionPane.showInputDialog("Quantas pessoas serão sorteadas?"));

        // Obter os dados da JTable
        tableModel = (DefaultTableModel) tbtModel.getModel();
        int rowCount = tableModel.getRowCount();

        if (rowCount == 0) {
            JOptionPane.showMessageDialog(null, "Não há participantes para realizar o sorteio!", "Sortear", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (quantidadeSorteio > rowCount) {
            JOptionPane.showMessageDialog(null, "A quantidade de pessoas a serem sorteadas é maior do que o número de participantes!", "Sortear", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Realizar o sorteio
        Random random = new Random();
        List<Integer> indicesSorteados = new ArrayList<>();

        while (indicesSorteados.size() < quantidadeSorteio) {
            int indiceSorteado = random.nextInt(rowCount);

            if (!indicesSorteados.contains(indiceSorteado)) {
                indicesSorteados.add(indiceSorteado);
            }
        }

        // Exibir os nomes e bairros sorteados em um JOptionPane
        StringBuilder nomesBairrosSorteados = new StringBuilder();
        for (int indice : indicesSorteados) {
            String nomeSorteado = (String) tableModel.getValueAt(indice, 0);
            String bairroSorteado = (String) tableModel.getValueAt(indice, 1);
            nomesBairrosSorteados.append("Nome: ").append(nomeSorteado).append(", Bairro: ").append(bairroSorteado).append("\n");
        }

        JOptionPane.showMessageDialog(null, "Pessoa(s) sorteada(s):\n" + nomesBairrosSorteados.toString(), "Sortear", JOptionPane.INFORMATION_MESSAGE);

        // Obter os nomes sorteados e enviar para o banco de dados
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/educadora_db", "root", "1234")) {
            for (int indice : indicesSorteados) {
                String nomeSorteado = (String) tableModel.getValueAt(indice, 0);

                // Salvar os dados do sorteio na tabela "sorteios" do banco de dados
                String inserirSorteio = "INSERT INTO sorteios (nome_ganhador, data_sorteio) VALUES (?, ?)";
                PreparedStatement stmtInserirSorteio = conn.prepareStatement(inserirSorteio);
                stmtInserirSorteio.setString(1, nomeSorteado);
                stmtInserirSorteio.setDate(2, new java.sql.Date(new Date().getTime()));
                stmtInserirSorteio.executeUpdate();
            }

            JOptionPane.showMessageDialog(null, "Sorteio realizado com sucesso!", "Sortear", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao realizar o sorteio!", "Sortear", JOptionPane.ERROR_MESSAGE);
        }
    }

    public class Conexao {

        private static final String URL = "jdbc:mysql://localhost:3306/educadora_db";
        private static final String USUARIO = "root";
        private static final String SENHA = "1234";

        public static Connection obterConexao() throws SQLException {
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        }
    }

    private void exibirUltimosSorteados() {
        try {
            Connection conexao = Conexao.obterConexao();

            String sql = "SELECT nome_ganhador, data_sorteio FROM sorteios ORDER BY data_sorteio DESC LIMIT 5";
            PreparedStatement statement = conexao.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            StringBuilder resultado = new StringBuilder();
            while (resultSet.next()) {
                String nome = resultSet.getString("nome_ganhador");
                LocalDate dataSorteio = resultSet.getDate("data_sorteio").toLocalDate();
                resultado.append("Nome: ").append(nome).append(", Data do Sorteio: ").append(dataSorteio).append("\n");
            }

            if (resultado.length() > 0) {
                JOptionPane.showMessageDialog(this, "Últimos sorteados:\n" + resultado.toString(), "Últimos Sorteados", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Nenhum sorteio realizado.", "Últimos Sorteados", JOptionPane.INFORMATION_MESSAGE);
            }

            statement.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao obter os últimos sorteados.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limparTabela() {
        tableModel.setRowCount(0);
    }

    private void salvarDadosNoBanco() {
        try {
            // Estabelecer a conexão com o banco de dados
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/educadora_db", "root", "1234");

            // Preparar a declaração SQL para verificação de duplicidade
            String verificaDuplicidade = "SELECT COUNT(*) FROM participantes WHERE nome = ? AND bairro = ?";
            PreparedStatement stmtVerificaDuplicidade = conn.prepareStatement(verificaDuplicidade);

            // Preparar a declaração SQL para inserção dos nomes
            String inserirParticipante = "INSERT INTO participantes (nome, bairro) VALUES (?, ?)";
            PreparedStatement stmtInserirParticipante = conn.prepareStatement(inserirParticipante);

            // Obter os dados da JTable
            tableModel = (DefaultTableModel) tbtModel.getModel();
            int rowCount = tableModel.getRowCount();

            // Inserir cada nome no banco de dados
            for (int i = 0; i < rowCount; i++) {
                String nome = (String) tableModel.getValueAt(i, 0);
                String bairro = (String) tableModel.getValueAt(i, 1);

                // Verificar duplicidade
                stmtVerificaDuplicidade.setString(1, nome);
                stmtVerificaDuplicidade.setString(2, bairro);
                ResultSet rs = stmtVerificaDuplicidade.executeQuery();
                rs.next();
                int count = rs.getInt(1);

                if (count > 0) {
                    // Nome e bairro já existem no banco de dados, exibir mensagem de erro
                    JOptionPane.showMessageDialog(null, "Nome e bairro já existem: " + nome + ", " + bairro, "Erro de Duplicidade", JOptionPane.ERROR_MESSAGE);
                } else {
                    // Inserir no banco de dados
                    stmtInserirParticipante.setString(1, nome);
                    stmtInserirParticipante.setString(2, bairro);
                    stmtInserirParticipante.executeUpdate();
                    atualizarDados(nome, bairro);
                }
                rs.close();
            }

            // Fechar as declarações e a conexão com o banco de dados
            stmtVerificaDuplicidade.close();
            stmtInserirParticipante.close();
            conn.close();

            JOptionPane.showMessageDialog(null, "Dados salvos com sucesso!", "Salvar Dados", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao salvar os dados!", "Salvar Dados", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void importarDados() {
        // Verificar se os dados já foram importados
        if (tableModel.getRowCount() > 0) {
            JOptionPane.showMessageDialog(this, "Os dados já foram importados.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        // Obter os nomes e bairros da tabela "participantes" do banco de dados
        List<Participante> participantes = obterParticipantesDoBanco();

        // Adicionar os nomes e bairros à jTable
        for (Participante participante : participantes) {
            tableModel.addRow(new Object[]{participante.getNome(), participante.getBairro()});
        }
    }

    private List<Participante> obterParticipantesDoBanco() {
        List<Participante> participantes = new ArrayList<>();

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/educadora_db", "root", "1234");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM participantes");

            while (rs.next()) {
                String nome = rs.getString("nome");
                String bairro = rs.getString("bairro");

                participantes.add(new Participante(nome, bairro));
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return participantes;
    }

    private void salvarDados() {
        String nome = nomeField.getText();
        String bairro = nomeField.getText();

        // Verificar se o nome já existe na tabela
        if (verificarNomeExistente(nome)) {
            // Atualizar os dados para o nome existente
            atualizarDados(nome, bairro);
        } else {
            // Adicionar um novo registro na jTable
            tableModel.addRow(new Object[]{nome, bairro});
        }

    }

    private boolean verificarNomeExistente(String nome) {
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            String nomeTabela = (String) tableModel.getValueAt(i, 0);
            if (nomeTabela.equalsIgnoreCase(nome)) {
                return true;
            }
        }
        return false;
    }

    private void atualizarDados(String nome, String bairro) {
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            String nomeTabela = (String) tableModel.getValueAt(i, 0);
            if (nomeTabela.equalsIgnoreCase(nome)) {
                tableModel.setValueAt(bairro, i, 1);
                break;
            }
        }
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
    private javax.swing.JMenuItem menuImportar;
    private javax.swing.JMenuItem menuInfo;
    private javax.swing.JMenuItem menuLimpar;
    private javax.swing.JMenuItem menuSalvar;
    private javax.swing.JMenuItem menuUltimosSort;
    private javax.swing.JTextField nomeField;
    private javax.swing.JButton sairButton;
    private javax.swing.JButton sortearButton;
    private javax.swing.JTable tbtModel;
    // End of variables declaration//GEN-END:variables
}
