// Поддержка принципа Dependency Inversion Principle (DIP).
// Контроллер зависит от абстракции (UserView<Student>), а не от конкретной реализации (StudentView)
package Core.MVC.controllers;

import java.time.LocalDate;
import java.util.List;

import Core.MVC.models.Student;
import Core.MVC.models.StudyGroup;

import Core.MVC.service.StudyGroupService;
import Core.MVC.view.IUserView;

public class StudyGroupController implements IUserController<Student> {


    private final StudyGroupService studyGroupService;
    private final IUserView<Student> studentView;
    private final StudyGroup studyGroup;


    public StudyGroupController(StudyGroupService studyGroupService, IUserView<Student> studentView,
            StudyGroup studyGroup) {
        this.studyGroupService = studyGroupService;
        this.studentView = studentView;
        this.studyGroup = studyGroup;
    }

    
    @Override
    public void create(String firstName, String lastName, String middleName, LocalDate birthDayStr) {
        this.studyGroupService.addStudentInStudyGroup(firstName, lastName, middleName, birthDayStr);
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
