//Применяем S – Single Responsibility (Принцип единственной ответственности), Liskov Substitution (L),
package Core.MVC.models;

import java.time.LocalDate;


public abstract class User {

    private String firstName;
    private String lastName;
    private String middleName;
    private LocalDate birthDate;
    

    public User(String firstName, String lastName, String middleName, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.birthDate = birthDate;
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
