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
import UI.commands.BaseMenu.MenuInvoker;
import UI.commands.MenuStudentsCommands.CreateStudentCommand;
import UI.commands.MenuStudentsCommands.PrintStudentsCommand;
import UI.commands.MenuStudentsCommands.RemoveStudentByFioCommand;
import UI.commands.MenuStudentsCommands.SortStudentsByIdCommand;
import UI.commands.TeacherCommands.CreateTeacherCommand;

import java.time.LocalDate;

/**
 * Класс инициализации приложения.
 */
public class AppInitializer {

    // public  static Components initialize() {

    //     // Генераторы ID
    //     IdGenerator<Student> studentIdGen = new StudentIdGenerator();
    //     IdGenerator<Teacher> teacherIdGen = new TeacherIdGenerator();

    //     // Вьюхи
    //     IUserView<Student> studentView = new StudentView();
    //     IUserView<Teacher> teacherView = new TeacherView();

    //     // Сервисы
    //     StudentService studentService = new StudentService(studentIdGen);
    //     StudyGroup studyGroup = new StudyGroup();
    //     StudyGroupService studyGroupService = new StudyGroupService(studyGroup, studentService);
    //     TeacherService teacherService = new TeacherService(teacherIdGen);

    //     // Контроллеры
    //     StudyGroupController studyGroupController = new StudyGroupController(studyGroupService, studentView,
    //             studyGroup);
    //     TeacherController teacherController = new TeacherController(teacherIdGen, teacherService, teacherView);

        // Меню
        // MenuInvoker menu = new MenuInvoker();

        // // Регистрация команд для StudyGroup
        // menu.registerCommand(1,
        //         new CreateStudentCommand(studyGroupController, "Иван", "Иванов", "Иванович",
        //                 LocalDate.of(2000, 1, 15)));
        // menu.registerCommand(2,
        //         new RemoveStudentByFioCommand(studyGroupController, "Иван", "Иванов", "Иванович"));
        // menu.registerCommand(3,
        //         new SortStudentsByIdCommand(studyGroupController));
        // menu.registerCommand(4,
        //         new PrintStudentsCommand(studyGroupController));

        // // Регистрация команд для Учителя
        // menu.registerCommand(5,
        //         new CreateTeacherCommand(teacherController, "Петр", "Петров", "Петрович", LocalDate.of(1980, 5, 20)));

        // return new Components(menu, studyGroupController, teacherController);
    //}
}