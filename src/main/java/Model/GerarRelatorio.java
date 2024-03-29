package Model;

import Model.DAO.Banco;
import Model.DAO.SorteioDAO;
import View.MenuRelatorio;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
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
        Sorteio sorteio = getSorteioFromTable(table);

        // Verifica se foi encontrado um Sorteio válido
        if (sorteio != null) {
            try {

                String arquivoJasper;
                if (System.getProperty("netbeans.home") != null) {
                    // Executando no NetBeans
                    arquivoJasper = "vale-brinde.jrxml";
                } else {
                    // Executando no JAR compilado
                    arquivoJasper = "/vale-brinde.jrxml";
                }

                JasperReport relatorio = JasperCompileManager.compileReport("vale-brinde.jrxml");

                String quantidade = sorteio.getBrinde().getQuantidade();
                String brinde = sorteio.getBrinde().getItem().getDescricao();
                String brindeConcatenado = quantidade + " - " + brinde;

                // Cria os parâmetros do relatório
                Map<String, Object> parametros = new HashMap<>();
                parametros.put("nome_ganhador", sorteio.getParticipante().getNome());
                parametros.put("bairro", sorteio.getParticipante().getBairro());
                parametros.put("data_sorteio", sorteio.getDataSorteio());
                parametros.put("nome_locutor", sorteio.getLocutor().getNome());
                parametros.put("brinde", brindeConcatenado);
                parametros.put("empresa_referencia", sorteio.getEmpresaReferencia().getNome());

                // Realiza a consulta para obter os dados do Sorteio
                SorteioDAO sorteioDAO = new SorteioDAO();
                Sorteio sorteioEncontrado = sorteioDAO.findByNomeAndData(sorteio.getParticipante().getNome(), sorteio.getParticipante().getBairro(), sorteio.getDataSorteio().toString());

                // Cria o ResultSet com os dados encontrados
                ResultSet resultSet = createResultSet(sorteioEncontrado.getParticipante().getNome(), sorteioEncontrado.getParticipante().getBairro(), sorteioEncontrado.getDataSorteio());

                // Cria o JRResultSetDataSource com o ResultSet
                JRDataSource dataSource = new JRResultSetDataSource(resultSet);

                // Preenche o relatório com os dados do dataSource
                JasperPrint jasperPrint = JasperFillManager.fillReport(relatorio, parametros, dataSource);

                // Exporta o relatório para PDF
                String nomeParticipante = sorteioEncontrado.getParticipante().getNome();
                String arquivoPDF = personalizarNomeArquivo(nomeParticipante);
                JasperExportManager.exportReportToPdfFile(jasperPrint, arquivoPDF);

                try {
                    File file = new File(arquivoPDF);
                    if (file.exists()) {
                        File directory = file.getParentFile();
                        Desktop.getDesktop().open(directory);

                        Desktop.getDesktop().open(file);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    view.mensagemErro("Não foi possível gerar Vale: " + e.getMessage());
                }
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

    public ResultSet createResultSet(String nomeGanhador, String bairro, LocalDateTime dataSorteio) {
        try {
            String sql = "SELECT nome_ganhador, bairro, data_sorteio, nome_locutor, brinde, quantidade, empresa_referencia FROM sorteio WHERE nome_ganhador = ? AND bairro = ? AND data_sorteio = ?";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, nomeGanhador);
            statement.setString(2, bairro);
            statement.setString(3, dataSorteio.toString());

            // Execute a consulta e retorne o ResultSet
            return statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
