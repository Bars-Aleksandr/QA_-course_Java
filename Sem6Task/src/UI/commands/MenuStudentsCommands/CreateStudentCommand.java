package UI.commands.MenuStudentsCommands;

import java.time.LocalDate;

import Core.MVC.controllers.StudyGroupController;
import UI.commands.ICommand;

public class CreateStudentCommand implements ICommand {
    private final StudyGroupController controller;
    private final String firstName;
    private final String lastName;
    private final String middleName;
    private final LocalDate birthDay;

    public CreateStudentCommand(StudyGroupController controller, String firstName, String lastName,
                                String middleName, LocalDate birthDay) {
        this.controller = controller;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.birthDay = birthDay;
    }

    @Override
    public void execute() {
        controller.create(firstName, lastName, middleName, birthDay);
        System.out.println("Студент успешно добавлен.");
    }
}
