package UI.commands;

import java.util.Scanner;

public class UserInputHandler {
    Scanner scanner;
    public UserInputHandler(Scanner scanner){
        this.scanner = scanner;
    }
    public int readChoice() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Пожалуйста, введите число: ");
            }
        }
    }
}
