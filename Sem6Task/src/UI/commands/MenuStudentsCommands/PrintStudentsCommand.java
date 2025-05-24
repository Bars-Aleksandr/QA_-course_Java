package UI.commands.MenuStudentsCommands;

import java.util.List;

import Core.MVC.controllers.StudyGroupController;
import Core.MVC.models.Student;
import UI.commands.ICommand;

public class PrintStudentsCommand implements ICommand {
    private final StudyGroupController controller;

    public PrintStudentsCommand(StudyGroupController controller) {
        this.controller = controller;
    }

    @Override
    public void execute() {
        List<Student> students = controller.getStudyGroup().getStudentsList();
        controller.sendOnConsoleStudentsList(students);
        System.out.println("Список студентов выведен на консоль.");
    }
}
