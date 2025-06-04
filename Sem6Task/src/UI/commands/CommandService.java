package UI.commands;

import java.util.HashMap;
import java.util.Map;

import Core.MVC.controllers.StudyGroupController;
import UI.commands.MenuStudentsCommands.CreateStudentCommand;
import UI.commands.MenuStudentsCommands.PrintStudentsCommand;
import UI.commands.MenuStudentsCommands.RemoveStudentByFioCommand;
import UI.commands.MenuStudentsCommands.SortStudentsByIdCommand;

public class CommandService {
    
    private Map<Integer, ICommand> commands = new HashMap<>();

    public CommandService(){

    }

    private void registerCommand(int key, ICommand command) {

        commands.put(key, command);
    }

    public void executeCommand(int key, Object paramObject) {
        ICommand command = commands.get(key);
        if (command != null) {
            command.execute(paramObject);
        } else {
            System.out.println("Некорректный выбор");
        }
    }

    public void registersCommand(StudyGroupController controller){
        registerCommand(1, new PrintStudentsCommand(controller));
        registerCommand(2, new CreateStudentCommand(controller));
        registerCommand(3, new SortStudentsByIdCommand(controller));
        // registerCommand(4, new SortStudentsByFIOCommand(controller));
        // registerCommand(5, new ShuffleStudentsCommand(controller));
        registerCommand(6, new RemoveStudentByFioCommand(controller));
    }

}
