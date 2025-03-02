// Задача 1. Реализуйте класс Товар, содержащий данные о товаре, и ТорговыйАвтомат, содержащий в себе 
// методы initProducts (List <Product>) сохраняющий в себе список исходных продуктов и getProduct(String name)
// Задача 2-Инкапсуляция. Реализуйте конструкторы,get/set методы,
// постройте логику ТорговогоАвтомата на основе кода сделанного в предыдущем задании.
// Задача 3-Наследование. Сделайте класс Товар абстрактным,создайте нескольких наследников(к примеру:БутылкаВоды),
// сделайте интерфейсом ТорговыйАвтомат и реализуйте класс какого-то одного типа ТорговогоАвтомата(пример:ПродающийБутылкиВодыАвтомат)

package Exp1.prod_auto;

import java.util.Scanner;

//import Exp1.prod_auto.Product.Category;

public class Program {
    static Scanner iScanner;

    public static String menu() {
        System.out.println("Выберите, что Вы желаете: ");
        System.out.println(" сладости - 1 ");
        System.out.println(" холодные напитки - 2");
        System.out.println(" горячие напитки - 3");
        System.out.println("Для завершения работы с автоматом введите - 0");
        String inpFlag = iScanner.nextLine();
        return inpFlag;
    }

    public static void main(String[] args) throws IllegalArgumentException {
        VendingMachineSweetProduct vendingMachineSweetProduct = new VendingMachineSweetProduct();
        VendingMachineBottleOfWater vendingMachineBottleOfWater = new VendingMachineBottleOfWater();
        VendingMachineHotDrinks vendingMachineHotDrinks = new VendingMachineHotDrinks();
        iScanner = VendingMachineSweetProduct.iScanner;
        boolean flag = true;
        while (flag) {
            try {
                String flagMenu = menu();
                switch (flagMenu) {
                    case "1":
                        vendingMachineSweetProduct.printAllProducts();
                        System.out.println(
                                vendingMachineSweetProduct.getProduct(vendingMachineSweetProduct.inpNameProduct()));
                        break;
                    case "2":
                        vendingMachineBottleOfWater.printAllProducts();
                        System.out.println(
                                vendingMachineBottleOfWater.getProduct(vendingMachineBottleOfWater.inpNameProduct()));
                        break;
                    case "3":
                        vendingMachineHotDrinks.printAllProducts();
                        System.out.println(
                                vendingMachineHotDrinks.getProduct(vendingMachineHotDrinks.inpNameProduct()));
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
