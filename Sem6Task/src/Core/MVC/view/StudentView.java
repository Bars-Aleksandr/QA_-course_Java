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
    @Override
    public void printFirstnameText(){
        System.out.println("Введите имя студента");
    }

    @Override
    public void printLastnameText(){
        System.out.println("Введите фамилию студента");
    }

    @Override
    public void printMiddlenameText(){
        System.out.println("Введите отчество студента");
    }
    
    @Override
    public void printBirthdateText(){
        System.out.println("Введите дату рождения (дд.мм.гггг):");
    }

}
