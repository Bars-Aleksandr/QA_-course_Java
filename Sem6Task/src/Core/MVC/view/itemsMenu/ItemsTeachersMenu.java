package Core.MVC.view.itemsMenu;

import Core.MVC.models.Teacher;

public class ItemsTeachersMenu implements IItemsMenuUsers<Teacher>{
    private String[] itemsMenu = {
                "1. Показать список учителей",
                "2. Добавить учителя",
                "3. Отсортировать список учителей по ФИО",
                "0. Назад"
        };
    @Override
    public String[] getItemsMenu() {
        return itemsMenu;
    }

}
