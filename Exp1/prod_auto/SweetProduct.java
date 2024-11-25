package Exp1.prod_auto;

public class SweetProduct extends Product {
    private int weight;

    public SweetProduct(String name, Category сategory, int price, int weight) {
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
        return String.format("{name='%s', price=%d, weight=%d 'g', category='%s' }", getName(), getPrice(),
                getWeight(), getCategory());
    }

}
