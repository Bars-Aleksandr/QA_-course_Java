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
    private Student student = new Student();
    private Teacher teacher = new Teacher();

    private List<User> usersList;

    public DataService() {
        this.usersList = new ArrayList<User>();
    }

    public User createUser(String firstName, String lastName, String middleName, String birthDate, Type type) {
        Long id = createUserId(type);
        User newUser = new Student();
        if (Type.STUDENT.equals(type)) {
            newUser = Student.createStudent(id, firstName, lastName, middleName, birthDate);
        } else if (Type.TEACHER.equals(type)) {
            newUser = Teacher.createTeacher(id, firstName, lastName, middleName, birthDate);
        }
        return newUser;
    }

    public void addUserToList(User user) {
        usersList.add(user);
    }

    private Long createUserId(Type type) {
        Long id = 0L;
        if (Type.STUDENT.equals(type)) {
            id = student.getStudentId() + 1L;
        } else {
            id = teacher.getTeacherId() + 1L;
        }
        return id;
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
            if (user instanceof Student) {
                student = (Student) user;
                if (student.getStudentId().equals(id)) {
                    return student;
                }
            }
            if (user instanceof Teacher) {
                teacher = (Teacher) user;
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
