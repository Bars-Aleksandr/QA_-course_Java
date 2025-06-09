package Core.MVC.service;

import java.time.LocalDate;

import Core.MVC.models.Student;

import Core.MVC.service.Interfaces.IUserBuilder;
import Core.MVC.service.Interfaces.IdGenerator;

public class StudentBuilder implements IUserBuilder<Student> {
    private final IdGenerator<Student> idGenerator;

    public StudentBuilder(IdGenerator<Student> idGenerator) {
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