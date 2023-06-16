package Model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BrindeDAO {

    private final Banco banco = new Banco();
    private Connection conexao;

    public BrindeDAO() {
        this.conexao = banco.conectar();
    }

    public int obterIdBrindePorDescricao(String descricao) {
        int idBrinde = 0;
        try {
            String sql = "SELECT id_brinde FROM brinde WHERE descricao = ?";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, descricao);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                idBrinde = resultSet.getInt("id_brinde");
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idBrinde;
    }

}
