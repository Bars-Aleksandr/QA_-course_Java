package UI.commands.BaseMenu;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import UI.commands.CommandService;
import UI.commands.ICommand;
import UI.commands.UserInputHandler;

public class MenuInvoker {
    
    private final AppMenu appMenu;
    private final UserInputHandler handler;
    private final CommandService commandService;
    private final StudentsMenu studentsMenu;

    public MenuInvoker(UserInputHandler handler, CommandService commandService, StudentsMenu studentsMenu) {
        this.appMenu = new AppMenu();
        this.handler = handler;
        this.commandService = commandService;
        this.studentsMenu = studentsMenu;
    }


    public void start() {
        boolean exit = false;
        while (!exit) {

            int choice = appMenu.show(handler);

            switch (choice) {
                case 1:
                    
                    break;
                case 2:

                    break;
                case 3:
                    exit = true;
                    System.out.println("Выход из программы. До свидания!");
                    break;
                default:
                    System.out.println("Некорректный выбор. Попробуйте снова.");
                    break;
            }

        }
    }

    private String getCommandDescription(int index) {
        switch (index) {
            case 0:
                return "Показать все группы";
            case 1:
                return "Добавить новую группу";
            case 2:
                return "Показать всех преподавателей";
            case 3:
                return "Добавить нового преподавателя";
            default:
                return "";
        }
    }
}
