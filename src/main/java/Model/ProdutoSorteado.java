package Model;

public class ProdutoSorteado {
    
    private Integer id;
    private String descricao;

    public ProdutoSorteado(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public ProdutoSorteado(String descricao) {
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
