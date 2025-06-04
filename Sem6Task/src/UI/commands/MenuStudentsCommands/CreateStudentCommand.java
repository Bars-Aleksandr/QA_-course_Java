package UI.commands.MenuStudentsCommands;



import Core.MVC.controllers.StudyGroupController;
import Core.MVC.models.Student;
import Core.MVC.models.User;
import UI.commands.ICommand;


public class CreateStudentCommand implements ICommand {
    private final StudyGroupController controller;
    

    public CreateStudentCommand(StudyGroupController controller) {
        this.controller = controller;
        
    }

    @Override
    public void execute(Object paramObject) {
        //Student student = (Student) paramObject;
        if (paramObject instanceof Student) {
            Student student = (Student) paramObject;
            controller.create(student);
        } else {
            User user = (User) paramObject;
            controller.create(user.getLastName(), user.getFirstName(), user.getMiddleName(), user.getBirthDate());
        }

        System.out.println("Студент успешно добавлен.");
    }
}
