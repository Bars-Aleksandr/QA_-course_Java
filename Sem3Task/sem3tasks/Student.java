package sem3tasks;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Student implements Comparable<Student> {
    private int studentId;
    private String firstName;
    private String lastName;
    private String middleName;
    private LocalDate birthDate;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public Student() {

    }

    public Student(int studentId, String firstName, String lastName, String middleName, String birthDateString) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.birthDate = birthDateStringToLocalDate(birthDateString);
    }

    private LocalDate birthDateStringToLocalDate(String birthDateStr) {

        try {
            return LocalDate.parse(birthDateStr, formatter);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Неверный формат даты рождения dd.mm.yyyy - " + birthDateStr, e);
        }
    }

    public int getStudentId() {
        return studentId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getmiddleName() {
        return middleName;
    }

    public void setBirthDate(String birthDateString) {
        this.birthDate = birthDateStringToLocalDate(birthDateString);
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public String toString() {
        return String.format("%2d   %-15s  %-15s  %-15s  %s", studentId,
                firstName, lastName, middleName, birthDate.format(formatter));
    }

    @Override
    public int compareTo(Student o) {

        return Integer.valueOf(this.studentId).compareTo(o.studentId);
    }

}
