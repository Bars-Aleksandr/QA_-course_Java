// внедряю зависимости через через конструктор (использование Dependency Injection)
package Core.MVC.controllers;
import java.time.LocalDate;
import java.util.List;


import Core.MVC.models.Teacher;
import Core.MVC.models.Type;
import Core.MVC.service.TeacherService;
import Core.MVC.service.Interfaces.IdGenerator;
import Core.MVC.view.IUserView;

public class TeacherController implements IUserController<Teacher> {
    private final TeacherService service;
    private final IUserView<Teacher> teacherView;
    private final IdGenerator<Teacher> idGenerator;

    public TeacherController(IdGenerator<Teacher> idGenerator, TeacherService service, IUserView<Teacher> teacherView) {
        this.service = service;
        this.teacherView = teacherView;
        this.idGenerator = idGenerator;
    }


    @Override
    public void create(String firstName, String lastName, String middleName, LocalDate birthday) {
        service.addUser(service.createUser(firstName, lastName, middleName, birthday));
        
    }

    public List<Teacher> getTeacherList() {
        return service.getUserList();
    }

    public void sendOnConsoleTeacherList() {
        teacherView.sendOnConsole(getTeacherList());
    }

    public void sortTeachersByFIO() {
        service.sortUserByFIO();
    }

}
