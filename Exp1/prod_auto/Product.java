package Exp1.prod_auto;

public abstract class Product {
    private String name;
    private float price;

    public enum Category {
        DRINKS, COOKIES, CHOCOLATES, CHIPS, HOTDRINKS;
    }

    private Category category;

    public Product() {
        this.name = "";
        this.price = 0;
        this.category = Category.DRINKS;
    }

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
        this.category = Category.DRINKS;
    }

    public Product(String name, Category category, float price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public float getPrice() {
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
