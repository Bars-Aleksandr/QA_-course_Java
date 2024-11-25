package Exp1.prod_auto;

import java.util.List;

public interface VendingMachine {

    public void initProducts(String name, Product.Category category, int price);

    Product getProduct(String name);

    List<Product> getAllProducts();

}
