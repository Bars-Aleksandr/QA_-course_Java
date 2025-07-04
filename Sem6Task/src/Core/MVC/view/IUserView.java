package Core.MVC.view;
import java.util.List;

import Core.MVC.models.User;

public interface IUserView<T extends User> {
    public void sendOnConsole(List<T> list);
    public void printFirstnameText();
    public void printLastnameText();
    public void printMiddlenameText();
    public void printBirthdateText();
}
