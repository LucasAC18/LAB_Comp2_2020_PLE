public class LojaVirtual {

    private int tamanhoEstoque;
    private double totalValorVendas;

    public LojaVirtual() {
        this.tamanhoEstoque = 0;
        this.totalValorVendas = 0;
    }

    public int getTamanhoEstoque() {
        return tamanhoEstoque;
    }

    public int getTamanhoEstoque(Produto produto) {
        return produto.getQuantidadeEmEstoque();
    }

    public void incluirProdutoNoEstoque(Produto produto, int quantidade) {
        produto.adicionarQuantidadeEmEstoque(quantidade);
        this.tamanhoEstoque += quantidade;
    }

    public String efetuarVenda(Produto produto, int quantidade) {
        if (produto.getQuantidadeEmEstoque() < quantidade) {
            return null; //lançar uma exceção
        }
        receberPagamento(produto.getPreçoEmReais()*quantidade);
        produto.removerProdutoEstoque(quantidade);
        this.tamanhoEstoque -= quantidade;
        return "ID = " + produto.getId() +
                " - Categoria = " + produto.getCategoria() +
                " - Quantidade = " + quantidade +
                " - Preço = " + produto.getPreçoEmReais() +
                " - Preço Total = " + (produto.getPreçoEmReais()*quantidade);
    }

    public double getTotalValorVendas() {
        return this.totalValorVendas;
    }

    private boolean receberPagamento(double valor) {
        this.totalValorVendas += valor;
        return true;    //considerando que o pagamento sempre será efetivado
    }
}
