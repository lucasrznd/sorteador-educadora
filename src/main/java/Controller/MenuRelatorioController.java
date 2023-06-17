package Controller;

import Controller.Helper.MenuRelatorioHelper;
import Model.DAO.SorteioDAO;
import Model.Exception.ParticipanteException;
import Model.Exception.SorteioException;
import Model.Sorteio;
import View.MenuRelatorio;
import java.awt.event.MouseEvent;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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

    public void atualizarTabela() {
        // Limpe os dados existentes na tabela
        tableModel.setRowCount(0);

        try {
            // Obtenha os últimos sorteios da sorteioDAO
            SorteioDAO sorteioDAO = new SorteioDAO();
            List<Sorteio> ultimosSorteios = sorteioDAO.obterUltimosSorteios(10);

            // Atualize a tabela com os dados obtidos
            for (Sorteio sorteio : ultimosSorteios) {
                Object[] rowData = {sorteio.getParticipante().getNome(), sorteio.getParticipante().getBairro(), sorteio.getDataSorteio(), sorteio.getLocutor().getNome()};
                tableModel.addRow(rowData);
            }
        } catch (SorteioException e) {
            view.mensagemErro(e.getMessage());
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

}
