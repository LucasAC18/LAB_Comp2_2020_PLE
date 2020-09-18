public class Album {

    public static final float PREENCHIMENTO_MINIMO_PARA_PERMITIR_AUTO_COMPLETAR = 0.9f;  // 90%
    private int totalPacotinhosRecebidos;
    private int totalFigurinhas;
    private int quantFigurinhasPorPacotinho;
    private int quantFigurinhasColadas;
    private int quantFigurinhasRepetidas;
    private boolean albumTamanho[];
    private int figurinhasRepetidas[];



    public Album(int totalFigurinhas, int quantFigurinhasPorPacotinho) {
        this.totalFigurinhas = totalFigurinhas;
        this.quantFigurinhasPorPacotinho = quantFigurinhasPorPacotinho;
        this.totalPacotinhosRecebidos = 0;
        this.quantFigurinhasColadas = 0;
        this.quantFigurinhasRepetidas = 0;
        this.albumTamanho = new boolean[totalFigurinhas + 1];
        this.figurinhasRepetidas = new int[totalFigurinhas + 1];
    }

    public void receberNovoPacotinho(Figurinha[] pacotinho) {
        totalPacotinhosRecebidos++;
        for (int i = 0; i < pacotinho.length; i++) {
            Figurinha figurinha = pacotinho[i];
            if (!albumTamanho[figurinha.getPosicao()]) {
                albumTamanho[figurinha.getPosicao()] = true;
                this.quantFigurinhasColadas++;
            } else {
                this.quantFigurinhasRepetidas++;
                figurinhasRepetidas[figurinha.getPosicao()]++;
            }
        }
    }

    public int getTotalPacotinhosRecebidos() {
        return this.totalPacotinhosRecebidos;
    }

    /**
     * Termina de preencher o álbum, desde que ele já esteja preenchido além de certa fração
     * mínima definida em Album.PREENCHIMENTO_MINIMO_PARA_PERMITIR_AUTO_COMPLETAR.
     *
     * Se o álbum não estiver ainda completo o suficiente para isso, este método simplesmente
     * não faz nada.
     */
    public void encomendarFigurinhasRestantes() {
        if (quantFigurinhasColadas >= totalFigurinhas * PREENCHIMENTO_MINIMO_PARA_PERMITIR_AUTO_COMPLETAR) {
            this.quantFigurinhasColadas = totalFigurinhas;
            for (int i = 0; i < totalFigurinhas; i++) {
                if (!albumTamanho[i]) albumTamanho[i] = true;
            }
        }
    }

    public boolean possuiFigurinhaColada(int posicao) {
        return albumTamanho[posicao];
    }

    public boolean possuiFigurinhaColada(Figurinha figurinha) {  // overload
        return possuiFigurinhaColada(figurinha.getPosicao());
    }

    public boolean possuiFigurinhaRepetida(int posicao) {
        if (albumTamanho[posicao] == true) {
            if (figurinhasRepetidas[posicao] > 0) return true;
        }
        return false;
    }

    public boolean possuiFigurinhaRepetida(Figurinha figurinha) {  // overload
        return possuiFigurinhaRepetida(figurinha.getPosicao());
    }

    public int getQuantFigurinhasColadas() {
        return this.quantFigurinhasColadas;
    }

    public int getQuantFigurinhasRepetidas() {
        return this.quantFigurinhasRepetidas;
    }

    public int getQuantFigurinhasFaltando() {
        return quantFigurinhasColadas - totalFigurinhas;
    }

}
