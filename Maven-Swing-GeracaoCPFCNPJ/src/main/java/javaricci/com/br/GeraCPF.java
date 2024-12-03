package javaricci.com.br;

import javax.swing.text.MaskFormatter;
import java.text.ParseException;
import java.util.ArrayList;

public class GeraCPF {
    private ArrayList<Integer> listaAleatoria = new ArrayList<>();

    public int geraNumAleatorio() {
        return (int) (Math.random() * 10);
    }

    public ArrayList<Integer> geraCPFParcial() {
        listaAleatoria.clear();
        for (int i = 0; i < 9; i++) listaAleatoria.add(geraNumAleatorio());
        return listaAleatoria;
    }

    public ArrayList<Integer> geraDigito() {
        int totalSomatoria = 0;
        int restoDivisao;
        int peso = 10;

        for (int item : listaAleatoria) totalSomatoria += item * peso--;
        restoDivisao = totalSomatoria % 11;
        int primeiroDigito = restoDivisao < 2 ? 0 : 11 - restoDivisao;
        listaAleatoria.add(primeiroDigito);

        totalSomatoria = 0;
        peso = 11;
        for (int item : listaAleatoria) totalSomatoria += item * peso--;
        restoDivisao = totalSomatoria % 11;
        int segundoDigito = restoDivisao < 2 ? 0 : 11 - restoDivisao;
        listaAleatoria.add(segundoDigito);

        return listaAleatoria;
    }

    public String geraCPFFinal() {
        try {
            geraCPFParcial();
            geraDigito();

            StringBuilder texto = new StringBuilder();
            for (int item : listaAleatoria) texto.append(item);

            MaskFormatter mf = new MaskFormatter("###.###.###-##");
            mf.setValueContainsLiteralCharacters(false);

            return mf.valueToString(texto.toString());
        } catch (ParseException e) {
            return "Erro ao gerar CPF.";
        }
    }
}
