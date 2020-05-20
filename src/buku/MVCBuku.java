/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buku;

/**
 *
 * @author Satya
 */
public class MVCBuku {

    public MVCBuku() {
        ViewBuku viewnya = new ViewBuku();
        ModelBuku modelnya = new ModelBuku();
        ControllerBuku controllernya = new ControllerBuku(modelnya, viewnya);
    }
    
}
