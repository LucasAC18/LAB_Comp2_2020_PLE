import java.util.HashSet;
import java.util.List;

public class CalculadorIntersecaoEsperto extends CalculadorIntersecao<Integer> {

// Método 1
    @Override
    public int getQuantidadeElementosEmComum(List<Integer> lista1, List<Integer> lista2) {

        HashSet<Integer> conjunto2 = new HashSet<>(lista2);
        int cont = 0;

        for (Integer elemento : lista1) {
            if (conjunto2.contains(elemento)) cont++;
        }

        return cont;
    }

// Método 2
//    @Override
//    public int getQuantidadeElementosEmComum(List<Integer> lista1, List<Integer> lista2) {
//
//        HashSet<Integer> conjunto1 = new HashSet<>(lista1);
//        HashSet<Integer> conjunto2 = new HashSet<>(lista2);
//
//        conjunto1.retainAll(conjunto2);
//        return conjunto1.size();
//
//    }


}
