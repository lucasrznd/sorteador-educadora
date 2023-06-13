package Controller;

import Controller.Helper.MenuPrincipalHelper;
import Model.DAO.ParticipanteDAO;
import Model.DAO.SorteioDAO;
import Model.Exception.ParticipanteException;
import Model.Exception.SorteioException;
import Model.Participante;
import Model.Sorteio;
import View.MenuPrincipal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class MenuPrincipalController {

    private final MenuPrincipal view;
    private final MenuPrincipalHelper helper;
    private final DefaultTableModel tableModel;

    public MenuPrincipalController(MenuPrincipal view) {
        this.view = view;
        this.helper = new MenuPrincipalHelper(view);
        this.tableModel = helper.obterTabela();
    }

    public void adicionarNomeBairro() {
        Participante participante = helper.obterParticipante();

        if (participante.getNome().isEmpty() || participante.getBairro().isEmpty()) {
            view.mensagemSimples("Por favor, preencha todos os campos.");
            return;
        }

        // Verificar se o nome e bairro já existem na tabela
        if (isNomeBairroRepetido(participante.getNome(), participante.getBairro())) {
            view.mensagemErro("Nome e bairro já existem na tabela!");
            return;
        }

        tableModel.addRow(new Object[]{participante.getNome(), participante.getBairro()});
        view.getFieldNome().setText("");
        view.getFieldBairro().setText("");
    }

    public boolean isNomeBairroRepetido(String nome, String bairro) {
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            String nomeTabela = (String) tableModel.getValueAt(i, 0);
            String bairroTabela = (String) tableModel.getValueAt(i, 1);

            if (nomeTabela.equals(nome) && bairroTabela.equals(bairro)) {
                return true;
            }
        }
        return false;
    }

    public void limparTabela() {
        tableModel.setRowCount(0);
    }

    public void importarTabela() {
        if (tableModel.getRowCount() > 0) {
            view.mensagemAviso("Os dados já foram importados.");
            return;
        } else {
            try {
                // Obter os nomes e bairros da tabela "participantes" do banco de dados
                ParticipanteDAO participanteDAO = new ParticipanteDAO();
                List<Participante> participantes = participanteDAO.obterParticipantes();

                // Adicionar os nomes e bairros à jTable
                for (Participante participante : participantes) {
                    tableModel.addRow(new Object[]{participante.getNome(), participante.getBairro()});
                }
            } catch (ParticipanteException e) {
                view.mensagemErro(e.getMessage());
            }
        }
    }

    public void insertParticipante() {
        ParticipanteDAO participanteDAO = new ParticipanteDAO();

        if (tableModel.getRowCount() <= 0) {
            view.mensagemErro("Informe o(s) participante(s)!");
        } else {
            try {
                participanteDAO.verificarDuplicidade(tableModel);
                participanteDAO.insert(tableModel);
                view.mensagemSimples("Participante(s) inserido(s) com sucesso!");
            } catch (ParticipanteException e) {
                e.printStackTrace();
                view.mensagemErro("Error: " + e.getMessage());
            }
        }
    }

    public void insertSorteio() {
        StringBuilder nomesBairrosSorteados = new StringBuilder();
        int quantidadeSorteados = view.getQtdParticipantes();

        if (quantidadeSorteados <= 0) {
            view.mensagemErro("Informe uma quantidade válida.");
        } else if (tableModel.getRowCount() <= 0) {
            view.mensagemErro("A tabela está vazia.");
        } else {
            try {
                for (int i = 0; i < quantidadeSorteados; i++) {
                    SorteioDAO sorteioDAO = new SorteioDAO();
                    Sorteio sorteio = obterSorteio();
                    sorteioDAO.insert(sorteio);
                    String nomeSorteado = sorteio.getParticipante().getNome();
                    String bairroSorteado = sorteio.getParticipante().getBairro();
                    nomesBairrosSorteados.append("Nome: ").append(nomeSorteado).append(", Bairro: ").append(bairroSorteado).append("\n");
                }
                view.mensagemSimples("Sorteio realizado com sucesso!");
                view.mensagemSorteio("Pessoa(s) sorteada(s):\n" + nomesBairrosSorteados.toString());
            } catch (SorteioException e) {
                e.printStackTrace();
                view.mensagemErro("Error: " + e.getMessage());
            }
        }
    }

    public Sorteio obterSorteio() {
        int qtdParticipantes = view.getQtdParticipantes();
        List<Participante> participantes = helper.obterParticipantesDaTabela();

        try {
            if (qtdParticipantes > participantes.size()) {
                view.mensagemErro("Quantidade informada maior do que o número de participantes.");
            }

            // Realizar o sorteio
            Collections.shuffle(participantes);
            List<Participante> sorteados = participantes.subList(0, qtdParticipantes);

            Participante participanteSorteado = sorteados.get(0);
            LocalDateTime dataSorteio = LocalDateTime.now();
            Sorteio sorteio = new Sorteio(participanteSorteado, dataSorteio);

            return sorteio;
        } catch (IndexOutOfBoundsException e) {
            view.mensagemErro("Não há participantes suficientes para realizar o sorteio.");
            return null;
        }
    }

    public String printSorteio(List<Sorteio> ultimosSorteios) {
        StringBuilder sb = new StringBuilder();

        sb.append("Últimos Sorteios:\n");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        for (Sorteio sorteio : ultimosSorteios) {
            sb.append("Nome: ").append(sorteio.getParticipante().getNome()).append("\n");
            sb.append("Data e Hora: ").append(sorteio.getDataSorteio().format(formatter)).append("\n\n");
        }
        return sb.toString();
    }

    public void ultimoSorteados() {
        SorteioDAO sorteioDAO = new SorteioDAO();
        try {
            String ultimoSorteios = printSorteio(sorteioDAO.obterUltimosSorteios(view.getQtdParticipantes()));
            view.mensagemUltimosSorteio(ultimoSorteios);
        } catch (SorteioException e) {
            e.printStackTrace();
            view.mensagemErro("Error: " + e.getMessage());
        }
    }
}
