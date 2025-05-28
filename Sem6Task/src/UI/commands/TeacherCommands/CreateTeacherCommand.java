package UI.commands.TeacherCommands;

import java.time.LocalDate;

import Core.MVC.controllers.TeacherController;
import UI.commands.ICommand;

public class CreateTeacherCommand implements ICommand {
    private final TeacherController controller;
    private final String firstName;
    private final String lastName;
    private final String middleName;
    private final LocalDate birthday;

    public CreateTeacherCommand(TeacherController controller, String firstName, String lastName,
                                String middleName, LocalDate birthday) {
        this.controller = controller;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.birthday = birthday;
    }

    @Override 
   public void execute(){ 
      controller.create(firstName, lastName, middleName, birthday); 
      System.out.println("Учитель успешно добавлен."); 
   } 
}

