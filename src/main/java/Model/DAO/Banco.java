package Model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

    public static void closeStatement(Statement st) {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
