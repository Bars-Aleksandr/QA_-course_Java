//SRP — Принцип единственной ответственности. Генерирует случайную дату рождения.
//OCP — Принцип открытости/закрытости. Класс можно расширять или изменять без изменения базового интерфейса
//LSP — Принцип подстановки Барбары Лисков. Объекты интерфейса InputDataGeneration можно использовать вместо базового типа.
//ISP — Принцип разделения интерфейсов.InputDataGeneration содержит только один метод, класс не зависит от ненужных методов.
package Core.Infrastructure.generateInputDate;

public class BirthdateGenerator extends InputDataGeneration {
    
    @Override
    public String dataNamesGenerator() {
        int year = 2000 + random.nextInt(17);
        int month = random.nextInt(12) + 1;
        int day = generateDay(month, year);
        return String.format("%02d.%02d.%04d", day, month, year);

     
    }

    private int generateDay(int month, int year){
        int day;
        if (month == 2) {
            day = (isLeapYear(year)) ? random.nextInt(29) + 1 : random.nextInt(28) + 1;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            day = random.nextInt(30) + 1;
        } else {
            day = random.nextInt(31) + 1;
        }
        return day;
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}