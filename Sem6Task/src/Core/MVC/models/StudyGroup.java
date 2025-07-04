//SRP: класс отвечает за управление группой студентов: добавляет, удаляет, возвращает, выводит.
//OCP: класс можно расширять, не меняя его текущую реализацию.
//DIP: класс зависит от абстракций (Iterable, Iterator).
package Core.MVC.models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Core.Infrastructure.StudyGroupIterator;

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
