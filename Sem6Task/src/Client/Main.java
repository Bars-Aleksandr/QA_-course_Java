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
import Core.MVC.service.StudentBuilder;
import Core.MVC.service.StudyGroupService;
import Core.MVC.service.TeacherBuilder;
import Core.MVC.service.StudentIdGenerator;
import Core.MVC.service.TeacherIdGenerator;
import Core.MVC.service.TeachersService;
import Core.MVC.service.Interfaces.IdGenerator;
import Core.MVC.view.IUserView;
import Core.MVC.view.StudentView;
import Core.MVC.view.TeacherView;
import UI.commands.CommandsStudyGroupService;
import UI.commands.CommandsTeacherService;
import UI.commands.UserInputHandler;
import UI.commands.BaseMenu.MenuInvoker;
import UI.commands.BaseMenu.StudentsMenu;
import UI.commands.BaseMenu.TeachersMenu;

import java.util.Scanner;

public class Main {

        /**
         * * В методе main происходит инициализация всех компонентов приложения,
         * настройка зависимостей и запуск меню.
         * 
         * @param входных параметров нет
         */
        public static void main(String[] args) {

                final Scanner scanner = new Scanner(System.in);

                final StudyGroup studyGroup = new StudyGroup();
                final IdGenerator<Student> idGenerator = new StudentIdGenerator();
                final IdGenerator<Teacher> idGeneratorTeacher = new TeacherIdGenerator();
                final StudentBuilder studentBuilder = new StudentBuilder(idGenerator);
                final TeacherBuilder teacherBuilder = new TeacherBuilder(idGeneratorTeacher);
                final StudyGroupService studyGroupService = new StudyGroupService(studentBuilder, studyGroup);
                final IUserView<Student> studentView = new StudentView();
                final IUserView<Teacher> teacherView = new TeacherView();
                final StudyGroupController studyGroupController = new StudyGroupController(studyGroupService,
                                studentView,
                                studyGroup, studentBuilder);

                final StudentsMenu studentsMenu = new StudentsMenu();
                final TeachersMenu teachersMenu = new TeachersMenu();
                final CommandsStudyGroupService studyGroupCommandService = new CommandsStudyGroupService();
                final TeachersService teacherService = new TeachersService(teacherBuilder);
                final TeacherController teacherController = new TeacherController(idGeneratorTeacher, teacherService,
                                teacherView, teacherBuilder);
                final CommandsTeacherService teachersCommandsService = new CommandsTeacherService(teacherController);
                final UserInputHandler handler = new UserInputHandler(scanner, studyGroupCommandService);
                final MenuInvoker menu = new MenuInvoker(handler, studyGroupCommandService, studentsMenu,
                                studyGroupController,
                                teacherController, teachersMenu, teachersCommandsService);

                studyGroupCommandService.registersCommand(studyGroupController);

                /**
                 * Метод для генерация тестовых данных для группы студентов
                 */
                studyGroupController.autoGenerateStudyGroup(studyGroupCommandService, idGenerator,
                                new FirstnameGenerator(),
                                new LastnameGenerator(), new MiddlenameGenerator(), new BirthdateGenerator());
                /**
                 * Метод для генерация списка учителей
                 */
                teacherController.autoGenerateTeachers(teachersCommandsService, idGeneratorTeacher, new LastnameGenerator(), new FirstnameGenerator(), new MiddlenameGenerator(), new BirthdateGenerator());
                menu.start();

                scanner.close();
        }
}
