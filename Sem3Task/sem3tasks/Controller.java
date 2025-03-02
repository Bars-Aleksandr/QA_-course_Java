package sem3tasks;

public class Controller {
    private StudyGroup studyGroup = new StudyGroup();
    private StudyGroupService studyGroupService = new StudyGroupService();
    private PotokStudyGroupService potokService = new PotokStudyGroupService();
    // private PotokStudyGroup potokStudyGroup = new PotokStudyGroup();

    public Controller() {

    }

    public Controller(StudyGroup studyGroup) {
        this.studyGroup = studyGroup;
    }

    // public Controller(PotokStudyGroup potokStudyGroup) {
    // this.potokStudyGroup = potokStudyGroup;
    // }

    public void removeStudentByFio(String firstName, String lastName, String middleName) {
        studyGroupService.removeStudentByFio(firstName, lastName, middleName, studyGroup);
    }

    public void sortStudentsById(StudyGroup studyGroup) {
        studyGroupService.sortStudentsById(studyGroup);
    }

    public void shuffleStudyGroup(StudyGroup studyGroup) {
        studyGroupService.shuffleStudyGroup(studyGroup);
    }

    public void sortetStudyGroupByFIO(StudyGroup studyGroup) {
        studyGroupService.sortetStudyGroupByFIO(studyGroup);
    }

    public void sortPotokStudyGroupByQuantity(PotokStudyGroup potokStudyGroup) {
        potokService.sortPotokStudyGroupByQuantity(potokStudyGroup);
    }

    public void printAllStudyGroups(PotokStudyGroup potokStudyGroup) {
        potokService.printAllStudyGroups(potokStudyGroup);
    }
}
