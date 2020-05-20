/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import MainMenu.MVCMainMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Satya
 */
public class ControllerLogin {
    ModelLogin modelnya;
    ViewLogin viewnya;

    public ControllerLogin(ModelLogin modelnya, ViewLogin viewnya) {
        this.modelnya = modelnya;
        this.viewnya = viewnya;
        
         viewnya.b_login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               if (viewnya.getFusername().equals("")
                        || viewnya.getFpassword().equals("")) {
                    JOptionPane.showMessageDialog(null, "field kosong");
                } else {
                    String nama = viewnya.getFusername();
                    String pass = viewnya.getFpassword();
                    if (modelnya.cekLogin(nama, pass)) { // kalo nilai true, nanti pindah halaman
                        System.out.println("Pindah ke Main Menu");
                        MVCMainMenu mainMenu = new MVCMainMenu();
                   }
                    viewnya.fusername.setText("");
                    viewnya.fpassword.setText("");          
                }
            }
        });
        
        viewnya.b_reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                viewnya.fusername.setText("");
                viewnya.fpassword.setText("");
            }
        });
    }
}
