package controller;

import java.util.ArrayList;
import java.util.List;

import model.Student;
import model.Type;
import model.User;
import service.DataService;
import view.StudentView;

public class Controller {
    private final DataService service = new DataService();
    private final StudentView view = new StudentView();

    public User createStudent(String firstName, String lastName, String middleName) {
        return service.createUser(firstName, lastName, middleName, middleName, Type.STUDENT);
    }

    public void addStudentToList(String firstName, String lastName, String middleName) {
        service.addUserToList(createStudent(firstName, lastName, middleName));
    }

    private List<Student> userListToStudentsList(List<User> users) {
        List<Student> students = new ArrayList<>();
        for (User user : users) {
            students.add((Student) user);
        }
        return students;
    }

    public List<Student> getAllStudentList() {
        List<User> students = new ArrayList<>();
        students = service.getUsersListByType(Type.STUDENT);
        return userListToStudentsList(students);
    }

    public void printStudentsListOnConsole(List<Student> students) {
        for (Student student : students) {
            view.printStudentOnConsole(student);
        }
    }
}
