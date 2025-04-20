package Core.MVC.controllers;
import java.util.List;

import Core.MVC.service.PotokStudyGroupService;
import Core.MVC.service.StudyGroupService;
import Core.MVC.view.StudentView;
import Core.MVC.view.models.PotokStudyGroup;
import Core.MVC.view.models.Student;
import Core.MVC.view.models.StudyGroup;


public class StudentController implements UserController<Student> {

    private StudyGroup studyGroup;
    private StudyGroupService studyGroupService = new StudyGroupService();
    private PotokStudyGroupService potokService = new PotokStudyGroupService();
    private StudentView studentView = new StudentView();

    public StudentController() {

    }

    public StudentController(StudyGroup studyGroup) {
        this.studyGroup = studyGroup;
    }

    public void removeStudentByFio(String firstName, String lastName, String middleName) {
        studyGroupService.removeStudentByFio(firstName, lastName, middleName, studyGroup);
    }

    public void sortStudentsById(StudyGroup studyGroup) {
        studyGroupService.sortStudentsById(studyGroup);
    }

    public void shuffleStudyGroup(StudyGroup studyGroup) {
        studyGroupService.shuffleStudyGroup(studyGroup);
    }

    public void sortStudyGroupByFIO(StudyGroup studyGroup) {
        studyGroupService.sortStudyGroupByFIO(studyGroup);
    }

    public void sortPotokStudyGroupByQuantity(PotokStudyGroup potokStudyGroup) {
        potokService.sortPotokStudyGroupByQuantity(potokStudyGroup);
    }

    public void printAllStudyGroups(PotokStudyGroup potokStudyGroup) {
        potokService.printAllStudyGroups(potokStudyGroup);
    }

    @Override
    public void create(String firstName, String lastName, String middleName, String birthDayStr) {
        studyGroupService.addStudentInStudyGroup(firstName, lastName, middleName, birthDayStr);
    }

    public StudyGroup getStudyGroup() {
        return this.studyGroupService.getStudyGroup();
    }

    public void printStudyGroupStudents(StudyGroup studyGroup) {
        studyGroupService.printStudents(studyGroup);
    }

    public void sendOnConsoleStudentsList(List<Student> studentList) {
        studentView.sendOnConsole(studentList);
    }
}
