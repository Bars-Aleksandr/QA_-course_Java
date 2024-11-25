// Задача 1. Реализуйте класс Товар, содержащий данные о товаре, и ТорговыйАвтомат, содержащий в себе 
// методы initProducts (List <Product>) сохраняющий в себе список исходных продуктов и getProduct(String name)
// Задача 2-Инкапсуляция. Реализуйте конструкторы,get/set методы,
// постройте логику ТорговогоАвтомата на основе кода сделанного в предыдущем задании.
// Задача 3-Наследование. Сделайте класс Товар абстрактным,создайте нескольких наследников(к примеру:БутылкаВоды),
// сделайте интерфейсом ТорговыйАвтомат и реализуйте класс какого-то одного типа ТорговогоАвтомата(пример:ПродающийБутылкиВодыАвтомат)

package Exp1.prod_auto;

import java.util.Scanner;

import Exp1.prod_auto.Product.Category;

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
        VendingMachineSweetProduct vendingMachineSweetProduct = new VendingMachineSweetProduct();
        iScanner = VendingMachineSweetProduct.iScanner;
        boolean flag = true;
        while (flag) {
            try {
                String flagMenu = menu();
                switch (flagMenu) {
                    case "1":
                        String nameProduct = vendingMachineSweetProduct.inpNameProduct();
                        Category categoryProduct = vendingMachineSweetProduct.inpCategoryProduct();
                        int priceProduct = vendingMachineSweetProduct.inpPriceProduct();
                        vendingMachineSweetProduct.initProducts(nameProduct, categoryProduct,
                                priceProduct);

                        break;
                    case "2":
                        System.out.println("Введите название продукта, который желаете получить: ");
                        String getName = iScanner.nextLine();
                        System.out.println(vendingMachineSweetProduct.getProduct(getName));
                        break;
                    case "3":
                        System.out.println(vendingMachineSweetProduct.getAllProducts());
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
