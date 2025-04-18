package controller;

import java.util.ArrayList;
import java.util.List;

import model.Student;
import model.StudyGroup;
import model.Teacher;
import model.Type;
import model.User;
import service.DataService;
import service.StudyGroupService;
import view.ConsoleView;
import view.Menu;
import view.View;
import view.StudentView;

public class Controller {
    private final DataService service;
    private final ConsoleView console;
    private View view;

    public ConsoleView getConsole() {
        return console;
    }

    private final StudentView viewStudent;
    private final StudyGroupService groupService = new StudyGroupService();
    private Menu applicationMenu;

    public Controller() {
        viewStudent = new StudentView();
        console = new ConsoleView();
        service = new DataService(controller.Config.pathDb);
        view = new View();
       
    }

    public void setMenu() {
        applicationMenu = new Menu(console.getScanner());
        applicationMenu.menu();
    }
    

    public void loadFromFile() {
        service.load();
    }

    public void saveInFile() {
        service.save();
    }

    public User createUser(String firstName, String lastName, String middleName, String birthdate, Type type) {
        return service.createUser(firstName, lastName, middleName, birthdate, type);
    }

    public void addUserToList(String firstName, String lastName, String middleName, String birthdate, Type type) {
        service.addUserToList(createUser(firstName, lastName, middleName, birthdate, type));
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
            viewStudent.printStudentOnConsole(student);
        }
    }
    public void printUsersOnConsole(List<User> users){
        for (User user : users) {
            view.printUserOnConsole(user);
        }
    }

    public StudyGroup createStudyGroup(Teacher teacher, List<Student> students) {
       return groupService.createStudyGroupService(teacher, students);

    }

    public List<User> getUsersListByType(Type type) {
        return service.getUsersListByType(type);

    }

    public List<User> getUsers(){
        return service.getUsersList();
    }

    public Teacher getTeacherByID(Long id) {
        return (Teacher) service.getUserFromListById(id, Type.TEACHER);
    }

    public void printStudyGroup(StudyGroup studyGroup) {
        groupService.printStudyGroupOnConsole(studyGroup);
  
    }
  

}
