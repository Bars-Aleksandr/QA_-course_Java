package UI.commands.MenuStudentsCommands;

import UI.commands.ICommand;
import UI.commands.BaseMenu.MenuInvoker;

public class CommandBack implements ICommand{

    MenuInvoker menu = new MenuInvoker();

    @Override
    public void execute() {
        System.out.print("\033[H\033[J");
        menu.start();
    }

}
