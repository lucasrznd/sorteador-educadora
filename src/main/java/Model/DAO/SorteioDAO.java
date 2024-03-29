package Model.DAO;

import Model.Brinde;
import Model.EmpresaReferencia;
import Model.Exception.SorteioException;
import Model.Item;
import Model.Locutor;
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
            String sql = "INSERT INTO sorteio (nome_ganhador, bairro, data_sorteio, nome_locutor, brinde, quantidade, empresa_referencia) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, sorteio.getParticipante().getNome());
            statement.setString(2, sorteio.getParticipante().getBairro());
            statement.setTimestamp(3, Timestamp.valueOf(sorteio.getDataSorteio()));
            statement.setString(4, sorteio.getLocutor().getNome());
            statement.setString(5, sorteio.getBrinde().getItem().getDescricao());
            statement.setString(6, sorteio.getBrinde().getQuantidade());
            statement.setString(7, sorteio.getEmpresaReferencia().getNome());

            statement.executeUpdate();

            statement.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SorteioException(e.getMessage());
        }
    }

    public List<Sorteio> obterUltimosSorteios(int quantidade) {
        List<Sorteio> ultimosSorteios = new ArrayList<>();

        try {
            String sql = "SELECT nome_ganhador, bairro, data_sorteio, nome_locutor FROM sorteio ORDER BY data_sorteio DESC LIMIT ?";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setInt(1, quantidade);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String nome = resultSet.getString("nome_ganhador");
                String bairro = resultSet.getString("bairro");
                LocalDateTime dataSorteio = resultSet.getTimestamp("data_sorteio").toLocalDateTime();
                String nomeLocutor = resultSet.getString("nome_locutor");

                Sorteio sorteio = new Sorteio();
                Participante participante = new Participante();
                participante.setNome(nome);
                participante.setBairro(bairro);
                sorteio.setParticipante(participante);
                sorteio.setDataSorteio(dataSorteio);

                Locutor locutor = new Locutor(nomeLocutor);
                sorteio.setLocutor(locutor);
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
            String sql = "SELECT nome_ganhador, bairro, data_sorteio, nome_locutor, brinde, quantidade, empresa_referencia FROM sorteio WHERE nome_ganhador = ? AND bairro = ? AND data_sorteio = ?";
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

                // Adicione as informações adicionais do sorteio
                Locutor locutor = new Locutor();
                locutor.setNome(resultSet.getString("nome_locutor"));
                sorteio.setLocutor(locutor);

                Brinde brinde = new Brinde();
                Item item = new Item();
                item.setDescricao(resultSet.getString("brinde"));
                brinde.setItem(item);
                brinde.setQuantidade(resultSet.getString("quantidade"));
                sorteio.setBrinde(brinde);

                EmpresaReferencia empresaReferencia = new EmpresaReferencia();
                empresaReferencia.setNome(resultSet.getString("empresa_referencia"));
                sorteio.setEmpresaReferencia(empresaReferencia);

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
