//аналогично StudentsMenu
package UI.commands.BaseMenu;

public class TeachersMenu implements IMenu {

    private String[] itemsMenu;

    public TeachersMenu(String[] itemsMenu) {
        this.itemsMenu = itemsMenu;
    }

    @Override
    public void show() {
        System.out.println("\n--- Работа с учителями ---");
        for (String itemMenu : itemsMenu) {
            System.out.println(itemMenu);
        }
        System.out.print("Выберите пункт: ");
    }

}
