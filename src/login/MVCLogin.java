/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

/**
 *
 * @author Satya
 */
public class MVCLogin {
    ViewLogin viewLogin = new ViewLogin();
    ModelLogin modelLogin = new ModelLogin();
    ControllerLogin controllerLogin = new ControllerLogin(modelLogin, viewLogin);
}
