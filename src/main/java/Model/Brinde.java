package Model;

public class Brinde {

    private Integer id;
    private EmpresaReferencia empresaReferencia;
    private Item item;
    private String quantidade;

    public Brinde(Integer id, EmpresaReferencia empresaReferencia, Item item) {
        this.id = id;
        this.empresaReferencia = empresaReferencia;
        this.item = item;
    }

    public Brinde() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EmpresaReferencia getEmpresaReferencia() {
        return empresaReferencia;
    }

    public void setEmpresaReferencia(EmpresaReferencia empresaReferencia) {
        this.empresaReferencia = empresaReferencia;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    } 
}
