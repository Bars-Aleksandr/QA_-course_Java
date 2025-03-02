package sem3tasks;

import java.util.Random;

public class Main {
    public static Random random = new Random();

    public static void main(String[] args) {

        StudyGroup studyGroup;
        PotokStudyGroup potokStudyGroup = new PotokStudyGroup();

        int numStudyGroup = 5;
        for (int j = 0; j < numStudyGroup; j++) {
            studyGroup = new StudyGroup();
            int numStudents = random.nextInt(10);
            for (int i = 0; i < numStudents; i++) {
                Student studentRND = new Student(i + 1, generateFirstName(), generateLastName(), generateFatherName(),
                        generateBirthDate());
                studyGroup.addStudent(studentRND);
            }
            potokStudyGroup.addPotokStudyGroup(studyGroup);
        }
        Controller controller = new Controller();
        System.out.println("Printing potoks");
        controller.printAllStudyGroups(potokStudyGroup);
        System.out.println("Potoks sorting");
        controller.sortPotokStudyGroupByQuantity(potokStudyGroup);
        controller.printAllStudyGroups(potokStudyGroup);

    }

    public static String generateBirthDate() {
        int year = 2000 + random.nextInt(25);
        int month = random.nextInt(12) + 1;

        if (year > 2025 - 17) {
            year = 2025 - 17;
        }

        int day;

        if (month == 2) {
            if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                day = random.nextInt(29) + 1;
            } else {
                day = random.nextInt(28) + 1;
            }
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            day = random.nextInt(30) + 1;
        } else {
            day = random.nextInt(31) + 1;
        }

        return String.format("%02d.%02d.%04d", day, month, year);
    }

    public static String generateFatherName() {
        String[] fatherName = {
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
        return fatherName[random.nextInt(fatherName.length)];
    }

    public static String generateLastName() {
        String[] lastNames = {
                "Александр", "Сергей", "Дмитрий", "Андрей", "Иван",
                "Максим", "Никита", "Станислав", "Денис", "Вадим",
                "Евгений", "Павел", "Григорий", "Артем", "Роман",
                "Игорь", "Анатолий", "Константин", "Юрий", "Виктор",
                "Станислав", "Федор", "Валентин", "Михаил", "Тимур",
                "Станислав", "Арсений", "Давид", "Олег", "Кирилл"
        };
        return lastNames[random.nextInt(lastNames.length)];
    }

    public static String generateFirstName() {
        String[] firstNames = {
                "Иванов", "Петров", "Сидоров", "Смирнов", "Кузнецов",
                "Волков", "Попов", "Сафонов", "Фёдоров", "Михайлов",
                "Аlekseev", "Николаев", "Захаров", "Белов", "Григорьев",
                "Семенов", "Ковалев", "Степанов", "Никифоров", "Дорофеев",
                "Филиппов", "Юрьев", "Тихонов", "Лебедев", "Крылов",
                "Марков", "Скворцов", "Медведев", "Тарасов", "Сидорук"
        };
        return firstNames[random.nextInt(firstNames.length)];

    }

}
