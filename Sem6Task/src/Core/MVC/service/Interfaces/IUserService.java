package Core.MVC.service.Interfaces;

import java.time.LocalDate;


import Core.MVC.models.User;

public interface IUserService<T extends User> {
    User createUser(String firstName, String lastName, String middleName, LocalDate birthday);
    User createUser(String firstName, String lastName, String middleName, String birthday);

   
}
