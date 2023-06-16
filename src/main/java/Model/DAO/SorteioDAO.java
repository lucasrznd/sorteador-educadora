package Model.DAO;

import Model.Exception.SorteioException;
import Model.Participante;
import Model.Sorteio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SorteioDAO {

    private final Banco banco = new Banco();
    private Connection conexao;

    public SorteioDAO() {
        this.conexao = banco.conectar();
    }

    public void insert(Sorteio sorteio) {
        try {
            String sql = "INSERT INTO sorteio (nome_ganhador, bairro, data_sorteio) VALUES (?, ?, ?)";
            PreparedStatement smtInsert = conexao.prepareStatement(sql);
            smtInsert.setString(1, sorteio.getParticipante().getNome());
            smtInsert.setString(2, sorteio.getParticipante().getBairro());
            smtInsert.setTimestamp(3, Timestamp.valueOf(sorteio.getDataSorteio()));
            smtInsert.executeUpdate();

            smtInsert.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SorteioException(e.getMessage());
        }
    }

    public List<Sorteio> obterUltimosSorteios(int quantidade) {
        List<Sorteio> ultimosSorteios = new ArrayList<>();

        try {
            String sql = "SELECT nome_ganhador, bairro, data_sorteio FROM sorteio ORDER BY data_sorteio DESC LIMIT ?";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setInt(1, quantidade);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String nome = resultSet.getString("nome_ganhador");
                String bairro = resultSet.getString("bairro");
                LocalDateTime dataSorteio = resultSet.getTimestamp("data_sorteio").toLocalDateTime();

                Sorteio sorteio = new Sorteio();
                Participante participante = new Participante();
                participante.setNome(nome);
                participante.setBairro(bairro);
                sorteio.setParticipante(participante);
                sorteio.setDataSorteio(dataSorteio);

                ultimosSorteios.add(sorteio);
            }
            statement.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SorteioException(e.getMessage());
        }
        return ultimosSorteios;
    }

    public Sorteio findByNomeAndData(String nomeGanhador, String bairro, String dataSorteio) {
        try {
            String sql = "SELECT nome_ganhador, bairro, data_sorteio FROM sorteio WHERE nome_ganhador = ? AND bairro = ? AND data_sorteio = ?";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, nomeGanhador);
            statement.setString(2, bairro);
            statement.setString(3, dataSorteio);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Sorteio sorteio = new Sorteio();
                Participante participante = new Participante();
                participante.setNome(resultSet.getString("nome_ganhador"));
                participante.setBairro(resultSet.getString("bairro"));
                sorteio.setParticipante(participante);
                sorteio.setDataSorteio(resultSet.getTimestamp("data_sorteio").toLocalDateTime());
                return sorteio;
            }

            statement.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SorteioException(e.getMessage());
        }

        return null;
    }

}
