//SRP, OCP, ISP, DIP
package Core.MVC.service;

import java.time.LocalDate;

import Core.MVC.models.Teacher;

import Core.MVC.service.Interfaces.IUserBuilder;
import Core.MVC.service.Interfaces.IdGenerator;

public class TeacherBuilder implements IUserBuilder<Teacher> {

    private final IdGenerator<Teacher> idGenerator;

    public TeacherBuilder(IdGenerator<Teacher> idGenerator) {
        this.idGenerator = idGenerator;
    }

    @Override
    public Teacher createUser(String lastName, String firstName, String middleName, LocalDate birthday) {
        return new Teacher(lastName, firstName, middleName, birthday,
                idGenerator.getNextUserID());
    }

    @Override
    public Teacher createUser(String lastName, String firstName, String middleName, String birthday) {
        return new Teacher(lastName, firstName, middleName, birthday, idGenerator.getNextUserID());
    }
}
