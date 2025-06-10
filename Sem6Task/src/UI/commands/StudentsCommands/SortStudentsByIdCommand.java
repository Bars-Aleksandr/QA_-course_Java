package UI.commands.StudentsCommands;

import Core.MVC.controllers.StudyGroupController;
import UI.commands.ICommand;

public class SortStudentsByIdCommand implements ICommand {
    private final StudyGroupController controller;

    public SortStudentsByIdCommand(StudyGroupController controller) {
        this.controller = controller;
    }

    @Override
    public void execute(Object paramObject) {
        controller.sortStudentsById();
        System.out.println("Студенты отсортированы по ID.");
    }
}
