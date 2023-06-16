package Model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDAO {

    private final Banco banco = new Banco();
    private Connection conexao;

    public ItemDAO() {
        this.conexao = banco.conectar();
    }

    public List<String> obterDescricoesItens() {
        List<String> descricoes = new ArrayList<>();
        try {
            PreparedStatement statement = conexao.prepareStatement("SELECT descricao FROM item");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String descricao = resultSet.getString("descricao");
                descricoes.add(descricao);
            }
            conexao.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return descricoes;
    }

}
