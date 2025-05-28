package Core.MVC.service;

import java.time.LocalDate;

import Core.MVC.models.Student;

import Core.MVC.service.Interfaces.IUserService;
import Core.MVC.service.Interfaces.IdGenerator;

public class StudentService implements IUserService<Student> {
    private final IdGenerator<Student> idGenerator;

    public StudentService(IdGenerator<Student> idGenerator) {
        this.idGenerator = idGenerator;

    }
    @Override
    public Student createUser(String firstName, String lastName, String middleName, LocalDate birthdayLD) {
        return new Student(idGenerator.getNextUserID(), firstName, lastName, middleName, birthdayLD);
    }
    @Override
    public Student createUser(String firstName, String lastName, String middleName, String birthdayStr) {
        return new Student(idGenerator.getNextUserID(), firstName, lastName, middleName, birthdayStr);
    }

}