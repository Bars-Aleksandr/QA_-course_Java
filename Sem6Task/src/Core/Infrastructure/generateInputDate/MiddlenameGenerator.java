//аналогично BirthdateGenerator
//Он имеет единственную ответственность.
//Он расширяет базовый тип через наследование.
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
    public String dataNamesGenerator() {
        return middlenames[random.nextInt(middlenames.length)];
    }

}
