package Test;

import sem3tasks.*;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StudyGroupTest {
    private StudyGroup studyGroupTest;
    private StudyGroupIterator studyGroupIterator;

    @BeforeEach
    public void setUp() {
        studyGroupTest = new StudyGroup();
        int numStudents = 5;
        for (int i = 0; i < numStudents; i++) {
            Student studentRND = new Student(i + 1, Main.generateFirstName(), Main
                    .generateLastName(),
                    Main.generateFatherName(),
                    Main.generateBirthDate());
            studyGroupTest.addStudent(studentRND);
        }
        studyGroupIterator = new StudyGroupIterator(studyGroupTest);

    }

    @Test
    void studentsAddedInStudyGroup() {

        assertThat(studyGroupTest.size()).isEqualTo(5);
    }

    @Test
    void testingMethodHasNextFromStudyGroup() {

        assertThat(studyGroupIterator.hasNext()).isTrue();
        studyGroupIterator.next();
        assertThat(studyGroupIterator.hasNext()).isTrue();
        studyGroupIterator.next();
        assertThat(studyGroupIterator.hasNext()).isTrue();
        studyGroupIterator.next();
        assertThat(studyGroupIterator.hasNext()).isTrue();
        studyGroupIterator.next();
        assertThat(studyGroupIterator.hasNext()).isTrue();
        studyGroupIterator.next();
        assertThat(studyGroupIterator.hasNext()).isFalse();
    }

    @Test
    public void testingMethodNextFromStudyGroup() {
        assertThat(studyGroupIterator.next()).isEqualTo(studyGroupTest.getStudent(0));
        assertThat(studyGroupIterator.next()).isEqualTo(studyGroupTest.getStudent(1));
        assertThat(studyGroupIterator.next()).isEqualTo(studyGroupTest.getStudent(2));
        assertThat(studyGroupIterator.next()).isEqualTo(studyGroupTest.getStudent(3));
        assertThat(studyGroupIterator.next()).isEqualTo(studyGroupTest.getStudent(4));
        assertThrows(NoSuchElementException.class, () -> {
            studyGroupIterator.next();
        });
    }

    @Test
    public void testingMethodRemoveFromStudyGroup() {
        Student studentTest = new Student();
        studentTest = studyGroupTest.getStudent(1);
        studyGroupIterator.next();
        studyGroupIterator.remove();
        assertThat(studyGroupTest.size()).isEqualTo(4);
        assertThat(studyGroupIterator.next()).isEqualTo(studentTest);
    }

    @Test
    public void testRemoveThrowsExceptionIfNextNotCalled() {
        assertThrows(IllegalStateException.class, () -> studyGroupIterator.remove());
    }

    @Test
    public void testRemoveThrowsExceptionIfRemoveCalledTwice() {
        studyGroupIterator.next();
        studyGroupIterator.remove();
        assertThrows(IllegalStateException.class, () -> studyGroupIterator.remove());
    }
}
