package Controller.Helper;

import Model.EmpresaReferencia;
import Model.Item;
import Model.Participante;
import View.MenuPrincipal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

public class MenuPrincipalHelper {

    private final MenuPrincipal view;

    public MenuPrincipalHelper(MenuPrincipal view) {
        this.view = view;
    }

    public Participante obterParticipante() {
        String nome = view.getFieldNome().getText();
        String bairro = view.getFieldBairro().getText();

        Participante participante = new Participante(nome, bairro);
        return participante;
    }

    public void setarParticipante(Participante participante) {
        String nome = participante.getNome();
        String bairro = participante.getBairro();

        view.getFieldNome().setText(nome);
        view.getFieldBairro().setText(bairro);
    }

    public void limparCampos() {
        view.getFieldNome().setText("");
        view.getFieldBairro().setText("");
    }

    public DefaultTableModel obterTabela() {
        DefaultTableModel tableModel = (DefaultTableModel) view.getTabelaSorteio().getModel();
        return tableModel;
    }

    public List<Participante> obterParticipantesDaTabela() {
        List<Participante> participantes = new ArrayList<>();

        DefaultTableModel tableModel = (DefaultTableModel) view.getTabelaSorteio().getModel();

        int rowCount = tableModel.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            String nome = (String) tableModel.getValueAt(i, 0);
            String bairro = (String) tableModel.getValueAt(i, 1);

            Participante participante = new Participante(nome, bairro);
            participantes.add(participante);
        }
        return participantes;
    }

    public String obterNomeLocutor(JComboBox comboBox) {
        String nomeLocutor = (String) comboBox.getSelectedItem();
        return nomeLocutor;
    }

    public String obterQuantidadeCombo(JComboBox comboBox) {
        String quantidade = (String) comboBox.getSelectedItem();
        if (quantidade != null) {
            return quantidade;
        } else {
            return "0";
        }
    }

    public String obterItem(JComboBox comboBox) {
        String descricao = (String) comboBox.getSelectedItem();
        return descricao;
    }

    public String obterEmpresa(JComboBox comboBox) {
        String nome = (String) comboBox.getSelectedItem();
        return nome;
    }

}
