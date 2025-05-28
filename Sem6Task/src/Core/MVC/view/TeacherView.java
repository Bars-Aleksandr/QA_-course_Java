package Core.MVC.view;
import java.util.List;

import Core.MVC.models.Teacher;

public class TeacherView implements IUserView<Teacher> {

    @Override
    public void sendOnConsole(List<Teacher> list) {
        for (Teacher teacher : list) {
            System.out.println(teacher);
        }
    }

    @Override
    public void printFirstnameText() {
         System.out.println("Введите имя учителя");
    }

    @Override
    public void printLastnameText() {
        System.out.println("Введите фамилию учителя");
    }

    @Override
    public void printMiddlenameText() {
        System.out.println("Введите отчество учителя");
    }

    @Override
    public void printBirthdateText() {
        System.out.println("Введите дату рождения учителя");
    }

}
