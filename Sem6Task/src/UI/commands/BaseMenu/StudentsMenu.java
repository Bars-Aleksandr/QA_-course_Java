/**
 * 1. Single Responsibility Principle (SRP)

    ItemsStudentsMenu — отвечает только за хранение и предоставление пунктов меню.
    StudentsMenu — отвечает только за отображение меню.
    Общий подход — разделение ответственности выполнено правильно.

2. Open/Closed Principle (OCP)

    Можно добавлять новые пункты меню, создавая новые классы, реализующие IItemsMenuUsers<Student>.
    StudentsMenu не нужно менять при добавлении новых пунктов — он универсален.

Вывод:
Открыт для расширения, закрыт для модификации — соответствует OCP.
3. Liskov Substitution Principle (LSP)

    ItemsStudentsMenu реализует интерфейс IItemsMenuUsers<Student>.
    Можно подставлять любые реализации этого интерфейса без нарушения работы StudentsMenu.

4. Interface Segregation Principle (ISP)

    Интерфейс IItemsMenuUsers<Student> предполагает метод getItemsMenu().
    Это минимальный интерфейс, соответствующий принципу сегрегации.

5. Dependency Inversion Principle (DIP)

    В вашем коде StudentsMenu зависит от абстракции (String[] itemsMenu) и интерфейса (IItemsMenuUsers<Student>).
    Вызов через интерфейс делает систему более гибкой и легко расширяемой.

 */
package UI.commands.BaseMenu;

public class StudentsMenu implements IMenu {
    private final String[] itemsMenu;

    public StudentsMenu(String[] itemsMenu) {
        this.itemsMenu = itemsMenu;
    }

    @Override
    public void show() {

        System.out.println("\n--- Работа со студентами ---");
        for (String itemMenu : itemsMenu) {
            System.out.println(itemMenu);
        }
        System.out.print("Выберите пункт: ");

    }

}
