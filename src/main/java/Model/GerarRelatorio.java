package Model;

import Model.DAO.Banco;
import Model.DAO.SorteioDAO;
import View.MenuRelatorio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JTable;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

public class GerarRelatorio {

    private MenuRelatorio view;
    private final Banco banco = new Banco();
    private Connection conexao;

    public GerarRelatorio(MenuRelatorio view) {
        this.view = view;
        this.conexao = banco.conectar();
    }

    public Sorteio getSorteioFromTable(JTable table) {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            // Nenhum registro selecionado
            return null;
        }

        // Obter os valores das células selecionadas
        String nomeGanhador = table.getValueAt(selectedRow, 0).toString();
        String bairro = table.getValueAt(selectedRow, 1).toString();
        String dataSorteio = table.getValueAt(selectedRow, 2).toString();

        // Chamar o método findByNomeAndData para obter o sorteio correspondente
        SorteioDAO sorteioDAO = new SorteioDAO();
        Sorteio sorteio = sorteioDAO.findByNomeAndData(nomeGanhador, bairro, dataSorteio);

        return sorteio;
    }

    public void gerarRelatorioPDF() {
        JTable table = view.getjTable();
        // Obtém o Sorteio com base nos dados da tabela
        Sorteio sorteio = getSorteioFromTable(table);

        // Verifica se foi encontrado um Sorteio válido
        if (sorteio != null) {
            try {
                // Carrega o arquivo Jasper
                String arquivoJasper = "vale-brinde.jrxml";
                JasperReport relatorio = JasperCompileManager.compileReport("vale-brinde.jrxml");

                // Cria os parâmetros do relatório
                Map<String, Object> parametros = new HashMap<>();
                parametros.put("nome_ganhador", sorteio.getParticipante().getNome());
                parametros.put("bairro", sorteio.getParticipante().getBairro());
                parametros.put("data_sorteio", sorteio.getDataSorteio());

                // Realiza a consulta para obter os dados do Sorteio
                SorteioDAO sorteioDAO = new SorteioDAO();
                Sorteio sorteioEncontrado = sorteioDAO.findByNomeAndData(sorteio.getParticipante().getNome(), sorteio.getParticipante().getBairro(), sorteio.getDataSorteio().toString());

                // Cria o ResultSet com os dados encontrados
                ResultSet resultSet = createResultSet(sorteioEncontrado);

                // Cria o JRResultSetDataSource com o ResultSet
                JRDataSource dataSource = new JRResultSetDataSource(resultSet);

                // Preenche o relatório com os dados do dataSource
                JasperPrint jasperPrint = JasperFillManager.fillReport(relatorio, parametros, dataSource);

                // Exporta o relatório para PDF
                String nomeParticipante = sorteioEncontrado.getParticipante().getNome();
                String arquivoPDF = personalizarNomeArquivo(nomeParticipante);
                JasperExportManager.exportReportToPdfFile(jasperPrint, arquivoPDF);

                view.mensagemSimples("Vale-Brinde gerado com sucesso.");
            } catch (JRException e) {
                e.printStackTrace();
            }
        }
    }

    public String personalizarNomeArquivo(String nomeParticipante) {
        // Obtenha a data e hora atual
        LocalDateTime now = LocalDateTime.now();

        // Crie um formato de data para o timestamp
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy-HH-mm");

        // Remova espaços em branco e caracteres especiais do nome do participante
        String nomeArquivo = nomeParticipante.replaceAll("[^a-zA-Z0-9]", "_");

        // Concatene o nome do participante com a data e hora atual
        nomeArquivo += "_" + now.format(formatter) + ".pdf";

        // Caminho completo do arquivo
        String arquivoPDF = "c:\\temp\\" + nomeArquivo;
        return arquivoPDF;
    }

    private ResultSet createResultSet(Sorteio sorteio) {
        try {
            // Construa a conexão com o banco de dados

            // Crie a consulta SQL com base nos dados do Sorteio
            String sql = "SELECT nome_ganhador, bairro, data_sorteio FROM sorteio WHERE nome_ganhador = ? AND bairro = ? AND data_sorteio = ?";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, sorteio.getParticipante().getNome());
            statement.setString(2, sorteio.getParticipante().getBairro());
            statement.setString(3, sorteio.getDataSorteio().toString());

            // Execute a consulta e retorne o ResultSet
            return statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

}
