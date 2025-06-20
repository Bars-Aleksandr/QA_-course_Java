//SRP, OCP, DIP
package Core.MVC.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Core.Infrastructure.UserComparator;
import Core.MVC.models.Teacher;

public class TeachersService {
    private final TeacherBuilder teacherBuilder;
    private final List<Teacher> teachers = new ArrayList<>();

    public TeachersService(TeacherBuilder teacherBuilder) {
        this.teacherBuilder = teacherBuilder;

    }

    public void addUser(Teacher teacher) {
        this.teachers.add(teacher);
    }

    public List<Teacher> getUserList() {
        return this.teachers;
    }

    public void sortUserByFIO() {
        Collections.sort(teachers, new UserComparator<Teacher>());
    }

    public Teacher createUser(String lastName, String firstName, String middleName, LocalDate birthday) {
        return teacherBuilder.createUser(lastName, firstName, middleName, birthday);
    }
}
