package service;


import java.util.List;

import model.Student;
import model.StudyGroup;
import model.Teacher;

public class StudyGroupService {
    
    

    public StudyGroup createStudyGroupService(Teacher teacher, List<Student> students) {
        return new StudyGroup(teacher, students);
    }

    public void printStudyGroupOnConsole(StudyGroup studyGroup) {
        System.out.println("Преподователь учебной группы:");
        System.out.println(studyGroup.getTeacher());
        System.out.println("Список студентов учебной группы");
        for (Student student : studyGroup.getStudents()) {
            System.out.println(student);
        }
        
    }
}
