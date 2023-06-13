package Model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Banco {

    private Connection conexao;

    public Connection conectar() {
        try {
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/educadora_db", "root", "1234");
            System.out.println("Conectado com sucesso.");
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro.");
            e.printStackTrace();
        }
        return conexao;
    }
}
