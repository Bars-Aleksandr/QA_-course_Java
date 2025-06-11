package Core.MVC.service;
import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

import Core.Infrastructure.UserComparator;
import Core.MVC.models.Teacher;

public class TeacherService {
    private Teacher teacher;
    private List<Teacher> teachers = new ArrayList<>();

    public TeacherService() {

    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void addTeacherList(Teacher teacher) {
        this.teachers.add(teacher);
    }

    public Teacher createTeacher(String firstName, String lastName, String middleName, String birthday) {
        return new Teacher(firstName, lastName, middleName, birthday);
    }

    public List<Teacher> getTeacherList() {
        return teachers;
    }

    public void sortTeachetByFIO() {
        Collections.sort(getTeacherList(), new UserComparator<Teacher>());
    }
}
