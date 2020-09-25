public class Livro extends Produto {

    private final String titulo;
    private final String autor;
    private final int anoDePublicacao;
    private final int numeroDePaginas;

    public Livro(String titulo, String autor, int anoDePublicacao, int numeroDePaginas, float preçoLivro) {
        super("Publicações", preçoLivro);
        this.titulo = titulo;
        this.autor = autor;
        this.anoDePublicacao = anoDePublicacao;
        this.numeroDePaginas = numeroDePaginas;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", anoDePublicacao=" + anoDePublicacao +
                ", numeroDePaginas=" + numeroDePaginas +
                '}';
    }
}
