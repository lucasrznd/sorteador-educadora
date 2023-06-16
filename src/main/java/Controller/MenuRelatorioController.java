package Controller;

import Controller.Helper.MenuRelatorioHelper;
import Model.DAO.SorteioDAO;
import Model.Exception.ParticipanteException;
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
                        sorteio.getDataSorteio(), sorteio.getLocutor().getNome()});
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

}
