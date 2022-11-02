package work.uninter.cofre.money.stateMoney;

import work.uninter.cofre.money.Moeda;

public class Euro extends Moeda {

    public Euro() {
        price = 6;
    }

    @Override
    public double valor() {
        return valor;
    }

    @Override
    public String info() {
        return "Euro";
    }
}
