package Core.MVC.service;

import java.time.LocalDate;
import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

import Core.Infrastructure.UserComparator;
import Core.MVC.models.Teacher;

import Core.MVC.service.Interfaces.IUserService;
import Core.MVC.service.Interfaces.IdGenerator;

public class TeacherService implements IUserService<Teacher> {
    private final List<Teacher> teachers = new ArrayList<>();
    private final IdGenerator<Teacher> idGenerator;

    public TeacherService(IdGenerator<Teacher> idGenerator) {
        this.idGenerator = idGenerator;
    }

    @Override
    public Teacher createUser(String firstName, String lastName, String middleName, LocalDate birthday) {
        return new Teacher(firstName, lastName, middleName, birthday,
                idGenerator.getNextUserID());
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
}
