package Core.MVC.view.models;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Student extends User implements Comparable<Student> {
    private Long studentId = Long.valueOf(0);
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public Student(String firstName, String lastName, String middleName, String birthDate) {
        super(firstName, lastName, middleName, birthDateStringToLocalDate(birthDate));
        this.studentId++;
    }

    public Student(Long studentId, String firstName, String lastName, String middleName, String birthDate) {
        super(firstName, lastName, middleName, birthDateStringToLocalDate(birthDate));
        this.studentId = studentId;
    }

    public Long getStudentId() {
        return studentId;
    }

    private static LocalDate birthDateStringToLocalDate(String birthDateStr) {

        try {
            return LocalDate.parse(birthDateStr, formatter);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Неверный формат даты рождения dd.mm.yyyy - " + birthDateStr, e);
        }
    }

    @Override
    public String toString() {
        return String.format("%2d %-15s %-15s %-15s %s", studentId,
                getFirstName(), getLastName(), getMiddleName(), getBirthDate().format(formatter));
    }

    @Override
    public int compareTo(Student o) {
        return this.studentId.compareTo(o.studentId);
    }
}
