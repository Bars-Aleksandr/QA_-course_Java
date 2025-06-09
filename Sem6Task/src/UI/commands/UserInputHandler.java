package UI.commands;

import java.util.Scanner;

import Core.MVC.models.User;

import Core.MVC.view.IUserView;
import UI.commands.BaseMenu.UserDTO;

public class UserInputHandler {
    private Scanner scanner;
    private InputModel userModel = new InputModel();

    public UserInputHandler(Scanner scanner, CommandsStudyGroupService commandStudyGroupService) {
        this.scanner = scanner;

    }

    public InputModel readChoice() {
        while (true) {
            try {
                var userModel = new InputModel();
                userModel.userChoice = Integer.parseInt(scanner.nextLine());
                return userModel;
            } catch (NumberFormatException e) {
                System.out.print("Пожалуйста, введите число: ");
            }
        }

    }

    public InputModel readChoice(IUserView<? extends User> view) {
        while (true) {
            try {

                userModel.userChoice = Integer.parseInt(scanner.nextLine());
                switch (userModel.userChoice) {
                    case 0:
                    case 1:
                        return userModel;
                    case 2:
                        userModel.userInputObject = readUserName(view);
                        return userModel;
                    case 3:
                        return userModel;
                    case 4:
                        return userModel;
                    case 5:
                        return userModel;
                    case 6:
                        System.out.println("Введите ФИО удаляемого пользователя");
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

    private UserDTO readUserName(IUserView<? extends User> view) {
        String birthdateStr;

        view.printLastnameText();
        String lastname = readWithConsoleString();

        view.printFirstnameText();
        String firstname = readWithConsoleString();

        view.printMiddlenameText();
        String middlename = readWithConsoleString();
        if (userModel.userChoice == 2) {
            view.printBirthdateText();
            birthdateStr = readWithConsoleString();
        } else {
            birthdateStr = "00.00.0001";
        }

        return new UserDTO(lastname, firstname, middlename, birthdateStr);
    }

}
