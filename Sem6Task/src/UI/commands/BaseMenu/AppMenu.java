//SRP, OCP, ISP
package UI.commands.BaseMenu;

public class AppMenu implements IMenu {
    private String[] menuItems;

    public AppMenu(String[] menuItems) {
        this.menuItems = menuItems;
    }

    @Override
    public void show() {
        System.out.print("\033[H\033[J");
        System.out.println("\n=== Главное меню ===");
        for (String item : menuItems) {
            System.out.println(item);
        }
        System.out.print("Выберите пункт: ");

    }

}
