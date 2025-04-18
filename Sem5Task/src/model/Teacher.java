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
        return String.format("%3d   %-15s  %-15s  %-15s  %s", this.teacherId,
                super.getFirstName(), super.getLastName(), super.getMiddleName(),
                super.getBirthDate().format(getFormatter()));
    }
}
