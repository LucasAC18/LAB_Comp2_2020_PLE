import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 *  Esta classe implementa um sistema de mensagens curtas estilo Twitter.
 *  É preciso cadastrar um usuário, identificado pelo seu e-mail, para que tuítes possam ser feitos.
 *  Usuários começam como iniciantes, depois são promovidos a senior e a ninja, em função do número de tuítes.
 *  Existe um tamanho máximo permitido por mensagem (constante TAMANHO_MAXIMO_TUITES).
 *  As mensagens podem conter hashtags (palavras iniciadas por #), que são detectadas automaticamente.
 *  Os tuítes podem conter, além da mensagem de texto, um anexo qualquer.
 *  Há um método para retornar, a qualquer momento, qual a hashtag mais usada em toda a história do sistema.
 */
public class TuiterLite<T> {

    public static final int TAMANHO_MAXIMO_TUITES = 120;
    private HashSet<Usuario> usuariosCadastrados = new HashSet<>();
    private HashMap<String,Hashtag> hashtagsNoSistema = new HashMap<>();

    private Hashtag hashtagMaisPopular;
    private int maiorQuantidade = 0;

    /**
     * Cadastra um usuário, retornando o novo objeto Usuario criado.
     * Se o email informado já estiver em uso, não faz nada e retorna null.
     * @param nome O nome do usuário.
     * @param email O e-mail do usuário (precisa ser único no sistema).
     * @return O Usuario criado.
     */
    public Usuario cadastrarUsuario(String nome, String email) {
        Usuario usuariocriado = new Usuario(nome, email);
        if (usuariosCadastrados.contains(usuariocriado)) {
            return null;
        }
        usuariosCadastrados.add(usuariocriado);
        return usuariocriado;
    }

    /**
     * Tuíta algo, retornando o objeto Tuíte criado.
     * Se o tamanho do texto exceder o limite pré-definido, não faz nada e retorna null.
     * Se o usuário não estiver cadastrado, não faz nada e retorna null.
     *
     * @param usuario O autor do tuíte
     * @param texto O texto desejado
     * @return Um "tuíte", que será devidamente publicado no sistema
     */
    public Tuite tuitarAlgo(Usuario usuario, String texto) throws TamanhoExcedidoException, UsuarioInexistenteException {
        if (texto.length() > TAMANHO_MAXIMO_TUITES) {
            throw new TamanhoExcedidoException();
        } else if (!(usuariosCadastrados.contains(usuario))) {
            throw new UsuarioInexistenteException();
        }
        Tuite tuite = new Tuite(usuario, texto);
        usuario.incrementarQuantTuites();
        atualizarHashtagsPostadas(tuite.getHashtagscontidas());
        return tuite;
    }

    /**
     * Retorna a hashtag mais comum dentre todas as que já apareceram.
     * A cada tuíte criado, hashtags devem ser detectadas automaticamente para que este método possa funcionar.
     * @return A hashtag mais comum, ou null se nunca uma hashtag houver sido tuitada.
     */
    public String getHashtagMaisComum() {
        for (Hashtag hashtagT : hashtagsNoSistema.values()) {
            if (hashtagT.getQuantidade() >= maiorQuantidade) {
                maiorQuantidade = hashtagT.getQuantidade();
                hashtagMaisPopular = hashtagT;
            }
        }
        return hashtagMaisPopular.getTexto();
    }

    private void atualizarHashtagsPostadas(ArrayList<Hashtag> listaDeTags) {
        for (Hashtag hashtagT : listaDeTags) {
            if (hashtagsNoSistema.containsKey(hashtagT.getTexto())) {
                hashtagsNoSistema.get(hashtagT.getTexto()).incrementarQuantidade();
            } else {
                hashtagsNoSistema.put(hashtagT.getTexto(), hashtagT);
            }
        }
    }



    // Mainzinho bobo, apenas ilustrando String.split(regexp), e o String.startsWith()

//    public static void main(String[] args) {
//        String frase = "Testando algo,sdf com #hashtags no meio #teste vamos ver!fdfgf";
//        String[] palavras = frase.split("[\\s,!]");
//        for (String palavra : palavras) {
//            if (palavra.startsWith("#")) {
//                System.out.println(palavra);
//            }
//        }
//    }
}
