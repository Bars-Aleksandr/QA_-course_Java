// Применяем принцип Single responsibility
// Student и Teacher наследуется от User поэтому все общие поля переносим в User
//D — Dependency Inversion (Принцип инверсии зависимостей) объект getUserIdGenerator() создается через обстрактный класс
package Core.MVC.models;

import java.time.LocalDate;

public class Student extends User implements Comparable<Student> {
    private final Long studentId;

    public Student(String firstName, String lastName, String middleName, LocalDate birthDate) {
        super(firstName, lastName, middleName, birthDate);
        this.studentId = getUserIdGenerator().getNextUserID(Type.STUDENT);
    }

    public Student(Long studentId, String firstName, String lastName, String middleName, LocalDate birthDate) {
        super(firstName, lastName, middleName, birthDate);
        this.studentId = studentId;
    }

    public Long getStudentId() {
        return studentId;
    }


    @Override
    public String toString() {
        return String.format("%2d %-15s %-15s %-15s %s", studentId,
                getFirstName(), getLastName(), getMiddleName(), getBirthDate());
    }

    @Override
    public int compareTo(Student o) {
        return this.studentId.compareTo(o.studentId);
    }
}
