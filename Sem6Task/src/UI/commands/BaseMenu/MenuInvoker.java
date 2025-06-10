package UI.commands.BaseMenu;

import Core.MVC.controllers.StudyGroupController;
import Core.MVC.controllers.TeacherController;
import Core.MVC.view.itemsMenu.ItemsAppMenu;
import UI.commands.CommandsStudyGroupService;
import UI.commands.CommandsTeacherService;
import UI.commands.InputModel;
import UI.commands.UserInputHandler;

public class MenuInvoker {

    private final AppMenu appMenu;
    private final UserInputHandler handler;
    private final CommandsStudyGroupService studyGroupCommandService;
    private final CommandsTeacherService teachersCommandsService;
    private final StudentsMenu studentsMenu;
    private final TeachersMenu teachersMenu;
    private final StudyGroupController studyGroupController;
    private final TeacherController teacherController;
    private final ItemsAppMenu itemsAppMenu = new ItemsAppMenu();

    
    public MenuInvoker(UserInputHandler handler, CommandsStudyGroupService studyGroupCommandService, StudentsMenu studentsMenu,
            StudyGroupController studyGroupController, TeacherController teacherController, TeachersMenu teachersMenu, CommandsTeacherService teachersCommands) {
        this.appMenu = new AppMenu(itemsAppMenu.getItemsMenu());
        this.handler = handler;
        this.studyGroupCommandService = studyGroupCommandService;
        this.teachersCommandsService = teachersCommands;
        this.studentsMenu = studentsMenu;
        this.teachersMenu = teachersMenu;
        this.studyGroupController = studyGroupController;
        this.teacherController = teacherController;
    }

    public void start() {
        boolean exit = false;
        InputModel choice;
        appMenu.show();
        choice = handler.readChoice();
        while (!exit) {

            switch (choice.userChoice) {
                case 1:
                    studentsMenu.show();
                    choice = handler.readChoice(studyGroupController.getStudentView());
                    if (choice.userChoice > 0) {
                        studyGroupCommandService.executeCommand(choice.userChoice, choice.userInputObject);
                        choice.userChoice = 1;
                    }
                    break;
                case 2:
                    teachersMenu.show();
                    choice = handler.readChoice(teacherController.getTeacherView());
                    if (choice.userChoice > 0) {
                        teachersCommandsService.executeCommand(choice.userChoice, choice.userInputObject);
                        choice.userChoice = 2;
                    }
                    break;
                case 0:
                    appMenu.show();
                    choice = handler.readChoice();
                    if (choice.userChoice == 0) {
                        exit = true;
                        System.out.println("Выход из программы. До свидания!");
                        break;
                    }

                default:
                    System.out.println("Некорректный выбор. Попробуйте снова.");
                    break;
            }

        }
    }

}
