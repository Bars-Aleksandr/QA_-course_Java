package Test;

import sem3tasks.Controller;
import sem3tasks.Main;
import sem3tasks.Student;
import sem3tasks.StudyGroup;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

public class ControllerTest {
    private Controller controllerTest;
    private StudyGroup studyGroupTest = new StudyGroup();
    protected StudyGroup etalonStudyGroup = new StudyGroup();

    @BeforeEach
    public void setUp() {

        int numStudents = 5;
        for (int i = 0; i < numStudents; i++) {
            Student studentRND = new Student(i + 1, Main.generateFirstName(), Main
                    .generateLastName(),
                    Main.generateFatherName(),
                    Main.generateBirthDate());
            studyGroupTest.addStudent(studentRND);
            etalonStudyGroup.addStudent(studentRND);
        }
        Student studentConst = new Student(6, "Барсуков", "Данила", "Александрович", "10.09.2008");
        studyGroupTest.addStudent(studentConst);
        controllerTest = new Controller(studyGroupTest);
    }

    @Test
    public void testingMethodRemoveStudentByFio() {
        controllerTest.removeStudentByFio("Барсуков", "Данила", "Александрович");
        assertThat(studyGroupTest.getStudentsList()).isEqualTo(etalonStudyGroup.getStudentsList());
        assertThat(studyGroupTest.size()).isEqualTo(5);

    }

    @Test
    public void testingMethodRemoveStudentByFIOWithoutFIO() {

        assertThrows(NoSuchElementException.class,
                () -> controllerTest.removeStudentByFio("Барсуков2", "Данила", "Александрович"));
        assertEquals("Student not found", assertThrows(NoSuchElementException.class,
                () -> controllerTest.removeStudentByFio("Барсуков2", "Данила", "Александрович")).getMessage());
    }
}
