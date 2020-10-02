import java.util.Objects;

public class Hashtag {

    private final String texto;
    private int quantidade;

    public Hashtag(String texto) {
        this.texto = texto;
        this.quantidade = 1;
    }

    public String getTexto() {
        return this.texto;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public void incrementarQuantidade() {
        this.quantidade++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hashtag hashtag = (Hashtag) o;
        return quantidade == hashtag.quantidade &&
                Objects.equals(texto, hashtag.texto);
    }
}
