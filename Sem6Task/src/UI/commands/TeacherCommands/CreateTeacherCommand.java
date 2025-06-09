package UI.commands.TeacherCommands;

import java.time.LocalDate;

import Core.MVC.controllers.TeacherController;
import Core.MVC.models.Teacher;
import UI.commands.ICommand;
import UI.commands.BaseMenu.UserDTO;
import UI.commands.Validator;

public class CreateTeacherCommand implements ICommand {
   private final TeacherController controller;
   private final Validator validator;

   public CreateTeacherCommand(TeacherController controller) {
      this.controller = controller;
      this.validator = new Validator();

   }

   @Override 
   public void execute(Object paramObject){ 
      if (paramObject instanceof Teacher) {
         Teacher teacher = (Teacher) paramObject;
         controller.create(teacher);
         System.out.println("Учитель успешно создан и добавлен в список."); 
      } if (paramObject instanceof UserDTO) {
         UserDTO user = (UserDTO) paramObject;
         LocalDate birthdateLD;
         try {
            birthdateLD = validator.parseStrDateTLocalDate(user.getBirthdate());
         } catch (IllegalArgumentException e) {
                System.out.println("Ошибка:" + e.getMessage());
                return;
            }
            controller.create(user.getLastname(), user.getFirstname(), user.getMiddlename(), birthdateLD);
         } else {
            System.out.println("При создании учителя возникла ошибка");
         }
      System.out.println("Учитель успешно создан и добавлен в список.");
      
   } 
}
