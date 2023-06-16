package Model.DAO;

import Model.Exception.SorteioException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpresaReferenciaDAO {

    private final Banco banco = new Banco();
    private Connection conexao;

    public EmpresaReferenciaDAO() {
        this.conexao = banco.conectar();
    }

    public List<String> obterNomesEmpresas() {
        List<String> nomes = new ArrayList<>();

        try {
            String sql = "SELECT nome FROM empresa_referencia";
            PreparedStatement statement = conexao.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String nome = resultSet.getString("nome");
                nomes.add(nome);
            }
            // Fechar os recursos
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nomes;
    }

    public int obterEmpresaPorNome(String nome) {
        int idEmpresa = 0;
        try {
            String sql = "SELECT id_empresa FROM empresa_referencia WHERE nome = ?";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, nome);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                idEmpresa = resultSet.getInt("id_empresa");
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SorteioException(e.getMessage());
        }
        return idEmpresa;
    }

}
