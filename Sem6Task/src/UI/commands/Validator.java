package UI.commands;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Validator {
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public LocalDate parseStrDateTLocalDate(String dateString) {
        try {
            LocalDate dateLocalDate = LocalDate.parse(dateString, formatter);
            return dateLocalDate;
        } catch (DateTimeParseException e){
            throw new IllegalArgumentException("Неверный формат даты");
        }

        
    }

}
