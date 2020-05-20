/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainMenu;

import java.awt.*;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author Satya
 */
public class ViewMainMenu {
//    private String username;
    Font fontt = new Font("SanSerif", Font.PLAIN, 20);
    Font font_isi = new Font("SanSerif", Font.PLAIN, 14);
    
    JFrame frame = new JFrame("Main Menu");
    JLabel ljudul,l_perpus,l_help,l_no_hp,pic;
    JButton b_buku = new JButton("Buku");
    JButton b_anggota = new JButton("anggota");
    JButton b_peminjaman = new JButton("Peminjaman");
    JButton b_about = new JButton("About Us");
    
    JLabel background = new JLabel();

    public ViewMainMenu() {
//        this.username = username;
        ljudul = new JLabel(new ImageIcon("D:\\java\\responsi_pbo\\earth.png"));
        l_perpus = new JLabel("PERPUS MU");
        l_help = new JLabel("Hubungi untuk bantuan");
        l_no_hp = new JLabel("0811-8235-3444 (James)");
        pic = new JLabel(new ImageIcon("D:\\onedrive\\Pictures\\user.png"));
        
        frame.setLayout(null);
        frame.setSize(450,525);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation (EXIT_ON_CLOSE);
        
        frame.add(ljudul);
        ljudul.setFont(fontt);
        ljudul.setBounds(190, 15, 65, 65); 
        
        frame.add(l_perpus);
        l_perpus.setFont(new Font("SanSerif", Font.BOLD, 18));
        l_perpus.setBounds(170, 100, 120, 25);
        
        frame.add(b_buku);
        b_buku.setBounds(130, 150, 180, 40);
        
        frame.add(b_anggota);
        b_anggota.setBounds(130, 200, 180, 40);
        
        frame.add(b_peminjaman);
        b_peminjaman.setBounds(130, 250, 180, 40);
        
        frame.add(b_about);
        b_about.setBounds(130, 300, 180, 40);
        
        frame.add(l_help);
        l_help.setFont(fontt);
        l_help.setBounds(130, 370, 200, 25); 
        
        frame.add(pic);
        pic.setBounds(80,400,65,65);
        
        frame.add(l_no_hp);
        l_no_hp.setFont(new Font("SanSerif", Font.BOLD, 16));
        l_no_hp.setBounds(160, 420, 200, 25);
        
        frame.add(background);
        background.setIcon(new ImageIcon("D:\\java\\responsi_pbo\\bg.jpg"));
        background.setBounds(0,0,450,525);
        
    }

    public static void main(String[] args) {
        new ViewMainMenu();
    }
//    public String getUsername() {
//        return username;
//    } 
}
