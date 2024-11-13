package Exp1.prod_auto;

public class Product {
    private String name;
    private int price;

    enum Categority {
        drinks, cookies, chocolates;
    }

    private Categority categority;

    public Product(String name, Categority categority, int price) {
        this.name = name;
        this.categority = categority;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public int getPrice() {
        return this.price;
    }

    public Categority getCategority() {
        return this.categority;
    }
}
