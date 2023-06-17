package Model;

public class EmpresaReferencia {

    private Integer id;
    private String nome;
    
    public EmpresaReferencia() {
        
    }

    public EmpresaReferencia(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public EmpresaReferencia(String nome) {
        this.nome = nome;
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
}
