package UI.commands;

import java.util.HashMap;
import java.util.Map;

import Core.MVC.controllers.TeacherController;
import UI.commands.TeacherCommands.CreateTeacherCommand;
import UI.commands.TeacherCommands.PrintTeachersCommand;
import UI.commands.TeacherCommands.SortTeachersByFIOCommand;

public class CommandsTeacherService {
    private Map<Integer, ICommand> commands = new HashMap<>();

    public CommandsTeacherService(TeacherController teacherController){
        registersCommand(teacherController);
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

    private void registersCommand(TeacherController controller) {
        registerCommand(1, new PrintTeachersCommand(controller));
        registerCommand(2, new CreateTeacherCommand(controller));
        registerCommand(3, new SortTeachersByFIOCommand(controller));

    }
}
