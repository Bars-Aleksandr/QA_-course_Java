package UI.commands.MenuStudentsCommands;

import Core.MVC.controllers.StudyGroupController;
import UI.commands.ICommand;

public class ShuffleStudentsCommand implements ICommand{
    StudyGroupController controller;
    public ShuffleStudentsCommand(StudyGroupController controller) {
       this.controller = controller;
    }
    @Override
    public void execute(Object paraObject) {
        controller.shuffleStudyGroup();
        System.out.println("Списое студентов перемешан");   
    }

}
