package model;

public class Student extends User {

    private Long studentId = 0l;
    // private int lastStudentId = 0;

    // private Student(String firstName, String lastName, String middleName, String
    // birthDate) {
    // super(firstName, lastName, middleName, birthDate);
    // this.studentId = Long.valueOf(lastStudentId) + 1L;
    // }

    public Student() {

    }

    private Student(Long id, String firstName, String lastName, String middleName, String birthDate) {
        super(firstName, lastName, middleName, birthDate);
        this.studentId = id;
    }

    public static Student createStudent(Long id, String firstName, String lastName, String middleName,
            String birthDate) {
        return new Student(id, firstName, lastName, middleName, birthDate);
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long id) {
        this.studentId = id;
    }

    @Override
    public String toString() {
        return String.format("%2d   %-15s  %-15s  %-15s  %s", this.studentId,
                super.getFirstName(), super.getLastName(), super.getMiddleName(),
                super.getBirthDate().format(getFormatter()));
    }
}
