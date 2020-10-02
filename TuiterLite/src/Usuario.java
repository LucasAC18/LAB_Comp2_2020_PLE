import java.awt.*;
import java.util.Objects;

public class Usuario {

    public static final int MIN_TUITES_SENIOR = 200;
    public static final int MIN_TUITES_NINJA = 1000;

    private final String email;
    private String nome;
    private Image foto;

    // Pode ser INICIANTE, SENIOR ou NINJA
    private NivelUsuario nivel;

    private int quantTuites = 0;

    public Usuario(String nome, String email) {
        this.email = email;
        this.nome = nome;
        this.nivel = NivelUsuario.INICIANTE;
    }

    public void incrementarQuantTuites() {
        this.quantTuites++;
        if (quantTuites >= MIN_TUITES_SENIOR) this.nivel = NivelUsuario.SENIOR;
        if (quantTuites >= MIN_TUITES_NINJA) this.nivel = NivelUsuario.NINJA;
    }

    public void setFoto(Image foto) {
        this.foto = foto;
    }

    public Image getFoto() {
        return this.foto;
    }

    public String getEmail() {
        return this.email;
    }

    public String getNome() {
        return this.nome;
    }

    public NivelUsuario getNivel() {
        return nivel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(email, usuario.email);
    }
}
