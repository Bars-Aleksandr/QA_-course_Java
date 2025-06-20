package Core.MVC.view.itemsMenu;

import Core.MVC.models.Student;

public class ItemsStudentsMenu implements IItemsMenuUsers<Student>{

    private String[] itemsMenu = {
            "1. Показать всех студентов",
            "2. Добавить студента",
            "3. Отсортировать список студентов по id",
            "4. Отсортировать список студентов по ФИО",
            "5. Перемешать список студентов",
            "6. Удалить студента по ФИО",
            "0. Назад"
    };

    public String[] getItemsMenu(){
        return itemsMenu;
    }
}
