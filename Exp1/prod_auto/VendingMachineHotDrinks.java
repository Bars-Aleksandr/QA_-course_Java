package Exp1.prod_auto;

import java.util.ArrayList;
import java.util.List;

import Exp1.prod_auto.Product.Category;

public class VendingMachineHotDrinks implements VendingMachine {
    private List<HotDrink> listHotDrinks = new ArrayList<>();

    public VendingMachineHotDrinks() {
        initProducts("Сappuccino", 50, 3.5f);
        initProducts("Latte", 150, 3.5f);
        initProducts("Tea", 150, 3.5f);
    }

    @Override
    public String inpNameProduct() {
        System.out.println("Введите название горячего напитка");
        return iScanner.nextLine();
    }

    @Override
    public float inpPriceProduct() {
        System.out.println("Введите стоимость горячего напитка");
        float price = Float.parseFloat(iScanner.nextLine());
        return price;

    }

    public int inpVolumeHotDrink() {

        System.out.println("Введите объем горячего напитка");
        int volume = Integer.parseInt(iScanner.nextLine());
        return volume;
    }

    @Override
    public void initProducts(String name, int volume, float price) {
        HotDrink hotDrink = new HotDrink(name, price, volume);
        listHotDrinks.add(hotDrink);
    }

    public HotDrink getProduct(String name) {
        while (true) {
            for (HotDrink product : listHotDrinks) {
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
        return new ArrayList<>(listHotDrinks);
    }

    @Override
    public void initProducts(String name, Category category, int weight, float price) {
        // данный метод с параметрами (String name, Category category, int price) в
        // данном классе не используется

    }

    @Override
    public void menu() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'menu'");
    }

    @Override
    public void printAllProducts() {
        for (HotDrink drink : listHotDrinks) {
            System.out.println(drink);
        }
        ;
    }
}
