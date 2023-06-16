package Controller.Helper;

import View.MenuRelatorio;
import javax.swing.table.DefaultTableModel;

public class MenuRelatorioHelper {
    
    private MenuRelatorio view;

    public MenuRelatorioHelper(MenuRelatorio view) {
        this.view = view;
    }
    
    public DefaultTableModel obterTabela() {
        DefaultTableModel tableModel = (DefaultTableModel) view.getjTable().getModel();
        return tableModel;
    } 
}
