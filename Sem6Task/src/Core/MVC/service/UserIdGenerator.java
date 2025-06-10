//SOLID
package Core.MVC.service;

import Core.MVC.models.User;
import Core.MVC.service.Interfaces.IdGenerator;

public class UserIdGenerator implements IdGenerator<User> {
    private Long currentStudentID = 0L;

    @Override
    public Long getNextUserID() {
        return currentStudentID;

    }

}
