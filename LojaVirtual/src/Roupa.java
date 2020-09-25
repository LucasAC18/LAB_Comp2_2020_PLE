public class Roupa extends Produto {

    private final char tamanho;
    private String cor;

    public Roupa(char tamanho, double preçoRoupa) {
        super("Vestuário", preçoRoupa);
        this.tamanho = tamanho;
    }

    @Override
    public String toString() {
        return "Roupa{" +
                "tamanho=" + tamanho +
                ", cor='" + cor + '\'' +
                '}';
    }
}
