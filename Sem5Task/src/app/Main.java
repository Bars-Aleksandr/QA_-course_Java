package app;

import model.Student;
import model.Teacher;
import service.DataService;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello, World!");
        DataService dataService = new DataService();

        Student student1 = dataService.createStudent("Барсуков", "Александр", "Сергеевич", "11.04.1983");
        Student student2 = dataService.createStudent("Барсуков", "Антон", "Александрович", "29.11.2011");
        dataService.addStudentToListByFullName("Барсуков", "Данила", "Александрович", "10.09.2015");
        dataService.addStudentToList(student1);
        dataService.addStudentToList(student2);
        for (Student student : dataService.getStudentsList()) {
            System.out.println(student);
        }
        System.out.println("readStudentById");
        System.out.println(dataService.readStudentFromListById(3L));

        Teacher teacher1 = dataService.createTeacher("Иванов", "Константин", "Петрович", "01.02.2014");
        System.out.println(teacher1);
        Teacher teacher2 = dataService.createTeacher("Смирнов", "Иван", "Аянович", "01.02.2014");
        System.out.println(teacher2);
    }
}
