package Exp1.prod_auto;

public class BottleOfWater extends Product {

    private int volume;

    public BottleOfWater(String name, int price, int volume) {
        super(name, Category.DRINKS, price);
        this.volume = volume;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return String.format(" Напиток: {name='%s', price=%d, volume=%d ml}",
                getName(), getPrice(), volume);
    }
}
