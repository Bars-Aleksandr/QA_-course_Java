package Core.Infrastructure.generateInputDate;

public class FirstnameGenerator  extends InputDataGeneration{
    private final String[] firstNames = {"Иванов", "Петров", "Сидоров", "Смирнов", "Кузнецов",
                "Волков", "Попов", "Сафонов", "Фёдоров", "Михайлов",
                "Аlekseev", "Николаев", "Захаров", "Белов", "Григорьев",
                "Семенов", "Ковалев", "Степанов", "Никифоров", "Дорофеев",
                "Филиппов", "Юрьев", "Тихонов", "Лебедев", "Крылов",
                "Марков", "Скворцов", "Медведев", "Тарасов", "Сидорук"};

        @Override
        public String dataNamesGenerator() {
            return firstNames[random.nextInt(firstNames.length)];
    }

}
