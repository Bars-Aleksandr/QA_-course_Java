package UI.commands.BaseMenu;



public class StudentsMenu implements IMenu {
    

    public StudentsMenu() {
        
    }

    @Override
    public void show() {

        System.out.println("\n--- Работа со студентами ---");
        for (String itemMenu : createItemsMenu()) {
            System.out.println(itemMenu);
        }
        System.out.print("Выберите пункт: ");

    }

    

    private String[] createItemsMenu() {
        String[] itemsMenu = {
                "1. Показать всех студентов",
                "2. Добавить студента",
                "3. Отсортировать список студентов по id",
                "4. Отсортировать список студентов по ФИО",
                "5. Перемешать список студентов",
                "6. Удалить студента по ФИО",
                "0. Назад"
        };
        return itemsMenu;
    }

}
