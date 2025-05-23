package UI.commands.MenuStudentsCommands;

import Core.MVC.controllers.StudyGroupController;
import UI.commands.ICommand;

public class SortStudentsByIdCommand implements ICommand {
    private final StudyGroupController controller;

    public SortStudentsByIdCommand(StudyGroupController controller) {
        this.controller = controller;
    }

    @Override
    public void execute() {
        controller.sortStudentsById();
        System.out.println("Студенты отсортированы по ID.");
    }
}
