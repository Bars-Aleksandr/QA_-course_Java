// Применяем принцип Single responsibility
// Student и Teacher наследуется от User поэтому все общие поля переносим в User
package Core.MVC.models;


public class Student extends User implements Comparable<Student> {
    private Long studentId = Long.valueOf(0);

    public Student(String firstName, String lastName, String middleName, String birthDate) {
        super(firstName, lastName, middleName, birthDate);
        this.studentId++;
    }

    public Student(Long studentId, String firstName, String lastName, String middleName, String birthDate) {
        super(firstName, lastName, middleName, birthDate);
        this.studentId = studentId;
    }

    public Long getStudentId() {
        return studentId;
    }

    // private static LocalDate birthDateStringToLocalDate(String birthDateStr) {

    //     try {
    //         return LocalDate.parse(birthDateStr, formatter);
    //     } catch (DateTimeParseException e) {
    //         throw new IllegalArgumentException("Неверный формат даты рождения dd.mm.yyyy - " + birthDateStr, e);
    //     }
    // }

    @Override
    public String toString() {
        return String.format("%2d %-15s %-15s %-15s %s", studentId,
                getFirstName(), getLastName(), getMiddleName(), getBirthDate().formatted(formatter));
    }

    @Override
    public int compareTo(Student o) {
        return this.studentId.compareTo(o.studentId);
    }
}
