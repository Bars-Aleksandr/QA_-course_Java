package sem3tasks;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PotokStudyGroup implements Iterable<StudyGroup> {
    private List<StudyGroup> potokStudyGroup;

    public PotokStudyGroup() {
        this.potokStudyGroup = new ArrayList<>();
    }

    public void addPotokStudyGroup(StudyGroup studyGroup) {
        potokStudyGroup.add(studyGroup);
    }

    @Override
    public Iterator<StudyGroup> iterator() {
        return new PotokStudyGroupIterator(this);
    }

    public int size() {
        return potokStudyGroup.size();
    }

    public StudyGroup getStudyGroup(int index) {
        return potokStudyGroup.get(index);
    }

    public List<StudyGroup> getPotokStudyGroupList() {
        return this.potokStudyGroup;
    }

}
