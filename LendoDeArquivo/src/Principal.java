import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        boolean arquivoExiste = false;

        while (!arquivoExiste) {
            try {
                Scanner scanner = new Scanner(System.in);
                String nomeArquivo = scanner.nextLine();
                System.out.println(String.format("Média das notas: %.2f", LeitorArquivosUtils.calcularMedia(nomeArquivo)));
                arquivoExiste = true;
            } catch (ArquivoCorrompidoException e) {
                System.out.println("Arquivo corrompido");
                System.out.println(String.format("Quantidade de linhas erradas: %d", e.getLinhasCorrompidas()));
                arquivoExiste = true;
            } catch (FileNotFoundException e) {
                System.out.println("Arquivo específicado não existe");
            }
        }


    }
}
