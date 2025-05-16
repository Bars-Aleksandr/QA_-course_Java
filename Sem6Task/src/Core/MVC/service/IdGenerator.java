package Core.MVC.service;

import Core.MVC.models.Type;


public interface IdGenerator {
    Long getNextUserID(Type type);
    

}
