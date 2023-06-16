package Controller;

import Controller.Helper.MenuRelatorioHelper;
import Model.DAO.SorteioDAO;
import Model.Exception.ParticipanteException;
import Model.Participante;
import Model.Sorteio;
import View.MenuRelatorio;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

public class MenuRelatorioController {

    private MenuRelatorio view;
    private MenuRelatorioHelper helper;
    private DefaultTableModel tableModel;
    private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public MenuRelatorioController(MenuRelatorio view) {
        this.view = view;
        this.helper = new MenuRelatorioHelper(view);
        this.tableModel = helper.obterTabela();
    }

    public void importarTabela() {
        if (tableModel.getRowCount() > 0) {
            view.mensagemAviso("Os dados já foram importados.");
            return;
        } else {
            try {
                // Obter os nomes e bairros da tabela "participantes" do banco de dados
                SorteioDAO sorteioDAO = new SorteioDAO();
                List<Sorteio> sorteados = sorteioDAO.obterUltimosSorteios(10);

                // Adicionar os nomes e bairros à jTable
                for (Sorteio sorteio : sorteados) {
                    tableModel.addRow(new Object[]{sorteio.getParticipante().getNome(), sorteio.getParticipante().getBairro(),
                        sorteio.getDataSorteio()});
                }
            } catch (ParticipanteException e) {
                view.mensagemErro(e.getMessage());
            }
        }
    }

    public int tabelaMouseClicked(MouseEvent evt, JTable jTable) {
        int row = jTable.getSelectedRow();

        if (row >= 0) {
            int colunaNome = jTable.getColumn("Nome").getModelIndex();
            String nomeSelecionado = jTable.getValueAt(row, colunaNome).toString();
            view.getFieldNome().setText(nomeSelecionado);
        }
        return row;
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

    public void gerarRelatorio() {
        // Cria um parâmetro para os dados
        SorteioDAO sorteioDAO = new SorteioDAO();
        List<Sorteio> dados = sorteioDAO.obterUltimosSorteios(10);
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("dados", dados);

        System.out.println(parametros);

        try {
            // Compila o arquivo do relatório Jasper
            JasperReport jasperReport = JasperCompileManager.compileReport("vale-brinde.jrxml");

            // Preenche o relatório com os dados
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, new JREmptyDataSource());

            // Exporta o relatório para PDF
            JasperExportManager.exportReportToPdfFile(jasperPrint, "C:\\temp\\relatorio.pdf");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
