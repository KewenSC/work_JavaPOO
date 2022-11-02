// Este é o objeto moeda, que contém os dados de valor, tipo de moeda e cotação (price)

package work.uninter.cofre.money;

public abstract class Moeda {
    protected double valor;
    protected int price;

    public Moeda() {

    }

    public abstract double valor();

    public abstract String info();

}