// Применяем принцип Single responsibility и LSP Student и Teacher расширяют User, и всё выглядит корректно. Они используют базовые поля и методы без нарушения контрактов.
// Student и Teacher наследуется от User поэтому все общие поля переносим в User 

package Core.MVC.models;

import java.time.LocalDate;




public class Student extends User implements Comparable<Student> {
    private final Long studentId;

    public Student(Long id, String firstName, String lastName, String middleName, LocalDate birthDate) {
        super(firstName, lastName, middleName, birthDate);
        this.studentId = id;
    }

    public Student(Long studentId, String firstName, String lastName, String middleName, String birthDateString) {
        super(firstName, lastName, middleName, birthDateString);
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
