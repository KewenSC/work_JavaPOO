//Essa classe gerencia a lista de moedas

package work.uninter.cofre.money;

import java.util.ArrayList;

public class Cofre {
    private final ArrayList<Moeda> listCoin; //lista
    public Moeda currentCoin; //moeda atual

    public Cofre() {
        listCoin = new ArrayList<Moeda>();
    }

    // Adiciona moedas com base no tipo, já definido na variavel "currentCoin", e o valor
    public void addCoin(double valor) {
        currentCoin.valor = valor;
        listCoin.add(currentCoin);
    }

    // Remove moedas com base no tipo, já definido na variavel "currentCoin", e o valor.
    // Se remover um objeto retorna verdadeiro, senão retorna falso
    public boolean remove(double delValue) {

        Moeda moeda;
        for (int i = 0; i < listCoin.size(); i++) {
            moeda = listCoin.get(i);
            if (moeda.getClass() == currentCoin.getClass()) {
                if (moeda.valor() == delValue) {
                    listCoin.remove(i);
                    return true;
                }
            }
        }
        return false;
    }

    // Formata a lista em texto para mostrar ao usuário
    public void list() {
        for (int index = 0; index < listCoin.size(); index++) {
            System.out.println((index + 1) + " - " + listCoin.get(index).info() + " " + listCoin.get(index).valor);
            //posição//             //tipo de moeda//                    //valor da moeda//
        }
    }

    // Retorna a soma do resultado da converção de cada moeda da lista
    public double valorTotalReal() {
        double total = 0;
        for (Moeda c : listCoin) {
            total += c.valor * c.price;
        }
        return total;
    }

}
