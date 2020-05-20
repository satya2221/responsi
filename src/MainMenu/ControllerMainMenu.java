/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainMenu;

import about.VCAbout;
import anggota.MVCAnggota;
import buku.MVCBuku;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Satya
 */
public class ControllerMainMenu {
    ViewMainMenu viewnya;

    public ControllerMainMenu(ViewMainMenu viewnya) {
        this.viewnya = viewnya;
        this.viewnya.b_buku.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.out.println("halaman buku");
                MVCBuku buku =new MVCBuku();
            }
        });
//        
//        
        this.viewnya.b_anggota.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.out.println("halaman anggota");
                MVCAnggota anggota = new MVCAnggota();
            }
        });
//        
//        
//        this.viewnya.b_peminjaman.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent ae) {
//                // pindah ke data review user
////                MVCProfile profile = new MVCProfile(mainMenuView.getUsername());
//            }
//        });
        
        
        this.viewnya.b_about.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.out.println("halaman about us");
                // pindah ke data review semua user
                VCAbout about = new VCAbout();
            }
        });
    }
    
}
