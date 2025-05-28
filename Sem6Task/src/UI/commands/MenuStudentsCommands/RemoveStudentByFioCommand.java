package UI.commands.MenuStudentsCommands;

import Core.MVC.controllers.StudyGroupController;
import Core.MVC.models.Student;
import UI.commands.ICommand;

public class RemoveStudentByFioCommand implements ICommand {
    private final StudyGroupController controller;
    

    public RemoveStudentByFioCommand(StudyGroupController controller) {
        this.controller = controller;
        
    }

    @Override
    public void execute(Object paramObject) {
        Student student = (Student) paramObject;
        controller.removeStudentByFio(student.getFirstName(), student.getLastName(), student.getMiddleName());
        System.out.println("Студент удален (если такой был).");
    }
}
