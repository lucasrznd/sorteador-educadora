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
            String sql = "SELECT nome_ganhador, data_sorteio FROM sorteio ORDER BY data_sorteio DESC LIMIT ?";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setInt(1, quantidade);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String nome = resultSet.getString("nome_ganhador");
                LocalDateTime dataSorteio = resultSet.getTimestamp("data_sorteio").toLocalDateTime();

                Sorteio sorteio = new Sorteio();
                Participante participante = new Participante();
                participante.setNome(nome);
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
}
