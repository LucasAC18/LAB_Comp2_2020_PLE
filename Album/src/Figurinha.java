public class Figurinha {

    private int posicao;
    private String urlImagem;
    private int quantRepetidas;

    public Figurinha(int posicao, String urlImagem) {
        this.posicao = posicao;
        this.urlImagem = urlImagem;
        this.quantRepetidas = 0;
    }

    /**
     * Indica a posição, no álbum, que esta figurinha deve ocupar.
     *
     * @return Um int dizendo a posição da figurinha
     */
    public int getPosicao() {
        return this.posicao;
    }

    /**
     * Retorna a URL de onde a imagem associada a esta figurinha deverá ser baixada.
     *
     * @return uma String com o endereço desejado
     */
    public String getUrlImagem() {
        return this.urlImagem;
    }

    public int getQuantRepetidas() {
        return this.quantRepetidas;
    }

    public void adicionarRepetidas() {
        this.quantRepetidas++;
    }
}


