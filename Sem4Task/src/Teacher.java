import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Teacher extends User implements Comparable<Teacher> {
    private static Long teacherIdNext = 1L;
    private Long teacherId = Long.valueOf(0);
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public Teacher(String firstName, String lastName, String middleName, String birthDate) {
        super(firstName, lastName, middleName, birthDateStringToLocalDate(birthDate));
        this.teacherId = teacherIdNext++;
    }

    public Long getTeacherId() {
        return this.teacherId;
    }

    private static LocalDate birthDateStringToLocalDate(String birthDateStr) {

        try {
            return LocalDate.parse(birthDateStr, formatter);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Неверный формат даты рождения dd.mm.yyyy - " + birthDateStr, e);
        }
    }

    @Override
    public int compareTo(Teacher o) {
        return this.teacherId.compareTo(o.teacherId);
    }

    @Override
    public String toString() {
        return String.format("%2d %-15s %-15s %-15s %s", teacherId,
                getFirstName(), getLastName(), getMiddleName(), getBirthDate().format(formatter));
    }

}
