package UI.commands.MenuStudentsCommands;

import Core.MVC.controllers.StudyGroupController;
import UI.commands.ICommand;

public class RemoveStudentByFioCommand implements ICommand {
    private final StudyGroupController controller;
    private final String firstName;
    private final String lastName;
    private final String middleName;

    public RemoveStudentByFioCommand(StudyGroupController controller, String firstName,
                                     String lastName, String middleName) {
        this.controller = controller;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
    }

    @Override
    public void execute() {
        controller.removeStudentByFio(firstName, lastName, middleName);
        System.out.println("Студент удален (если такой был).");
    }
}
