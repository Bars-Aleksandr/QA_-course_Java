// аналогично классу StudyGroupController
package Core.MVC.controllers;

import java.time.LocalDate;
import java.util.List;

import Core.Infrastructure.generateInputDate.InputDataGeneration;
import Core.MVC.models.Teacher;

import Core.MVC.service.TeachersService;
import Core.MVC.service.Interfaces.IdGenerator;
import Core.MVC.view.IUserView;
import UI.commands.CommandsTeacherService;

public class TeacherController implements IUserController<Teacher> {
    private final TeachersService teacherService;
    private final IUserView<Teacher> teacherView;

    public TeacherController(IdGenerator<Teacher> idGenerator, TeachersService teacherService,
            IUserView<Teacher> teacherView) {
        this.teacherService = teacherService;
        this.teacherView = teacherView;

    }

    /**
     * Метод необходим только для автоматической подготовки тестовых данных.
     * 
     * @param commandService
     * @param idGenerator
     * @param lastNameGenerator
     * @param firstNameGenerator
     * @param middleNameGenerator
     * @param birthdayGenerator
     */
    public void autoGenerateTeachers(CommandsTeacherService commandService, IdGenerator<Teacher> idGenerator,
            InputDataGeneration lastNameGenerator, InputDataGeneration firstNameGenerator,
            InputDataGeneration middleNameGenerator, InputDataGeneration birthdayGenerator) {
        for (int i = 0; i < 5; i++) {
            commandService.executeCommand(2,
                    new Teacher(lastNameGenerator.dataNamesGenerator(),
                            firstNameGenerator.dataNamesGenerator(),
                            middleNameGenerator.dataNamesGenerator(), birthdayGenerator.dataNamesGenerator(),
                            idGenerator.getNextUserID()));
        }
    }

    @Override
    public void create(String firstName, String lastName, String middleName, LocalDate birthday) {
        teacherService.addUser(teacherService.createUser(firstName, lastName, middleName, birthday));

    }

    @Override
    public void create(Teacher user) {
        teacherService.addUser(user);
    }

    public List<Teacher> getTeacherList() {
        return teacherService.getUserList();
    }

    public void sendOnConsoleTeacherList() {
        teacherView.sendOnConsole(getTeacherList());
    }

    public void sortTeachersByFIO() {
        teacherService.sortUserByFIO();
    }

    public IUserView<Teacher> getTeacherView() {
        return teacherView;
    }

}
