// Взять реализованный код в рамках семинара 4 и продемонстрировать применение принципов, 
// усвоенных на семинаре. Нужно в проекте прокомментировать участки кода, 
// которые рефакторим, какой принцип применяем и почему
// Формат сдачи: ссылка на гитхаб проект

//В main осталась только логика запуска цикла меню.
//Весь процесс инициализации вынесен в отдельный класс AppInitializer.
//Применяем принцип разделение ответственности (Single Responsibility Principle)
package Client;

import Core.Infrastructure.generateInputDate.FirstnameGenerator;
import Core.Infrastructure.generateInputDate.LastnameGenerator;
import Core.Infrastructure.generateInputDate.MiddlenameGenerator;
import Core.Infrastructure.generateInputDate.BirthdateGenerator;
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
import UI.commands.BaseMenu.StudentsMenu;
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

        final CommandService commandService = new CommandService();
        final UserInputHandler handler = new UserInputHandler(scanner, commandService);
        final StudyGroup studyGroup = new StudyGroup();
        final IdGenerator<Student> idGenerator = new StudentIdGenerator();
        final IdGenerator<Teacher> idGeneratorTeacher = new TeacherIdGenerator();
        final StudentService studentService = new StudentService(idGenerator);
        final TeacherService teacherService = new TeacherService(idGeneratorTeacher);
        final StudyGroupService studyGroupService = new StudyGroupService(studentService, studyGroup);
        final IUserView<Student> studentView = new StudentView();
        final IUserView<Teacher> teacherView = new TeacherView();
        final StudyGroupController studyGroupController = new StudyGroupController(studyGroupService, studentView,
                studyGroup, studentService);
        final TeacherController teacherController = new TeacherController(idGeneratorTeacher, teacherService, teacherView);
        commandService.registersCommand(studyGroupController);
        studyGroupController.populateStudyGroup(commandService, idGenerator, new FirstnameGenerator(),
                new LastnameGenerator(), new MiddlenameGenerator(), new BirthdateGenerator());
        final StudentsMenu studentsMenu = new StudentsMenu();
        final MenuInvoker menu = new MenuInvoker(handler, commandService, studentsMenu, studyGroupController,
                teacherController);

        menu.start();

        scanner.close();
    }
}
