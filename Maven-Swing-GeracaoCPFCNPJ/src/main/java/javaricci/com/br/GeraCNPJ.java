package javaricci.com.br;

import javax.swing.text.MaskFormatter;
import java.text.ParseException;
import java.util.ArrayList;

public class GeraCNPJ {
    private ArrayList<Integer> listaAleatoria = new ArrayList<>();

    public int geraNumAleatorio() {
        return (int) (Math.random() * 10);
    }

    public ArrayList<Integer> geraCNPJParcial() {
        listaAleatoria.clear();
        for (int i = 0; i < 12; i++) listaAleatoria.add(geraNumAleatorio());
        return listaAleatoria;
    }

    public ArrayList<Integer> geraDigito() {
        int totalSomatoria = 0;
        int restoDivisao;

        int[] pesosPrimeiro = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        for (int i = 0; i < pesosPrimeiro.length; i++) {
            totalSomatoria += listaAleatoria.get(i) * pesosPrimeiro[i];
        }

        restoDivisao = totalSomatoria % 11;
        int primeiroDigito = restoDivisao < 2 ? 0 : 11 - restoDivisao;
        listaAleatoria.add(primeiroDigito);

        totalSomatoria = 0;
        int[] pesosSegundo = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        for (int i = 0; i < pesosSegundo.length; i++) {
            totalSomatoria += listaAleatoria.get(i) * pesosSegundo[i];
        }

        restoDivisao = totalSomatoria % 11;
        int segundoDigito = restoDivisao < 2 ? 0 : 11 - restoDivisao;
        listaAleatoria.add(segundoDigito);

        return listaAleatoria;
    }

    public String geraCNPJFim() {
        try {
            geraCNPJParcial();
            geraDigito();

            StringBuilder texto = new StringBuilder();
            for (int item : listaAleatoria) texto.append(item);

            MaskFormatter mf = new MaskFormatter("##.###.###/####-##");
            mf.setValueContainsLiteralCharacters(false);

            return mf.valueToString(texto.toString());
        } catch (ParseException e) {
            return "Erro ao gerar CNPJ.";
        }
    }
}
