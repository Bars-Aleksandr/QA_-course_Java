package UI.commands.StudentsCommands;

import java.time.LocalDate;

import Core.MVC.controllers.StudyGroupController;
import Core.MVC.models.Student;
import UI.commands.ICommand;
import UI.commands.Validator;
import UI.commands.BaseMenu.UserDTO;

public class CreateStudentCommand implements ICommand {
    private final StudyGroupController controller;
    private final Validator validator;

    public CreateStudentCommand(StudyGroupController controller) {
        this.controller = controller;
        this.validator = new Validator();
    }

    @Override
    public void execute(Object paramObject) {
        if (paramObject instanceof Student) {
            Student student = (Student) paramObject;
            controller.create(student);
        } else {
            UserDTO userDTO = (UserDTO) paramObject;
            LocalDate birthdateLD;
            try {
                birthdateLD = validator.parseStrDateTLocalDate(userDTO.getBirthdate());
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка:" + e.getMessage());
                return;
            }

            controller.create(userDTO.getLastname(), userDTO.getFirstname(), userDTO.getMiddlename(), birthdateLD);
        }

        System.out.println("Студент успешно создан и добавлен в список.");
    }
}
