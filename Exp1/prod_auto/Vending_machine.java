package Exp1.prod_auto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Locale.Category;

import Exp1.prod_auto.Product.Categority;

public class Vending_machine {

    private List<Product> listProducts = new ArrayList<>();

    public Vending_machine() {

    }

    public Scanner iScanner = new Scanner(System.in);

    public String inpNameProduct() {

        System.out.println("Введите название продукта");
        return iScanner.nextLine();
    }

    public Categority inpCategoryProduct() {

        String categoryTemp = "0";
        while ((!categoryTemp.equals("1") & !categoryTemp.equals("2")
                & !categoryTemp.equals("3"))) {
            System.out.println("Выбирите категорию товара:");
            System.out.println("1-напиток");
            System.out.println("2-печенье");
            System.out.println("3-шоколад");
            categoryTemp = iScanner.nextLine();
            if ((!categoryTemp.equals("1") & !categoryTemp.equals("2")
                    & !categoryTemp.equals("3"))) {
                System.out.println("Такой категории товара не существует, попробуйте еще раз " + categoryTemp);
            }
        }
        Categority category = Categority.drinks;
        switch (categoryTemp) {
            case "1":
                category = Categority.drinks;
                break;
            case "2":
                category = Categority.cookies;
                break;
            case "3":
                category = Categority.chocolates;
                break;
        }

        return category;
    }

    public int inpPriceProduct() {

        System.out.println("Введите стоимость продукта");
        int price = Integer.parseInt(iScanner.nextLine());
        return price;

    }

    public List<Product> initProducts(String name, Categority categority, int price) {
        Product product = new Product(name, categority, price);
        listProducts.add(product);
        return listProducts;
    }

    String getProduct(String name) {
        String temp = String.format("Продукта с названием - %s нет", name);
        for (Product product : listProducts) {
            if (product.getName().contains(name)) {
                return String.format("название продукта - %s \n категория продукта - %s \n стоимость продукта -%d",
                        product.getName(), product.getCategority(), product.getPrice());
            }
        }
        return temp;
    }

    void getProductAll() {
        for (Product product : listProducts) {
            System.out.printf("название продукта - %s  категория продукта - %s  стоимость продукта -%d \n",
                    product.getName(), product.getCategority(), product.getPrice());
        }

    }

}
