package Core.MVC.service;

import Core.MVC.models.Student;
import Core.MVC.service.Interfaces.IdGenerator;

public class StudentIdGenerator implements IdGenerator<Student> {
    private Long currentID = 0L;

    @Override
    public Long getNextUserID() {
        return ++currentID;
    }
}
