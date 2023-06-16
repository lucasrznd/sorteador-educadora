package Model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LocutorDAO {

    private final Banco banco = new Banco();
    private Connection conexao;

    public LocutorDAO() {
        this.conexao = banco.conectar();
    }

    public List<String> obterLocutoresCadastrados() {
        List<String> locutores = new ArrayList<>();
        String sql = "SELECT nome FROM locutor";

        try {
            PreparedStatement statement = conexao.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String nome = resultSet.getString("nome");
                locutores.add(nome);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return locutores;
    }

    public int obterIdLocutorPorNome(String nome) throws SQLException {
        String sql = "SELECT id_locutor FROM locutor WHERE nome = ?";

        try (PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setString(1, nome);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt("id_locutor");
            }

            return 0;
        }
    }

}
