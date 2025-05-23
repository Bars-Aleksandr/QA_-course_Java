package Core.MVC.service.Interfaces;

import Core.MVC.models.User;


public interface IdGenerator<T extends User> {
    public Long getNextUserID();
    

}
