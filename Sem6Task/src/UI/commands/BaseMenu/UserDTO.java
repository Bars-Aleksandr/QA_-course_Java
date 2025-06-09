package UI.commands.BaseMenu;

public class UserDTO {
    private String lastname;
    private String firstname;
    private String middlename;
    private String birthdate;

    public UserDTO(String lastname, String firstname, String middlename, String birthdate) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.middlename = middlename;
        this.birthdate = birthdate;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

}
