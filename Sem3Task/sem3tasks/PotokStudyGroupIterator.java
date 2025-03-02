package sem3tasks;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class PotokStudyGroupIterator implements Iterator<StudyGroup> {
    private int index = 0;

    private PotokStudyGroup potokStudyGroup = new PotokStudyGroup();

    public PotokStudyGroupIterator(PotokStudyGroup potokStudyGroup) {
        this.potokStudyGroup = potokStudyGroup;
    }

    @Override
    public boolean hasNext() {
        return index < potokStudyGroup.size();
    }

    @Override
    public StudyGroup next() {
        if (!hasNext()) {

            throw new NoSuchElementException("No more elements");
        }

        return potokStudyGroup.getStudyGroup(index++);
    }

}
