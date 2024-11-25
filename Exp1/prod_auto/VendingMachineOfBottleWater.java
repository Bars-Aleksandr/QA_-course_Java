import Exp1.prod_auto.Product;
import Exp1.prod_auto.VendingMachine;

public class VendingMachineOfBottleWater implements VendingMachine {

    public VendingMachineOfBottleWater() {

    }

    public int inpPriceProduct() {

        System.out.println("Введите стоимость продукта");
        int price = Integer.parseInt(iScanner.nextLine());
        return price;

    }

    public String getProduct(String name) {
        String temp = String.format("Продукта с названием - %s нет", name);
        for (Product product : listProducts) {
            if (product.getName().contains(name)) {
                return String.format("название продукта - %s \n категория продукта - %s \n стоимость продукта -%d",
                        product.getName(), product.getCategority(), product.getPrice());
            }
        }
        return temp;
    }

    public String inpNameProduct() {

        System.out.println("Введите название продукта");
        return iScanner.nextLine();
    }

    // public void getProductAll() {
    // for (Product product : listProducts) {
    // System.out.printf("название продукта - %s категория продукта - %s стоимость
    // продукта -%d \n",
    // product.getName(), product.getCategority(), product.getPrice());
    // }

    // }

}
