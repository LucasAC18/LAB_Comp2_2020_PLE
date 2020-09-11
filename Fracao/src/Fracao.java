import java.util.Objects;

public class Fracao {

    private int numerador;
    private int denominador;
    private boolean positiva;
    private int sinal;
    private boolean nula;

    /**
     * Construtor.
     * O sinal da fração é passado no parâmetro específico.
     *
     * @param numerador O numerador (inteiro não-negativo)
     * @param denominador O denominador (inteiro positivo)
     * @param positiva se true, a fração será positiva; caso contrário, será negativa
     */
    public Fracao(int numerador, int denominador, boolean positiva) {
        this.numerador = numerador;
        if (numerador == 0) {
            nula = true;
        } else {
            nula = false;
        }
        this.denominador = denominador;
        this.positiva = positiva;
        if (positiva) {
            this.sinal = 1;
        } else {
            this.sinal = -1;
        }
    }

    /**
     * @return um double com o valor numérico desta fração
     */
    public double getValorNumerico() {
            return sinal*((double)this.numerador/this.denominador);
    }

    /**
     * Retorna uma fração que é equivalente a esta fração (this),
     * e que é irredutível (numerador e denominador primos entre si).
     * Em outras palavras, retorna a fração geratriz desta fração.
     *
     * @return uma fração irredutível equivalente a esta;
     *         no caso desta fração JÁ SER ela própria irredutível, retorna this
     */
    public Fracao getFracaoGeratriz() {
        int mdc = mdc(this.numerador, this.denominador);
        if (mdc == 1) {
            return this;
        } else {
            int novoNumerador = this.numerador / mdc;
            int novoDenominador = this.denominador / mdc;
            return new Fracao(novoNumerador, novoDenominador, this.positiva);
        }
    }

    public int getNumerador() {
        return this.numerador;
    }

    public int getDenominador() {
        return this.denominador;
    }

    public boolean isPositiva() {
        if (nula) {
            return false;
        }
        return this.positiva;
    }

    private int mdc (int numerador, int denominador) {
        int resto;
        int a = numerador;
        int b = denominador;
        while (b != 0) {
            resto = a % b;
            a = b;
            b = resto;
        }
        return a;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fracao fracao = (Fracao) o;
        if (nula) return true;
        return this.getFracaoGeratriz().getNumerador() == fracao.getFracaoGeratriz().numerador &&
                this.getFracaoGeratriz().getDenominador() == fracao.getFracaoGeratriz().denominador &&
                this.getFracaoGeratriz().isPositiva() == fracao.getFracaoGeratriz().positiva;

    }
}
