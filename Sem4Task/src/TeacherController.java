import java.util.List;

public class TeacherController implements UserController<Teacher> {
    private TeacherService service = new TeacherService();
    private TeacherView teacherView = new TeacherView();

    @Override
    public void create(String firstName, String lastName, String middleName, String birthday) {
        Teacher teacher = new Teacher(firstName, lastName, middleName, birthday);
        service.addTeacherList(teacher);
        ;
    }

    public List<Teacher> getTeacherList() {
        return service.getTeacherList();
    }

    public void sendOnConsoleTeacherList() {
        teacherView.sendOnConsole(getTeacherList());
    }

    public void sortTeachersByFIO() {
        service.sortTeachetByFIO();
    }

}
