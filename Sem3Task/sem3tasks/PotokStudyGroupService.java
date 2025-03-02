package sem3tasks;

import java.util.Collections;
import java.util.Iterator;

public class PotokStudyGroupService {

    public void sortPotokStudyGroupByQuantity(PotokStudyGroup potokStudyGroup) {
        Collections.sort(potokStudyGroup.getPotokStudyGroupList(), new StreamComparator());
    }

    public void printAllStudyGroups(PotokStudyGroup potokStudyGroup) {
        Iterator<StudyGroup> iterator = potokStudyGroup.iterator();
        while (iterator.hasNext()) {
            StudyGroup studyGroup = iterator.next();
            studyGroup.printStudents();
            System.out.println();
        }
    }
}
