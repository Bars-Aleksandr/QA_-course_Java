package Core.MVC.controllers;

import Core.MVC.models.User;

public interface UserController<T extends User> {

    void create(String firstName, String lastName, String middleName, String string);

}
