package Core.MVC.controllers;

import java.time.LocalDate;

import Core.MVC.models.User;

public interface IUserController<T extends User> {

    void create(String firstName, String lastName, String middleName, LocalDate birthdate);

}
