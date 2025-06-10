package UI.commands.TeacherCommands;

import Core.MVC.controllers.TeacherController;

import UI.commands.ICommand;

public class PrintTeachersCommand implements ICommand {
    private final TeacherController controller;

    public PrintTeachersCommand(TeacherController controller) {
        this.controller = controller;
    }

    @Override
    public void execute(Object paramObject) {
        System.out.println("Список учителей:");
        controller.sendOnConsoleTeacherList();

    }

}
