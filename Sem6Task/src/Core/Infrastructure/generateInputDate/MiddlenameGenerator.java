package Core.Infrastructure.generateInputDate;

public class MiddlenameGenerator extends InputDataGeneration{
    private final String[] middlenames = {
        "Иванович",
        "Петрович",
        "Сидорович",
        "Алексеевич",
        "Дмитриевич",
        "Сергеевич",
        "Николаевич",
        "Анатольевич",
        "Владимирович",
        "Юрьевич",
        "Фёдорович",
        "Григорьевич",
        "Викторович",
        "Михайлович",
        "Александрович"
};
    @Override
    public String dataGenerator() {
        return middlenames[random.nextInt(middlenames.length)];
    }

}
