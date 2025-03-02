package sem3tasks;

import java.util.Comparator;

public class StreamComparator implements Comparator<StudyGroup> {

    @Override
    public int compare(StudyGroup o1, StudyGroup o2) {
        return Integer.valueOf(o1.size()).compareTo(Integer.valueOf(o2.size()));
    }

}
