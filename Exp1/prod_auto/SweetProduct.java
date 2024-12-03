package Exp1.prod_auto;

public class SweetProduct extends Product {
    private int weight;

    public SweetProduct(String name, Category сategory, int weight, float price) {
        super(name, сategory, price);
        this.weight = weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return String.format(
                "%s - %s, weight=%d g., price=%.2f руб.", getCategory(), getName(),
                getWeight(), getPrice());
    }

}
