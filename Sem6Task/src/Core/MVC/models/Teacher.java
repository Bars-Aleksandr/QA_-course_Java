// Применяем принципы  аналогично классу Student

package Core.MVC.models;



public class Teacher extends User implements Comparable<Teacher> {
    
    private Long teacherId = Long.valueOf(0);
  

    public Teacher(String firstName, String lastName, String middleName, String birthDateStr, Long id) {
        super(firstName, lastName, middleName, birthDateStr);
        this.teacherId = id;
    }

    

    public Long getTeacherId() {
        return this.teacherId;
    }

    // private static LocalDate birthDateStringToLocalDate(String birthDateStr) {

    //     try {
    //         return LocalDate.parse(birthDateStr, formatter);
    //     } catch (DateTimeParseException e) {
    //         throw new IllegalArgumentException("Неверный формат даты рождения dd.mm.yyyy - " + birthDateStr, e);
    //     }
    // }

    @Override
    public int compareTo(Teacher o) {
        return this.teacherId.compareTo(o.teacherId);
    }

    @Override
    public String toString() {
        return String.format("%2d %-15s %-15s %-15s %s", teacherId,
                getFirstName(), getLastName(), getMiddleName(), getBirthDate());
    }

}
