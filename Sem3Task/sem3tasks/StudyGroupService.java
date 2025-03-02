package sem3tasks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class StudyGroupService {

    private Student student;

    public StudyGroupService() {

    }

    public void removeStudentByFio(String firstName, String lastName, String middleName,
            StudyGroup studyGroup) {
        Iterator<Student> iterator = studyGroup.iterator();
        boolean itemRemoved = false;
        while (iterator.hasNext()) {

            student = iterator.next();
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)
                    && student.getmiddleName().equals(middleName)) {
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

    public void sortetStudyGroupByFIO(StudyGroup studyGroup) {
        List<Student> studentList = new ArrayList<>(studyGroup.getStudentsList());
        Collections.sort(studentList, new StudentComparator());
        studyGroup.setStudents(studentList);
    }
}
