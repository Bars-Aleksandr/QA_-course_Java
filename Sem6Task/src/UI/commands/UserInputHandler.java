package UI.commands;

import java.util.Scanner;

import Core.MVC.models.Student;
import Core.MVC.models.Teacher;
import Core.MVC.models.User;
import Core.MVC.view.IUserView;

public class UserInputHandler {
    Scanner scanner;
    CommandService commandService;

    public UserInputHandler(Scanner scanner, CommandService commandService) {
        this.scanner = scanner;
        this.commandService = commandService;
    }

    

    public InputModel readChoice(IUserView<? extends User> view) {
        while (true) {
            try {
                var userModel = new InputModel();
                userModel.userChoice = Integer.parseInt(scanner.nextLine());
                switch (userModel.userChoice) {
                    case 0:
                    case 1:
                        return userModel;
                    case 3:
                    case 4:
                        return userModel;
                    case 2:
                        userModel.userInputObject = readUserName(view);
                        return userModel;
                    default:
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.print("Пожалуйста, введите число: ");
            }
        }
    }

    public String readWithConsoleString() {
        return scanner.nextLine();
    }

    private User readUserName(IUserView<? extends User> view) {
        view.printFirstnameText();
        String firstname = readWithConsoleString();
        view.printLastnameText();
        String lastname = readWithConsoleString();
        view.printMiddlenameText();
        String middlename = readWithConsoleString();
        view.printBirthdateText();
        String birthdate = readWithConsoleString();
        return new Teacher(firstname, lastname, middlename, birthdate, null);
    }

}
