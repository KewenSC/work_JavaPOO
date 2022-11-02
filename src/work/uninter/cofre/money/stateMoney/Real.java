package work.uninter.cofre.money.stateMoney;

import work.uninter.cofre.money.Moeda;

public class Real extends Moeda {

    public Real() {
        price = 1;
    }

    @Override
    public double valor() {
        return valor;
    }

    @Override
    public String info() {
        return "Real";
    }
}
