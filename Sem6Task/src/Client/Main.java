package Client;
// Создать класс УчительСервис и реализовать аналогично проедланному на семинаре

// Создать класс УчительВью и реализовать аналогично проедланному на семинаре

// Создать класс УчительКонтроллер и реализовать возможность создания,
// редактирования конкретного учителя и отображения списка учителей имеющихся в системе
import java.util.Random;

import Core.MVC.controllers.StudentController;
import Core.MVC.controllers.TeacherController;

public class Main {
    public static Random random = new Random();

    public static void main(String[] args) throws Exception {
        StudentController studentController = new StudentController();
        TeacherController teacherController = new TeacherController();

        int numStudents = random.nextInt(20) + 1;
        for (int i = 0; i < numStudents; i++) {
            studentController.create(generateFirstName(), generateLastName(), generateFatherName(),
                    generateBirthDate());
        }

        int numTeacher = random.nextInt(numStudents) + 1;

        for (int i = 0; i < numTeacher; i++) {
            teacherController.create(generateFirstName(), generateLastName(), generateFatherName(),
                    generateBirthDate());
        }

        studentController.create("Барсуков", "Александр", "Сергеевич", "11.04.1983");

        System.out.println("printStudentsStudyGroup");
        studentController.printStudyGroupStudents(studentController.getStudyGroup());

        System.out.println("list students");
        studentController.sendOnConsoleStudentsList(studentController.getStudyGroup().getStudentsList());

        System.out.println("shuffleStudyGroup");
        studentController.shuffleStudyGroup(studentController.getStudyGroup());
        studentController.sendOnConsoleStudentsList(studentController.getStudyGroup().getStudentsList());

        System.out.println("sorted by id");
        studentController.sortStudentsById(studentController.getStudyGroup());
        studentController.sendOnConsoleStudentsList(studentController.getStudyGroup().getStudentsList());

        System.out.println("sorted by FIO");
        studentController.sortStudyGroupByFIO(studentController.getStudyGroup());
        studentController.sendOnConsoleStudentsList(studentController.getStudyGroup().getStudentsList());

        System.out.println("Teacher list:");
        teacherController.sendOnConsoleTeacherList();

        teacherController.sortTeachersByFIO();
        System.out.println("Sorting teachers list");
        teacherController.sendOnConsoleTeacherList();
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
