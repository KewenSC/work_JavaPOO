package work.uninter.cofre.money.stateMoney;

import work.uninter.cofre.money.Moeda;

public class Dolar extends Moeda {

    public Dolar() {
        price = 5;
    }

    @Override
    public double valor() {
        return valor;
    }

    @Override
    public String info() {
        return "Dolar";
    }
}
