package Model;

public class Item {

    private Integer id;
    private String descricao;

    public Item(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Item(String descricao) {
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
