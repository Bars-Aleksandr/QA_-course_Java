//SRP, OCP
package Core.MVC.view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SimpleDateFormatter implements DateFormatter{
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    @Override
    public String format(LocalDate date) {
        return date.format(formatter);
    }

}
