package Model;

import java.time.LocalDateTime;

public class Sorteio {

    private Integer id;
    private Participante participante;
    private LocalDateTime dataSorteio;
    private Locutor locutor;
    private Brinde brinde;
    private EmpresaReferencia empresaReferencia;

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

    public Sorteio(Participante participante, LocalDateTime dataSorteio, Locutor locutor, Brinde brinde, EmpresaReferencia empresaReferencia) {
        this.participante = participante;
        this.dataSorteio = dataSorteio;
        this.locutor = locutor;
        this.brinde = brinde;
        this.empresaReferencia = empresaReferencia;
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

    public Locutor getLocutor() {
        return locutor;
    }

    public void setLocutor(Locutor locutor) {
        this.locutor = locutor;
    }

    public Brinde getBrinde() {
        return brinde;
    }

    public void setBrinde(Brinde brinde) {
        this.brinde = brinde;
    }

    public EmpresaReferencia getEmpresaReferencia() {
        return empresaReferencia;
    }

    public void setEmpresaReferencia(EmpresaReferencia empresaReferencia) {
        this.empresaReferencia = empresaReferencia;
    }

    @Override
    public String toString() {
        return "Sorteio{" + "participante=" + participante + ", dataSorteio=" + dataSorteio + '}';
    }
}
