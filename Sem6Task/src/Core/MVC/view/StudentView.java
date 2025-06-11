package Core.MVC.view;
import java.util.List;

import Core.MVC.models.Student;

public class StudentView implements IUserView<Student> {

    @Override
    public void sendOnConsole(List<Student> list) {
        for (Student student : list) {
            System.out.println(student);
        }
    }

}
