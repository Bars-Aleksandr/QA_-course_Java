// Поддержка принципа Dependency Inversion Principle (DIP).
// Контроллер зависит от абстракции (UserView<Student>), а не от конкретной реализации (StudentView)
package Core.MVC.controllers;

import java.time.LocalDate;
import java.util.List;

import Core.Infrastructure.generateInputDate.InputDataGeneration;
import Core.MVC.models.Student;
import Core.MVC.models.StudyGroup;
import Core.MVC.service.StudentBuilder;
import Core.MVC.service.StudyGroupService;
import Core.MVC.service.Interfaces.IUserBuilder;
import Core.MVC.service.Interfaces.IdGenerator;
import Core.MVC.view.IUserView;

import UI.commands.CommandsStudyGroupService;

public class StudyGroupController implements IUserController<Student> {

    private final StudyGroupService studyGroupService;
    private final IUserView<Student> studentView;
    private final StudyGroup studyGroup;
    private final IUserBuilder<Student> studentBuilder;

    public StudyGroupController(StudyGroupService studyGroupService, IUserView<Student> studentView,
            StudyGroup studyGroup, StudentBuilder studentBuilder) {
        this.studyGroupService = studyGroupService;
        this.studentView = studentView;
        this.studyGroup = studyGroup;
        this.studentBuilder = studentBuilder;
    }
    
    public IUserBuilder<Student> getStudentBuilder(){
        return studentBuilder;
    }
    public IUserView<Student> getStudentView() {
        return studentView;
    }

    public void autoGenerateStudyGroup(CommandsStudyGroupService commandService, IdGenerator<Student> idGenerator,
            InputDataGeneration firstNameGenerator, InputDataGeneration lastNameGenerator,
            InputDataGeneration middleNameGenerator, InputDataGeneration birthdayGenerator) {
        for (int i = 0; i < 10; i++) {
            commandService.executeCommand(2,
                    new Student(idGenerator.getNextUserID(), firstNameGenerator.dataNamesGenerator(),
                            lastNameGenerator.dataNamesGenerator(),
                            middleNameGenerator.dataNamesGenerator(), birthdayGenerator.dataNamesGenerator()));
        }
    }

    @Override
    public void create(String lastName, String firstName, String middleName, LocalDate birthDayLD) {
        Student student = studentBuilder.createUser(lastName, firstName, middleName, birthDayLD);
        this.studyGroupService.addStudentInStudyGroup(student);
    }

    @Override
    public void create(Student student) {
        this.studyGroupService.addStudentInStudyGroup(student);
    }

    public void removeStudentByFio(String lastName, String firstName, String middleName) {
        this.studyGroupService.removeStudentByFio(lastName, firstName, middleName);
    }

    public void sortStudentsById() {
        this.studyGroupService.sortStudentsById();
    }

    public void shuffleStudyGroup() {
        this.studyGroupService.shuffleStudyGroup();
    }

    public void sortStudyGroupByFIO() {
        this.studyGroupService.sortStudyGroupByFIO();
    }

    public StudyGroup getStudyGroup() {
        return this.studyGroupService.getStudyGroup();
    }

    public void printStudyGroupStudents() {
        this.studyGroupService.printStudents(studyGroup);
    }

    public void sendOnConsoleStudentsList(List<Student> studentList) {
        studentView.sendOnConsole(studentList);
    }
}
