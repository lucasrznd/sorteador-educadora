package Model;

public class Participante {

    private Integer id;
    private String nome;
    private String bairro;
    private String celular;

    public Participante() {

    }

    public Participante(String nome, String bairro) {
        this.nome = nome;
        this.bairro = bairro;
    }

    public Participante(String nome, String bairro, String celular) {
        this.nome = nome;
        this.bairro = bairro;
        this.celular = celular;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    @Override
    public String toString() {
        return "Participante{" + "nome=" + nome + ", bairro=" + bairro + '}';
    }
}
