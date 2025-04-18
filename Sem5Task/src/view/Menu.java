package view;

import java.util.Scanner;

import controller.Controller;
import model.StudyGroup;
import model.Teacher;
import model.Type;

public class Menu {
    Scanner in;
    private final Controller controller = new Controller();;

    public Menu(Scanner scanner) {
        in = scanner;
    }

    private void itemMenuApp() {
        System.out.println("Выберите действие:");
        System.out.println("1. Файл");
        System.out.println("2. Создание и просмотр участников");
        System.out.println("3. Выход");
    }

    private void menuFile() {
        System.out.println("1. Чтение из файла списка");
        System.out.println("2. Сохрание списка в файл");
    }

    private void menuCreateViewUsers() {
        System.out.println("1. Добавление студента в список");
        System.out.println("2. Добавление учителя в список");
        System.out.println("3. Просмотр всех студентов");
        System.out.println("4. Просмотр всех учителей");
        System.out.println("5. Просмотр всех пользователе");
        System.out.println("6. Создание учебной группы");
        System.out.println("7. Просмотр учебной группы");
    }

    public void menu() {
        boolean flag = true;
        String fName;
        String lName;
        String mName;
        String bDate;
        StudyGroup studyGroup = null;
        while (flag) {
            itemMenuApp();
            String key = in.next();
            System.out.print("\033[H\033[J");
            switch (key) {
                case "1":
                    menuFile();
                    key = in.next();
                    if (key.equals("1")) {
                        controller.loadFromFile();
                    }
                    if (key.equals("2")) {
                        controller.saveInFile();
                    }
                    break;
                case "2":
                    menuCreateViewUsers();
                    key = in.next();
                    switch (key) {
                        case "1":
                            fName = controller.getConsole().getFirstName();
                            lName = controller.getConsole().getLastName();
                            mName = controller.getConsole().getMiddleName();
                            bDate = controller.getConsole().getBirthdate();
                            controller.addUserToList(fName, lName, mName, bDate, Type.STUDENT);
                            break;
                        case "2":
                            fName = controller.getConsole().getFirstName();
                            lName = controller.getConsole().getLastName();
                            mName = controller.getConsole().getMiddleName();
                            bDate = controller.getConsole().getBirthdate();
                            controller.addUserToList(fName, lName, mName, bDate, Type.TEACHER);
                            break;
                        case "3":
                            controller.printStudentsListOnConsole(controller.getAllStudentList());
                            break;
                        case "4":
                            controller.printUsersOnConsole(controller.getUsersListByType(Type.TEACHER));
                            break;
                        case "5":
                            controller.printUsersOnConsole(controller.getUsers());
                            break;
                        case "6":
                            System.out.print("\033[H\033[J");
                            System.out.println("Выберите учителя из списка по ID");
                            controller.printUsersOnConsole(controller.getUsersListByType(Type.TEACHER));
                            int id = in.nextInt();
                            Teacher teacher = controller.getTeacherByID(Long.valueOf(id));
                            studyGroup = controller.createStudyGroup(teacher, controller.getAllStudentList());
                            System.out.println("Учебная группа сформировалась");
                            break;
                        case "7":
                            System.out.print("\033[H\033[J");
                            controller.printStudyGroup(studyGroup);
                            break;
                            default:
                                System.out.println("Такой команды нет");
                                break;
                    }

                    break;
                case "3":
                    flag = false;
                default:
                    System.out.println("Гуд Бай");
                    break;
            }
        }
    }
}
