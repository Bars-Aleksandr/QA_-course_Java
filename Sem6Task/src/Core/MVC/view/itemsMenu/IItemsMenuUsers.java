package Core.MVC.view.itemsMenu;

import Core.MVC.models.User;

public interface IItemsMenuUsers<T extends User> {
    public String[] getItemsMenu();
}
