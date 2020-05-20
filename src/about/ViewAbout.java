/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package about;

import java.awt.Font;
import javax.swing.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author Satya
 */
public class ViewAbout {
    Font font_isi = new Font("SanSerif", Font.BOLD, 16);
    
    JButton b_buku = new JButton("Buku");
    JButton b_anggota = new JButton("anggota");
    JButton b_peminjaman = new JButton("Peminjaman");
    JButton b_about = new JButton("Main menu");
    
    JFrame frame = new JFrame("About us");
    JLabel ljudul,l_perpus,l_keterangan,l_ket;
    JLabel background = new JLabel();
    
    public ViewAbout() {
        ljudul = new JLabel(new ImageIcon("D:\\java\\responsi_pbo\\earth.png"));
        l_perpus = new JLabel("PERPUS MU");
        l_keterangan = new JLabel("Buka sejak taun 2008");
        l_ket = new JLabel("Menyediakan buku-buku terbaik");
        
        frame.setLayout(null);
        frame.setSize(450,525);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation (DISPOSE_ON_CLOSE);
        
        frame.add(ljudul);
        ljudul.setBounds(190, 15, 65, 65); 
        
        frame.add(l_perpus);
        l_perpus.setFont(new Font("SanSerif", Font.BOLD, 18));
        l_perpus.setBounds(170, 100, 120, 25);
        
        frame.add(l_keterangan);
        l_keterangan.setFont(font_isi);
        l_keterangan.setBounds(140, 150, 180, 25);
        
        frame.add(l_ket);
        l_ket.setFont(new Font("SanSerif", Font.ITALIC, 14));
        l_ket.setBounds(115, 180, 220, 25);
        
        frame.add(b_about);
        b_about.setBounds(95, 300, 120, 25);
        
        frame.add(b_buku);
        b_buku.setBounds(245, 300, 80, 25);
        
        frame.add(b_peminjaman);
        b_peminjaman.setBounds(95, 350, 120, 25);
        
        frame.add(b_anggota);
        b_anggota.setBounds(245, 350, 80, 25);
        
        frame.add(background);
        background.setIcon(new ImageIcon("D:\\java\\responsi_pbo\\bg.jpg"));
        background.setBounds(0,0,450,525);
        
    }
    public static void main(String[] args) {
        new ViewAbout();
    }
    
}
