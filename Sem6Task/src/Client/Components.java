package Client;

import Core.MVC.controllers.StudyGroupController;
import Core.MVC.controllers.TeacherController;
import UI.commands.BaseMenu.MenuInvoker;
/**
 * Класс-обертка для хранения компонентов приложения.
 */

public class Components {
    public final MenuInvoker menu;
    public final StudyGroupController studyGroupController;
    public final TeacherController teacherController;

    public Components(MenuInvoker menu,
                      StudyGroupController studyGroupController,
                      TeacherController teacherController) {
        this.menu = menu;
        this.studyGroupController = studyGroupController;
        this.teacherController = teacherController;
    }
}
