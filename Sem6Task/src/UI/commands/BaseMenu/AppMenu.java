package UI.commands.BaseMenu;

// import java.util.Scanner;

import UI.commands.UserInputHandler;

public class AppMenu implements IMenu {
    // private final Scanner scanner;
    // private final IMenu studentsMenu;
    // private final IMenu teachersMenu;

    // public AppMenu(Scanner scanner, IMenu studentsMenu, IMenu teachersMenu) {
    //     this.scanner = scanner;
    //     this.studentsMenu = studentsMenu;
    //     this.teachersMenu = teachersMenu;
    // }

    @Override
    public int show(UserInputHandler handler) {
        boolean exit = false;
        int choice = 0;
        while (!exit) {
            System.out.print("\033[H\033[J");
            System.out.println("\n=== Главное меню ===");
            System.out.println("1. Работа со студентами");
            System.out.println("2. Работа с преподавателями");
            System.out.println("0. Выход");
            System.out.print("Выберите пункт: ");
            choice = handler.readChoice();
            return choice;
            //int choice = handler.readChoice();
            

            // switch (choice) {
            //     case 1:
            //         studentsMenu.show();
            //         break;
            //     case 2:
            //         teachersMenu.show();
            //         break;
            //     case 0:
            //         exit = true;
            //         System.out.println("Выход из программы.");
            //         break;
            //     default:
            //         System.out.println("Некорректный выбор, попробуйте снова.");
            // }
        }
        return choice;
    }

    // private int readChoice() {
    //     while (true) {
    //         try {
    //             return Integer.parseInt(scanner.nextLine());
    //         } catch (NumberFormatException e) {
    //             System.out.print("Пожалуйста, введите число: ");
    //         }
    //     }
    // }
}
