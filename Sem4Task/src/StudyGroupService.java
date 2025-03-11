import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class StudyGroupService {

    private Student student;
    private StudyGroup studyGroup = new StudyGroup();

    public StudyGroupService() {

    }

    public StudyGroupService(StudyGroup studyGroup) {
        this.studyGroup = studyGroup;
    }

    public StudyGroup getStudyGroup() {
        return this.studyGroup;
    }

    public void removeStudentByFio(String firstName, String lastName, String middleName,
            StudyGroup studyGroup) {
        Iterator<Student> iterator = studyGroup.iterator();
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

    public void sortStudentsById(StudyGroup studyGroup) {
        Collections.sort(studyGroup.getStudentsList());
    }

    public void shuffleStudyGroup(StudyGroup studyGroup) {
        Collections.shuffle(studyGroup.getStudentsList());
    }

    public void sortStudyGroupByFIO(StudyGroup studyGroup) {
        List<Student> studentList = new ArrayList<>(studyGroup.getStudentsList());
        Collections.sort(studentList, new UserComparator<Student>());
        studyGroup.setStudents(studentList);
    }

    public void addStudentInStudyGroup(String firstName, String lastName, String middleName, String birthDayStr) {
        Long i = Long.valueOf(studyGroup.size());
        Student student = new Student(i, firstName, lastName, middleName, birthDayStr);
        studyGroup.addStudent(student);
    }

    public void printStudents(StudyGroup studyGroup) {
        studyGroup.printStudents();
    }
}
