package UI.commands;

import java.util.HashMap;
import java.util.Map;

import Core.MVC.controllers.StudyGroupController;
import UI.commands.StudentsCommands.CreateStudentCommand;
import UI.commands.StudentsCommands.PrintStudentsCommand;
import UI.commands.StudentsCommands.RemoveStudentByFioCommand;
import UI.commands.StudentsCommands.ShuffleStudentsCommand;
import UI.commands.StudentsCommands.SortStudentsByFIOCommand;
import UI.commands.StudentsCommands.SortStudentsByIdCommand;

public class CommandsStudyGroupService {
    
    private Map<Integer, ICommand> commands = new HashMap<>();

    public CommandsStudyGroupService(){

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
        registerCommand(4, new SortStudentsByFIOCommand(controller));
        registerCommand(5, new ShuffleStudentsCommand(controller));
        registerCommand(6, new RemoveStudentByFioCommand(controller));
    }

}
