import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LeitorArquivosUtils {

    public static float calcularMedia(String nomeArquivo) throws FileNotFoundException, ArquivoCorrompidoException {

        float valorTotal = 0;
        int quantNotas = 0;
        int contLinhasInválidas = 0;

        File arquivo = new File(nomeArquivo);
        Scanner scanner = new Scanner(arquivo);

        while (scanner.hasNext()) {
            try {
                float valor = Float.valueOf(scanner.nextLine());
                if (valor > 10 || valor < 0) {
                    throw new NumberFormatException();
                }
                valorTotal += valor;
                quantNotas++;
            } catch (NumberFormatException e) {
                contLinhasInválidas++;
            }
        }

        if (contLinhasInválidas > quantNotas) {
            throw new ArquivoCorrompidoException(contLinhasInválidas);
        }

        return quantNotas == 0 ? 0 : valorTotal/quantNotas;
    }

}
