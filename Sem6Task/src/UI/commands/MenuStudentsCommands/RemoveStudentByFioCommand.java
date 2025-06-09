package UI.commands.MenuStudentsCommands;

import Core.MVC.controllers.StudyGroupController;
import UI.commands.ICommand;
import UI.commands.BaseMenu.UserDTO;

public class RemoveStudentByFioCommand implements ICommand {
    private final StudyGroupController controller;

    public RemoveStudentByFioCommand(StudyGroupController controller) {
        this.controller = controller;

    }

    @Override
    public void execute(Object paramObject) {
        UserDTO user = (UserDTO) paramObject;
        controller.removeStudentByFio(user.getLastname(), user.getFirstname(), user.getMiddlename());
        System.out.println("Студент удален (если такой был).");
    }
}
