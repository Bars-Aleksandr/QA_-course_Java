// Применяем принципы  аналогично классу Student

package Core.MVC.models;

import java.time.LocalDate;

import Core.MVC.view.SimpleDateFormatter;

public class Teacher extends User implements Comparable<Teacher> {
    
    private Long teacherId = Long.valueOf(0);
  

    public Teacher(String lastName, String firstName, String middleName, String birthDateStr, Long id) {
        super(lastName, firstName, middleName, birthDateStr);
        this.teacherId = id;
    }

    public Teacher(String lastName, String firstName, String middleName, LocalDate birthDate, Long id) {
        super(lastName, firstName, middleName, birthDate);
        this.teacherId = id;
    }

    public Long getTeacherId() {
        return this.teacherId;
    }

    private String getFormattedBirthDate() {
        return new SimpleDateFormatter().format(getBirthDate());
    }

    @Override
    public int compareTo(Teacher o) {
        return this.teacherId.compareTo(o.teacherId);
    }

    @Override
    public String toString() {
        return String.format("%2d %-15s %-15s %-15s %s", teacherId,
                getFirstName(), getLastName(), getMiddleName(), getFormattedBirthDate());
    }

}
