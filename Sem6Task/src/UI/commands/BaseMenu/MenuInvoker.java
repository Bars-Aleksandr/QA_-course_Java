package UI.commands.BaseMenu;

import Core.MVC.controllers.StudyGroupController;
import Core.MVC.controllers.TeacherController;
import Core.MVC.models.User;
import Core.MVC.view.IUserView;
import UI.commands.CommandService;

import UI.commands.InputModel;
import UI.commands.UserInputHandler;

public class MenuInvoker {

    private final AppMenu appMenu;
    private final UserInputHandler handler;
    private final CommandService commandService;
    private final StudentsMenu studentsMenu;
    private final StudyGroupController studyGroupController;
    private final TeacherController teacherController;

    public MenuInvoker(UserInputHandler handler, CommandService commandService, StudentsMenu studentsMenu, StudyGroupController studyGroupController, TeacherController teacherController) {
        this.appMenu = new AppMenu();
        this.handler = handler;
        this.commandService = commandService;
        this.studentsMenu = studentsMenu;
        this.studyGroupController = studyGroupController;
        this.teacherController = teacherController;
    }

    public void start() {
        boolean exit = false;
        InputModel choice;
        appMenu.show();
        choice = handler.readChoice(studyGroupController.getStudentView());
        while (!exit) {
            
            switch (choice.userChoice) {
                case 1:
                    studentsMenu.show();
                    choice = handler.readChoice(studyGroupController.getStudentView());
                    if (choice.userChoice > 0) {
                        commandService.executeCommand(choice.userChoice, choice.userInputObject);
                    }
                    break;
                case 2:
                    // teachersMenu.show();
                    if (choice.userChoice > 0) {
                        commandService.executeCommand(choice.userChoice, choice.userInputObject);
                    }
                    break;
                case 0:
                    appMenu.show();
                    choice = handler.readChoice(studyGroupController.getStudentView());
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
