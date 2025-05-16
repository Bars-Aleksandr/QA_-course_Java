package Core.MVC.view;
import java.util.List;

import Core.MVC.models.Teacher;

public class TeacherView implements UserView<Teacher> {

    @Override
    public void sendOnConsole(List<Teacher> list) {
        for (Teacher teacher : list) {
            System.out.println(teacher);
        }
    }

}
