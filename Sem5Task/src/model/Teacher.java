package model;

public class Teacher extends User {
    private Long teacherId = 0L;

    private Teacher(Long id, String firstName, String lastName, String middleName, String birthDate) {
        super(firstName, lastName, middleName, birthDate);
        this.teacherId = id;
    }

    public Teacher() {

    }

    public static Teacher createTeacher(Long id, String firstName, String lastName, String middleName,
            String birthDate) {
        return new Teacher(id, firstName, lastName, middleName, birthDate);
    }

    public Long getTeacherId() {
        return teacherId;
    }

    @Override
    public String toString() {
        return "User [Id=" + getTeacherId() + ", firstName=" + super.getFirstName() + ", lastName="
                + super.getLastName()
                + ", middleName=" + super.getMiddleName() + ", birthDate=" + super.getBirthDate().format(getFormatter())
                + "]";
    }

}
