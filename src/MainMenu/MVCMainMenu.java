/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainMenu;

/**
 *
 * @author Satya
 */
public class MVCMainMenu {

    public MVCMainMenu() {
        ViewMainMenu viewMainMenu = new ViewMainMenu();
        ControllerMainMenu controllerMainMenu = new ControllerMainMenu(viewMainMenu);
    }
    
    
    
}
