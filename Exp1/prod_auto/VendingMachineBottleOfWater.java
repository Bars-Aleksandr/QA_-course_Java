package Exp1.prod_auto;

import java.util.ArrayList;
import java.util.List;

import Exp1.prod_auto.Product.Category;

public class VendingMachineBottleOfWater implements VendingMachine {
    private List<BottleOfWater> listBottleOfWaters = new ArrayList<>();

    public VendingMachineBottleOfWater() {
        initProducts("Coca-Cola", 300, 3.5f);
        initProducts("Fanta", 300, 3.5f);
        initProducts("Sprite", 300, 3.5f);
        initProducts("Miniral Water", 300, 3.5f);
    }

    @Override
    public String inpNameProduct() {
        System.out.println("Введите название бутылки воды");
        return iScanner.nextLine();
    }

    @Override
    public float inpPriceProduct() {
        System.out.println("Введите стоимость бутылки воды");
        float price = Float.parseFloat(iScanner.nextLine());
        return price;

    }

    public int inpVolumeBottle() {

        System.out.println("Введите объем бутылки");
        int volume = Integer.parseInt(iScanner.nextLine());
        return volume;
    }

    @Override
    public void initProducts(String name, int volume, float price) {
        BottleOfWater bottleOfWater = new BottleOfWater(name, price, volume);
        listBottleOfWaters.add(bottleOfWater);
    }

    public BottleOfWater getProduct(String name) {
        while (true) {
            for (BottleOfWater product : listBottleOfWaters) {
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
        return new ArrayList<>(listBottleOfWaters);
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
        for (BottleOfWater bottle : listBottleOfWaters) {
            System.out.println(bottle);
        }
    }

}
