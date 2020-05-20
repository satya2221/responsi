/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package about;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Satya
 */
public class ControllerAbout {
    ViewAbout viewnya;

    public ControllerAbout(ViewAbout viewnya) {
        this.viewnya = viewnya;
        
        viewnya.b_about.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               viewnya.frame.dispose();
            }
        });
    }
    
}
