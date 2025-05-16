package Core.MVC.view;
import java.util.List;

import Core.MVC.models.User;

public interface UserView<T extends User> {
    public void sendOnConsole(List<T> list);
}
