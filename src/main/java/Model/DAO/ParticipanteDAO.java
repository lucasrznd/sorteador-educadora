package Model.DAO;

import Model.Exception.ParticipanteException;
import Model.Participante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class ParticipanteDAO {

    private final Banco banco = new Banco();
    private Connection conexao;

    public ParticipanteDAO() {
        this.conexao = banco.conectar();
    }

    public void insert(DefaultTableModel tableModel) {
        try {
            // Preparar a declaração SQL para inserção do participante
            String insertQuery = "INSERT INTO participante (nome, bairro) VALUES (?, ?)";
            PreparedStatement stmtInsert = conexao.prepareStatement(insertQuery);

            int rowCount = tableModel.getRowCount();

            // Inserir cada nome no banco de dados
            for (int i = 0; i < rowCount; i++) {
                String nome = (String) tableModel.getValueAt(i, 0);
                String bairro = (String) tableModel.getValueAt(i, 1);

                // Inserir no banco de dados
                stmtInsert.setString(1, nome);
                stmtInsert.setString(2, bairro);
                stmtInsert.executeUpdate();
            }

            // Fechar as declarações e a conexão com o banco de dados
            conexao.close();
            stmtInsert.close();

        } catch (SQLIntegrityConstraintViolationException e) {
            e.printStackTrace();
            throw new ParticipanteException("Erro de violação de restrição de integridade ao inserir participante.");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ParticipanteException("Erro de SQL ao inserir participante");
        } catch (ParticipanteException e) {
            e.printStackTrace();
            throw new ParticipanteException("Erro ao inserir participante");
        }

    }

    public void verificarDuplicidade(DefaultTableModel tableModel) {
        try {
            // Preparar a declaração SQL para verificação de duplicidade
            String verificaDuplicidade = "SELECT COUNT(*) FROM participante WHERE nome = ? AND bairro = ?";
            PreparedStatement stmtDuplicidade = conexao.prepareStatement(verificaDuplicidade);

            int rowCount = tableModel.getRowCount();

            // Inserir cada nome no banco de dados
            for (int i = 0; i < rowCount; i++) {
                String nome = (String) tableModel.getValueAt(i, 0);
                String bairro = (String) tableModel.getValueAt(i, 1);

                // Verificar duplicidade
                stmtDuplicidade.setString(1, nome);
                stmtDuplicidade.setString(2, bairro);
                ResultSet rs = stmtDuplicidade.executeQuery();
                rs.next();
                int count = rs.getInt(1);
                if (count > 0) {
                    // Nome e bairro já existem no banco de dados, exibir mensagem de erro
                    throw new ParticipanteException("Nome e bairro já existem: " + nome + ", " + bairro);
                }
                rs.close();
            }
            // Fechar as declarações e a conexão com o banco de dados
            stmtDuplicidade.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(DefaultTableModel tableModel) {
        try {
            // Preparar a declaração SQL para atualização do participante
            String updateQuery = "UPDATE participante SET nome = ?, bairro = ? WHERE id = ?";
            PreparedStatement stmtUpdate = conexao.prepareStatement(updateQuery);

            int rowCount = tableModel.getRowCount();

            // Atualizar cada participante no banco de dados
            for (int i = 0; i < rowCount; i++) {
                String nome = (String) tableModel.getValueAt(i, 0);
                String bairro = (String) tableModel.getValueAt(i, 1);
                int id = (int) tableModel.getValueAt(i, 2);

                stmtUpdate.setString(1, nome);
                stmtUpdate.setString(2, bairro);
                stmtUpdate.setInt(3, id);
                stmtUpdate.executeUpdate();
            }

            // Fechar a declaração e a conexão com o banco de dados
            stmtUpdate.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // Exibir mensagem de erro caso ocorra um problema na atualização
            throw new ParticipanteException("Erro ao atualizar participante.");
        }
    }

    public List<Participante> obterParticipantes() {
        List<Participante> participantes = new ArrayList<>();
        try {
            Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM participante");

            while (rs.next()) {
                String nome = rs.getString("nome");
                String bairro = rs.getString("bairro");

                participantes.add(new Participante(nome, bairro));
            }
            rs.close();
            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return participantes;
    }
}
