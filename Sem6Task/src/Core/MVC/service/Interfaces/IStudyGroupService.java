package Core.MVC.service.Interfaces;

import Core.MVC.models.StudyGroup;

public interface IStudyGroupService {
    public void removeStudentByFio(String firstName, String lastName, String middleName,
            StudyGroup studyGroup);

    public void sortStudentsById(StudyGroup studyGroup);

    public void shuffleStudyGroup(StudyGroup studyGroup);
}
