package Core.MVC.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import Core.Infrastructure.UserComparator;
import Core.MVC.models.Student;
import Core.MVC.models.StudyGroup;

public class StudyGroupService {

    private Student student;
    private StudyGroup studyGroup;
    private StudentService studentService;

    public StudyGroupService(StudyGroup studyGroup, StudentService studentService) {
        this.studyGroup = studyGroup;
        this.studentService = studentService;
    }

    public StudyGroup getStudyGroup() {
        return this.studyGroup;
    }

    public void removeStudentByFio(String firstName, String lastName, String middleName) {
        Iterator<Student> iterator = this.studyGroup.iterator();
        boolean itemRemoved = false;
        while (iterator.hasNext()) {
            student = iterator.next();
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)
                    && student.getMiddleName().equals(middleName)) {
                iterator.remove();
                itemRemoved = true;
            }

        }
        if (!itemRemoved) {
            throw new NoSuchElementException("Student not found");
        }
    }

    public void sortStudentsById() {
        Collections.sort(this.studyGroup.getStudentsList());

    }

    public void shuffleStudyGroup() {
        Collections.shuffle(this.studyGroup.getStudentsList());
    }

    public void sortStudyGroupByFIO() {
        List<Student> students = new ArrayList<>(this.studyGroup.getStudentsList());
        students.sort(new UserComparator<Student>());
        studyGroup.setStudents(students);
    }

    public void addStudentInStudyGroup(String firstName, String lastName, String middleName, LocalDate birthDayStr) {
        Student student = studentService.createUser(firstName, lastName, middleName, birthDayStr);
        this.studyGroup.addStudent(student);
    }

    public void printStudents(StudyGroup studyGroup) {
        studyGroup.printStudents();
    }
}
