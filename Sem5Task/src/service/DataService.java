package service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import model.Student;
import model.Teacher;
import model.Type;
import model.User;

public class DataService {

    private List<User> usersList;
    private static Long lastStudentId = 0L;
    private static Long lastTeacherId = 0L;
    private FileService fileService;

    public DataService(String path) {
        this.usersList = new ArrayList<>();
        this.fileService = new FileService(path);
    }

    public void load() {
        usersList = fileService.load();
        checkID();
    }

    public void save() {
        fileService.save(usersList);
    }
    
    private void checkID(){
        for (User user : usersList) {
            if (user instanceof Student) {
                lastStudentId++;
            }
            if (user instanceof Teacher) {
                lastTeacherId++;
            }
        }
    }

    public User createUser(String firstName, String lastName, String middleName, String birthDate, Type type) {
        Long id = createUserLastId(type);
        User newUser;
        
        if (Type.STUDENT.equals(type)) {
            newUser = Student.createStudent(id, firstName, lastName, middleName, birthDate);
        } else if (Type.TEACHER.equals(type)) {
            newUser = Teacher.createTeacher(id, firstName, lastName, middleName, birthDate);
        } else {
            throw new IllegalArgumentException("Unknown user type: " + type);
        }
        return newUser;
    }


    private Long createUserLastId(Type type) {

        if (Type.STUDENT.equals(type)) {
            return ++lastStudentId;
        } else {
            return ++lastTeacherId;
        }
    }

    public void addUserToList(User user) {
        usersList.add(user);
    }
    public void addUserToListByFullName(String firstName, String lastName, String middleName, String birthDate,
            Type type) {
        User user = createUser(firstName, lastName, middleName, birthDate, type);
        addUserToList(user);
    }

    public User getUserFromListById(Long id, Type type) {
        Iterator<User> iterator = usersList.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user instanceof Student && type.equals(Type.STUDENT)) {
                Student student = (Student) user;
                if (student.getStudentId().equals(id)) {
                    return student;
                }
            }
            if (user instanceof Teacher && type.equals(Type.TEACHER)) {
                Teacher teacher = (Teacher) user;
                if (teacher.getTeacherId().equals(id)) {
                    return teacher;
                }
            }

        }

        throw new NoSuchElementException(type + " with ID " + id + " not found");

    }

    public List<User> getUsersList() {
        return this.usersList;
    }

    public List<User> getUsersListByType(Type type) {
        List<User> users = new ArrayList<>();

        for (User user : usersList) {
            if (user instanceof Teacher && type == Type.TEACHER) {
                users.add(user);
            } else if (user instanceof Student && type == Type.STUDENT) {
                users.add(user);
            }
        }

        return users;
    }

}
