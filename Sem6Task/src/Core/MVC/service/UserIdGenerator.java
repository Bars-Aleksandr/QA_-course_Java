package Core.MVC.service;


import Core.MVC.models.Type;


public class UserIdGenerator implements IdGenerator{
    private Long currentStudentID = 0L;
    private Long currentTeacherID = 0L;

    @Override
    public Long getNextUserID(Type type) {
        
        if (Type.STUDENT.equals(type)) {
            return ++currentStudentID;    
        } else{
            return ++currentTeacherID;
        }       
    }

}
