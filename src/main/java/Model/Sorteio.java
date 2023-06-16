package Model;

import java.time.LocalDateTime;

public class Sorteio {

    private Integer id;
    private Participante participante;
    private LocalDateTime dataSorteio;

    public Sorteio() {

    }

    public Sorteio(Integer id, Participante participante, LocalDateTime dataSorteio) {
        this.id = id;
        this.participante = participante;
        this.dataSorteio = dataSorteio;
    }

    public Sorteio(Participante participante, LocalDateTime dataSorteio) {
        this.participante = participante;
        this.dataSorteio = dataSorteio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public LocalDateTime getDataSorteio() {
        return dataSorteio;
    }

    public void setDataSorteio(LocalDateTime dataSorteio) {
        this.dataSorteio = dataSorteio;
    }

    @Override
    public String toString() {
        return "Sorteio{" + "participante=" + participante + ", dataSorteio=" + dataSorteio + '}';
    }
}
