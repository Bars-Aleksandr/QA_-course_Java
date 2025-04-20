package view;


import model.Student;
import model.Teacher;
import model.User;

public class View {
    public void printUserOnConsole(User user) {
       if (user instanceof Student) {
             System.out.println((Student) user);
       }
       if (user instanceof Teacher) {
            System.out.println((Teacher) user);
       }
    }
}
