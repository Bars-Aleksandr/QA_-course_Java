package Core.MVC.service;

import Core.MVC.models.Teacher;
import Core.MVC.service.Interfaces.IdGenerator;

public class TeacherIdGenerator implements IdGenerator<Teacher> {

    private Long currentID = 0L;

    @Override
    public Long getNextUserID() {
        return ++currentID;
    }

}
