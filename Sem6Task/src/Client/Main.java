// Взять реализованный код в рамках семинара 4 и продемонстрировать применение принципов, 
// усвоенных на семинаре. Нужно в проекте прокомментировать участки кода, 
// которые рефакторим, какой принцип применяем и почему
// Формат сдачи: ссылка на гитхаб проект

//В main осталась только логика запуска цикла меню.
//Весь процесс инициализации вынесен в отдельный класс AppInitializer.
//Применяем принцип разделение ответственности (Single Responsibility Principle)
package Client;

import Core.MVC.controllers.StudyGroupController;
import Core.MVC.controllers.TeacherController;
import Core.MVC.models.Student;
import Core.MVC.models.StudyGroup;
import Core.MVC.models.Teacher;
import Core.MVC.service.StudentService;
import Core.MVC.service.StudyGroupService;
import Core.MVC.service.TeacherService;
import Core.MVC.service.StudentIdGenerator;
import Core.MVC.service.TeacherIdGenerator;
import Core.MVC.service.Interfaces.IdGenerator;
import Core.MVC.view.IUserView;
import Core.MVC.view.StudentView;
import Core.MVC.view.TeacherView;
import UI.commands.CommandService;
import UI.commands.UserInputHandler;
import UI.commands.BaseMenu.MenuInvoker;
import UI.commands.MenuStudentsCommands.CreateStudentCommand;
import UI.commands.MenuStudentsCommands.PrintStudentsCommand;
import UI.commands.MenuStudentsCommands.RemoveStudentByFioCommand;
import UI.commands.MenuStudentsCommands.SortStudentsByIdCommand;
import UI.commands.TeacherCommands.CreateTeacherCommand;

import java.time.LocalDate;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        final Scanner scanner = new Scanner(System.in);
        final UserInputHandler handler = new UserInputHandler(scanner);
        final CommandService commandService = new CommandService();
        final MenuInvoker menu = new MenuInvoker(handler, commandService);
        menu.start();


        // // Основной цикл меню
        // while (true) {
        //     System.out.println("\nВыберите действие:");
        //     System.out.println("1 - Добавить студента");
        //     System.out.println("2 - Удалить студента по ФИО");
        //     System.out.println("3 - Отсортировать студентов по ID");
        //     System.out.println("4 - Вывести список студентов");
        //     System.out.println("5 - Добавить учителя");
        //     System.out.println("0 - Выход");

        //     int choice = scanner.nextInt();

        //     if (choice == 0)
        //         break;

        //     switch (choice) {
        //         case 1:
        //             // Можно дополнительно запрашивать параметры у пользователя
        //             break;
        //         case 2:
        //             break;
        //         case 3:
        //             break;
        //         case 4:
        //             break;
        //         case 5:
        //             break;
        //         default:
        //             System.out.println("Некорректный выбор");
        //     }

        //     menu.executeCommand(choice);
        // }
        scanner.close();
    }
}
