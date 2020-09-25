import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LojaVirtualTest {

    private static final double DELTA = 0;

    private Produto produto1;
    private Livro livro1;
    private Roupa roupa1;
    private LojaVirtual lojinha1;

    @Before
    public void setUp() {
        produto1 = new Produto("Lápis", 0.65);
        livro1 = new Livro("Romeu e Julieta", "Shakespeare", 1597, 160, 24);
        roupa1 = new Roupa('m', 19.50);
        lojinha1 = new LojaVirtual();
    }

    @Test
    public void testarAdicaoProduto() {

        lojinha1.incluirProdutoNoEstoque(produto1, 1);
        Assert.assertEquals(1, lojinha1.getTamanhoEstoque());
        Assert.assertEquals(1, lojinha1.getTamanhoEstoque(produto1));
        Assert.assertEquals("Lápis", produto1.getCategoria());

        lojinha1.incluirProdutoNoEstoque(livro1, 2);
        Assert.assertEquals(3, lojinha1.getTamanhoEstoque());
        Assert.assertEquals(2, lojinha1.getTamanhoEstoque(livro1));
        Assert.assertEquals("Publicações", livro1.getCategoria());

        lojinha1.incluirProdutoNoEstoque(produto1, 2);
        Assert.assertEquals(5, lojinha1.getTamanhoEstoque());
        Assert.assertEquals(3, lojinha1.getTamanhoEstoque(produto1));
        Assert.assertEquals("Vestuário", roupa1.getCategoria());
    }

    @Test
    public void testarVendaDeProdutos() {
        lojinha1.incluirProdutoNoEstoque(produto1, 2);
        Assert.assertEquals("ID = 1 - Categoria = Lápis - Quantidade = 2 - Preço = 0.65 - Preço Total = 1.3",
                lojinha1.efetuarVenda(produto1, 2));
        lojinha1.efetuarVenda(produto1, 2);
        Assert.assertEquals(0, lojinha1.getTamanhoEstoque(produto1));
        Assert.assertEquals(1.3, lojinha1.getTotalValorVendas(), DELTA);

        lojinha1.incluirProdutoNoEstoque(roupa1, 3);
        lojinha1.efetuarVenda(roupa1, 1);
        Assert.assertEquals(20.8, lojinha1.getTotalValorVendas(), DELTA);

        lojinha1.incluirProdutoNoEstoque(livro1, 1);
        lojinha1.efetuarVenda(livro1, 1);
        Assert.assertEquals(44.8, lojinha1.getTotalValorVendas(), DELTA);
    }
}