//Single Responsibility (SRP):
//Класс отвечает только за хранение данных пользователя — соблюдает SRP.

//Open/Closed (OCP):
//Можно расширять, добавляя новые поля или методы без изменения существующего кода — соблюдается.
package UI.commands.BaseMenu;

public class UserDTO {
    private final String lastname;
    private final String firstname;
    private final String middlename;
    private final String birthdate;

    public UserDTO(String lastname, String firstname, String middlename, String birthdate) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.middlename = middlename;
        this.birthdate = birthdate;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public String getBirthdate() {
        return birthdate;
    }

}
