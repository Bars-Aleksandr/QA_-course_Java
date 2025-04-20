package Client;

import controller.Controller;

public class Main {

    public static void main(String[] args) {
        System.out.print("\033[H\033[J");
        System.out.println("Hello, Coworker");

        Controller controller = new Controller();
        controller.setMenu();

    }
}
