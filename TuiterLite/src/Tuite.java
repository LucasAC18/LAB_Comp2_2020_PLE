import java.util.ArrayList;

public class Tuite<T> {

    private final Usuario autor;
    private final String texto;
    private T anexo;
    private ArrayList<Hashtag> hashtagscontidas = new ArrayList();

    // hashtags?
    // objeto anexado?

    public Tuite(Usuario autor, String texto) {
        this.autor = autor;
        this.texto = texto;
        this.encontrarHashtags(texto);
    }

    public void anexarAlgo(T anexo) {
        this.anexo = anexo;
    }

    private void encontrarHashtags (String texto) {
        String[] tags = texto.split(" ");
        for (String palavra : tags) {
            if (palavra.startsWith("#")) {
                Hashtag tag = new Hashtag(palavra);
                if (hashtagscontidas.contains(tag)) {
                    hashtagscontidas.get(hashtagscontidas.indexOf(tag)).incrementarQuantidade();
                } else {
                    hashtagscontidas.add(tag);
                }
            }
        }
    }


    public Object getAnexo() { return this.anexo; }

    public Usuario getAutor() {
        return this.autor;
    }

    public String getTexto() {
        return this.texto;
    }

    public ArrayList<Hashtag> getHashtagscontidas() {
        return  this.hashtagscontidas;
    }

    public ArrayList<String> getHashtags() {
        ArrayList<String> stringHashtags = new ArrayList();
        for (Hashtag hashtagT : hashtagscontidas) {
            stringHashtags.add(hashtagT.getTexto());
        }
        return stringHashtags;
    }
}
