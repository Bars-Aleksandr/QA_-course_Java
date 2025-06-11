package Core.MVC.service;


import Core.MVC.models.Type;
import Core.MVC.models.User;
import Core.MVC.service.Interfaces.IdGenerator;


public class UserIdGenerator implements IdGenerator<User>{
    private Long currentStudentID = 0L;
    private Long currentTeacherID = 0L;

    @Override
    public Long getNextUserID() {
        return currentStudentID;
        
        // if (Type.STUDENT.equals(type)) {
        //     return ++currentStudentID;    
        // } else{
        //     return ++currentTeacherID;
        // }       
    }

}
