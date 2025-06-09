package UI.commands.BaseMenu;

public class TeachersMenu implements IMenu {

    @Override
    public void show() {
        System.out.println("\n--- Работа с учителями ---");
        for (String itemMenu : createItemsMenu()) {
            System.out.println(itemMenu);
        }
        System.out.print("Выберите пункт: ");
    }

    private String[] createItemsMenu() {
        String[] itemsMenu = {
                "1. Показать список учителей",
                "2. Добавить учителя",
                "3. Отсортировать список учителей по ФИО",
                "0. Назад"
        };
        return itemsMenu;
    }

}
