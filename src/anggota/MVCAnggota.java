/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anggota;

/**
 *
 * @author Satya
 */
public class MVCAnggota {

    public MVCAnggota() {
        ViewAnggota viewnya = new ViewAnggota();
        ModelAnggota modelnya = new ModelAnggota();
        ControllerAnggota controllernya = new ControllerAnggota(modelnya, viewnya);
    }
    
}
