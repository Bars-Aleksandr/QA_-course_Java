package UI.commands.TeacherCommands;

import Core.MVC.controllers.TeacherController;
import UI.commands.ICommand;

public class SortTeachersByFIOCommand implements ICommand{
    private final TeacherController controller;

    public SortTeachersByFIOCommand(TeacherController controller) {
        this.controller = controller;
    }

    @Override
    public void execute(Object paramObject) {
        controller.sortTeachersByFIO();
        System.out.println("Список учителей отсортирован");
    }

}
