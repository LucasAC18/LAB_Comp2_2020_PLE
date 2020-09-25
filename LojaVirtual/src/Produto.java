public class Produto {

    private static long nextSeqNum = 1;

    protected final long id;
    private int pesoEmGramas;
    private double preçoEmReais;
    private String categoria;
    private int quantidadeEmEstoque;

    public Produto(String categoria, double preçoEmReais) {
        this.id = nextSeqNum++;
        this.categoria = categoria;
        this.preçoEmReais = preçoEmReais;
        this.quantidadeEmEstoque = 0;
    }

    public int getQuantidadeEmEstoque() {
        return this.quantidadeEmEstoque;
    }

    public void adicionarQuantidadeEmEstoque(int quantidade) {
        this.quantidadeEmEstoque += quantidade;
    }

    public double getPreçoEmReais() {
        return this.preçoEmReais;
    }

    public void removerProdutoEstoque(int quantidade) {
        this.quantidadeEmEstoque -= quantidade;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public long getId(){
        return this.id;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", preçoEmReais=" + preçoEmReais +
                ", categoria='" + categoria + '\'' +
                '}';
    }
}
