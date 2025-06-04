// Поддержка принципа Dependency Inversion Principle (DIP).
// Контроллер зависит от абстракции (UserView<Student>), а не от конкретной реализации (StudentView)
package Core.MVC.controllers;

import java.time.LocalDate;
import java.util.List;

import Core.Infrastructure.generateInputDate.InputDataGeneration;
import Core.MVC.models.Student;
import Core.MVC.models.StudyGroup;
import Core.MVC.service.StudentService;
import Core.MVC.service.StudyGroupService;
import Core.MVC.service.Interfaces.IUserService;
import Core.MVC.service.Interfaces.IdGenerator;
import Core.MVC.view.IUserView;
import UI.commands.CommandService;

public class StudyGroupController implements IUserController<Student> {

    private final StudyGroupService studyGroupService;
    private final IUserView<Student> studentView;
    private final StudyGroup studyGroup;
    private final IUserService<Student> studentService;

    public StudyGroupController(StudyGroupService studyGroupService, IUserView<Student> studentView,
            StudyGroup studyGroup, StudentService studentService) {
        this.studyGroupService = studyGroupService;
        this.studentView = studentView;
        this.studyGroup = studyGroup;
        this.studentService = studentService;
    }
    
    public IUserService<Student> getStudentService(){
        return studentService;
    }
    public IUserView<Student> getStudentView() {
        return studentView;
    }

    public void populateStudyGroup(CommandService commandService, IdGenerator<Student> idGenerator,
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
    public void create(String firstName, String lastName, String middleName, LocalDate birthDayLD) {
        Student student = studentService.createUser(firstName, lastName, middleName, birthDayLD);
        this.studyGroupService.addStudentInStudyGroup(student);
    }

    @Override
    public void create(Student student) {
        this.studyGroupService.addStudentInStudyGroup(student);
    }

    public void removeStudentByFio(String firstName, String lastName, String middleName) {
        this.studyGroupService.removeStudentByFio(firstName, lastName, middleName);
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
