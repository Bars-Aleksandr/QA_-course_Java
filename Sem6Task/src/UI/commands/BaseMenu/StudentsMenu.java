package UI.commands.BaseMenu;

import java.util.Scanner;

import UI.commands.UserInputHandler;

public class StudentsMenu implements IMenu {
    private final Scanner scanner;

    public StudentsMenu(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public int show(UserInputHandler handler) {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Работа со студентами ---");
            System.out.println("1. Показать всех студентов");
            System.out.println("2. Добавить студента");
            System.out.println("3. Отсортировать список студентов по id");
            System.out.println("4. Отсортировать список студентов по ФИО");
            System.out.println("5. Перемешать список студентов по ФИО");
            System.out.println("6. Удалить студента по ФИО");
            System.out.println("0. Назад");
            System.out.print("Выберите пункт: ");
        }
        return readChoice();
        

    }

    private int readChoice() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Пожалуйста, введите число: ");
            }
        }
    }

}
