//SRP:  хранит данные студента, предоставляет возможность сравнивать по ID и выводить экземпляр
//OCP:  класс легко расширять без изменения существующего кода.
// LSP: класс можно использовать класс Student вместо базового типа User.
//ISP:  классе реализуются только необходимые методы (toString(), compareTo()) и геттеры. Нет зависимости от ненужных интерфейсов или методов.

package Core.MVC.models;

import java.time.LocalDate;

import Core.MVC.view.DateFormatter;
import Core.MVC.view.SimpleDateFormatter;

public class Student extends User implements Comparable<Student> {
    private final Long studentId;
    private static final DateFormatter dateFormatter = new SimpleDateFormatter();

    public Student(Long id, String lastName, String firstName, String middleName, LocalDate birthDate) {
        super(lastName, firstName, middleName, birthDate);
        this.studentId = id;
    }

    public Student(Long studentId, String lastName, String firstName, String middleName, String birthDateString) {
        super(lastName, firstName, middleName, birthDateString);
        this.studentId = studentId;
    }

    public Long getStudentId() {
        return studentId;
    }

    private String getFormattedBirthDate() {
        return dateFormatter.format(getBirthDate());
    }

    @Override
    public String toString() {
        return String.format("%2d %-15s %-15s %-15s %s", studentId,
                getLastName(), getFirstName(), getMiddleName(), getFormattedBirthDate());
    }

    @Override
    public int compareTo(Student o) {
        return this.studentId.compareTo(o.studentId);
    }
}
