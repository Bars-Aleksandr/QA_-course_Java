package UI.commands.BaseMenu;

// import java.util.Scanner;

public class AppMenu implements IMenu {
    // private final Scanner scanner;
    // private final IMenu studentsMenu;
    // private final IMenu teachersMenu;

    // public AppMenu(Scanner scanner, IMenu studentsMenu, IMenu teachersMenu) {
    // this.scanner = scanner;
    // this.studentsMenu = studentsMenu;
    // this.teachersMenu = teachersMenu;
    // }

    @Override
    public void show() {
        System.out.print("\033[H\033[J");
        System.out.println("\n=== Главное меню ===");
        System.out.println("1. Работа со студентами");
        System.out.println("2. Работа с преподавателями");
        System.out.println("0. Выход");
        System.out.print("Выберите пункт: ");

    }

}
