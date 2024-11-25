package Exp1.prod_auto;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class VendingMachineSweetProduct implements VendingMachine {
    private List<SweetProduct> listProducts = new ArrayList<>();

    private int weight;

    public static Scanner iScanner = new Scanner(System.in);

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
                    return SweetProduct.Category.CRACKERS;
                case "2":
                    return SweetProduct.Category.COOKIES;
                case "3":
                    return SweetProduct.Category.CHOCOLATES;
                default:
                    System.out.println("Некорректный ввод, попробуйте еще раз");
            }
        }
    }

    public int inpPriceProduct() {
        System.out.println("Введите стоимость продукта");
        int price = Integer.parseInt(iScanner.nextLine());
        return price;
    }

    public int inpWeightProduct() {
        System.out.println("Введите вес продукта");
        int weight = Integer.parseInt(iScanner.nextLine());
        return weight;
    }

    @Override
    public void initProducts(String name, SweetProduct.Category category, int price) {
        SweetProduct product = new SweetProduct(name, category, price, weight);
        listProducts.add(product);
    }

    @Override
    public SweetProduct getProduct(String name) {
        for (SweetProduct product : listProducts) {
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        throw new NoSuchElementException(String.format("Продукта с именем - {name = '%s'}, в автомате нет", name));
    }

    @Override
    public List<Product> getAllProducts() {
        return new ArrayList<>(listProducts); // Возвращаем копию списка всех продуктов
    }
}
