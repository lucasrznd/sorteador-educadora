package View;

import Model.DAO.ParticipanteDAO;
import Model.DAO.SorteioDAO;
import Model.Participante;
import Model.Sorteio;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Teste {

    public static void main(String[] args) {

        //DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        //LocalDateTime now = LocalDateTime.now();
        // fmt.format(now);
        // Participante participante = new Participante("Carlos Ribeiro", "Bairro São Oliva");
        //ParticipanteDAO participanteDAO = new ParticipanteDAO();
        SorteioDAO sorteioDAO = new SorteioDAO();
        List<Sorteio> ultimosSorteios = sorteioDAO.obterUltimosSorteios(5);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

// Exemplo de iteração e impressão dos sorteios
        for (Sorteio sorteio : ultimosSorteios) {
            System.out.println("Nome do ganhador: " + sorteio.getParticipante().getNome());
            System.out.println("Data do sorteio: " + formatter.format(sorteio.getDataSorteio()));
            System.out.println("--------------------");
        }

    }

}
