package sem3tasks;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StudyGroupIterator implements Iterator<Student> {
    private int index = 0;
    private boolean lastItemReturned = false;
    private StudyGroup studyGroup = new StudyGroup();

    public StudyGroupIterator(StudyGroup studyGroup) {
        this.studyGroup = studyGroup;
    }

    @Override
    public boolean hasNext() {
        return index < studyGroup.size();
    }

    @Override
    public Student next() {
        if (!hasNext()) {
            lastItemReturned = false;
            throw new NoSuchElementException("No more elements");
        }
        lastItemReturned = true;
        return studyGroup.getStudent(index++);
    }

    @Override
    public void remove() {
        if (!lastItemReturned) {
            throw new IllegalStateException("next() не был вызван, или последний элемент уже удалён");
        }
        studyGroup.remove(--index);
        lastItemReturned = false;
    }
}
