package Exp1.prod_auto;

public abstract class Product {
    private String name;
    private int price;

    public enum Category {
        DRINKS, COOKIES, CHOCOLATES, CRACKERS;
    }

    private Category category;

    public Product() {
        this.name = "";
        this.price = 0;
        this.category = Category.DRINKS;
    }

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
        this.category = Category.DRINKS;
    }

    public Product(String name, Category category, int price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public int getPrice() {
        return this.price;
    }

    public Category getCategory() {
        return this.category;
    }

    @Override
    public String toString() {
        return "Product{name='" + name + "', category=" + category + ", price=" + price + "}";
    }
}
