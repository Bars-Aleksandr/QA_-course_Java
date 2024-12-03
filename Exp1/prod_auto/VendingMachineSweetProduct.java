package Exp1.prod_auto;

import java.util.ArrayList;
import java.util.List;

public class VendingMachineSweetProduct implements VendingMachine {

    private List<SweetProduct> listSweetProducts = new ArrayList<>();

    public VendingMachineSweetProduct() {
        initProducts("Postnoe", SweetProduct.Category.COOKIES, 220, 2.30f);
        initProducts("Lemon", SweetProduct.Category.COOKIES, 50, 1.30f);
        initProducts("Sugar", SweetProduct.Category.COOKIES, 50, 1.30f);
        initProducts("Lau's", SweetProduct.Category.CHIPS, 200, 4.50f);
        initProducts("Bulba", SweetProduct.Category.CHIPS, 200, 4.50f);
        initProducts("Onega", SweetProduct.Category.CHIPS, 200, 4.50f);
    }

    @Override
    public void menu() {
        String name = inpNameProduct();
        SweetProduct.Category category = inpCategoryProduct();
        float price = inpPriceProduct();
        int weight = inpWeightProduct();
        initProducts(name, category, weight, price);
    }

    @Override
    public String inpNameProduct() {
        System.out.println("Введите название продукта");
        return iScanner.nextLine();
    }

    public SweetProduct.Category inpCategoryProduct() {
        String categoryTemp;
        while (true) {
            System.out.println("Выберите категорию товара:");
            System.out.println("1-сухари");
            System.out.println("2-печенье");
            System.out.println("3-шоколад");
            categoryTemp = iScanner.nextLine();

            switch (categoryTemp) {
                case "1":
                    return SweetProduct.Category.CHIPS;
                case "2":
                    return SweetProduct.Category.COOKIES;
                case "3":
                    return SweetProduct.Category.CHOCOLATES;
                default:
                    System.out.println("Некорректный ввод, попробуйте еще раз");
            }
        }
    }

    @Override
    public float inpPriceProduct() {
        System.out.println("Введите стоимость продукта");
        float price = Float.parseFloat(iScanner.nextLine());
        return price;
    }

    public int inpWeightProduct() {
        System.out.println("Введите вес продукта");
        int weight = Integer.parseInt(iScanner.nextLine());
        return weight;
    }

    @Override
    public void initProducts(String name, SweetProduct.Category category, int weight, float price) {
        SweetProduct product = new SweetProduct(name, category, weight, price);
        listSweetProducts.add(product);
    }

    @Override
    public SweetProduct getProduct(String name) {
        if (listSweetProducts.isEmpty()) {
            System.out.println("Список продуктов пуст. Пожалуйста, добавьте продукты.");

        }
        while (true) {
            for (SweetProduct product : listSweetProducts) {
                if (product.getName().equalsIgnoreCase(name)) {
                    return product;
                }
            }
            System.out.println(
                    "Продукта с именем '" + name + "' в автомате нет. Попробуй еще раз. Вот список всех продуктов:");
            printAllProducts();
            name = inpNameProduct();

        }

    }

    @Override
    public List<Product> getAllProducts() {
        return new ArrayList<>(listSweetProducts);
    }

    @Override
    public void printAllProducts() {
        for (SweetProduct product : listSweetProducts) {
            System.out.println(product);
        }

    }

    @Override
    public void initProducts(String name, int volume, float price) {
        // данный метод с параметрами (String name, float price, int volume ) в
        // данном классе не используется
    }

}
