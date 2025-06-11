//Применяем S – Single Responsibility (Принцип единственной ответственности), Liskov Substitution (L),
package Core.MVC.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class User {

    private String firstName;
    private String lastName;
    private String middleName;
    private LocalDate birthDate;

    public User(String firstName, String lastName, String middleName, String birthDateStr) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.birthDate = LocalDate.parse(birthDateStr, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public User(String firstName, String lastName, String middleName, LocalDate birthDateLD) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.birthDate = birthDateLD;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;

    }

}
