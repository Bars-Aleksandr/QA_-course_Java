package UI.commands;

import java.util.HashMap;
import java.util.Map;

public class CommandService {
    
    private Map<Integer, ICommand> commands = new HashMap<>();

    public CommandService(){

    }

    public void registerCommand(int key, ICommand command) {
        commands.put(key, command);
    }

    public void executeCommand(int key) {
        ICommand command = commands.get(key);
        if (command != null) {
            command.execute();
        } else {
            System.out.println("Некорректный выбор");
        }
    }

}
