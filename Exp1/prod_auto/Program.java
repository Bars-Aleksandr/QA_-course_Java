// Реализуйте класс Товар, содержащий данные о товаре, и ТорговыйАвтомат, содержащий в себе методы
// initProducts (List <Product>) сохраняющий в себе список исходных продуктов и getProduct(String name)

package Exp1.prod_auto;

//import java.util.ArrayList;
//import java.util.List;
import java.util.Scanner;

import Exp1.prod_auto.Product.Categority;

public class Program {
    static Scanner iScanner;

    public static String menu() {
        System.out.println("Вас приветствует автомат для выдачи продуктов");
        System.out.println("Если Вы желаете положить продукты в автомат, введите - 1");
        System.out.println("Если Вы желаете получить продукты из автомата, введите - 2");
        System.out.println("Чтобы получить список всех прдуктов, введите - 3");
        System.out.println("Для завершения работы с автоматом введите - 0");
        String inpFlag = iScanner.nextLine();
        return inpFlag;
    }

    public static void main(String[] args) throws IllegalArgumentException {
        Vending_machine vending_machine = new Vending_machine();
        iScanner = vending_machine.iScanner;
        boolean flag = true;
        while (flag) {
            try {
                String flagMenu = menu();
                switch (flagMenu) {
                    case "1":
                        String nameProduct = vending_machine.inpNameProduct();
                        Categority categorityProduct = vending_machine.inpCategoryProduct();
                        int priceProduct = vending_machine.inpPriceProduct();
                        vending_machine.initProducts(nameProduct, categorityProduct, priceProduct);
                        break;
                    case "2":
                        System.out.println("Введите название продукта, который желаете получить: ");
                        String getName = iScanner.nextLine();
                        System.out.println(vending_machine.getProduct(getName));
                        break;
                    case "3":
                        vending_machine.getProductAll();
                        break;
                    case "0":
                        flag = false;
                        break;
                    default:
                        System.out.println("Пункта меню " + flagMenu + " не существует, попробуйте еще раз.");
                        break;
                }
            }

            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                flag = true;
            }
        }

        iScanner.close();

    }

}
