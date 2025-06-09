package Core.MVC.service.Interfaces;

import java.time.LocalDate;


import Core.MVC.models.User;

public interface IUserBuilder<T extends User> {
    T createUser(String firstName, String lastName, String middleName, LocalDate birthday);
    T createUser(String firstName, String lastName, String middleName, String birthday);

   
}
