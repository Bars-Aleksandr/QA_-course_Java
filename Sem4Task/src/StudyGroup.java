
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
//import java.util.NoSuchElementException;

public class StudyGroup implements Iterable<Student> {
    private List<Student> students;

    public StudyGroup() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public Student getStudent(int index) {
        return students.get(index);
    }

    public void printStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public List<Student> getStudentsList() {
        return this.students;
    }

    public int size() {
        return students.size();
    }

    @Override
    public Iterator<Student> iterator() {

        return new StudyGroupIterator(this);
    }

    public void remove(int i) {
        students.remove(i);
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

}
