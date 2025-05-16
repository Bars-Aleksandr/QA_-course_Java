package Core.Infrastructure.generateInputDate;

public class LastnameGenerator extends InputDataGeneration{
    private final String[] lastnames = {"Александр", "Сергей", "Дмитрий", "Андрей", "Иван",
                "Максим", "Никита", "Станислав", "Денис", "Вадим",
                "Евгений", "Павел", "Григорий", "Артем", "Роман",
                "Игорь", "Анатолий", "Константин", "Юрий", "Виктор",
                "Станислав", "Федор", "Валентин", "Михаил", "Тимур",
                "Станислав", "Арсений", "Давид", "Олег", "Кирилл"};

    @Override
    public String dataGenerator() {
        return lastnames[random.nextInt(lastnames.length)];
    }

}
