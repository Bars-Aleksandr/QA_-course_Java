package Exp1.prod_auto;

import java.util.List;
import java.util.Scanner;

public interface VendingMachine {
    public static Scanner iScanner = new Scanner(System.in);

    public void menu();

    public String inpNameProduct();

    public float inpPriceProduct();

    public void initProducts(String name, Product.Category category, int weight, float price);

    public void initProducts(String name, int volume, float price);

    public Product getProduct(String name);

    List<Product> getAllProducts();

    public void printAllProducts();

}
