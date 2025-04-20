package view;

import java.util.Scanner;


public class ConsoleView {
    Scanner in;

    public ConsoleView() {
        in = new Scanner(System.in);
    }

    public Scanner getScanner() {
        return in;
    }

    public String getFirstName() {
        System.out.printf("Enter FirstName: ");
        return in.nextLine();
    }

    public void setFirstName(String value) {
        System.out.printf("FirstName: %s\n", value);
    }

    public String getLastName() {
        System.out.printf("Enter LastName: ");
        return in.nextLine();
    }

    public void setLastName(String value) {
        System.out.printf("LastName: %s\n", value);
    }

    public String getMiddleName() {
        System.out.printf("Enter MiddleName :");
        return in.nextLine();
    }

    public String getBirthdate() {
        System.out.printf("Enter Birthdate :");
        return in.nextLine();
    }

}
