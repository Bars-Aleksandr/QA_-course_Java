package UI.commands.MenuStudentsCommands;

import Core.MVC.controllers.StudyGroupController;
import UI.commands.ICommand;

public class SortStudentsByFIOCommand implements ICommand{
    private final StudyGroupController controller;

    public SortStudentsByFIOCommand(StudyGroupController controller) {
        this.controller = controller;
    }

    @Override
    public void execute(Object paraObject) {
        controller.sortStudyGroupByFIO();
        System.out.println("Студенты отсортированы по ФИО.");
    }
}
