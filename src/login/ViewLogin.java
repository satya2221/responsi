/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.awt.*;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author Satya
 */
public class ViewLogin {
    Font fontt = new Font("SanSerif", Font.PLAIN, 20);
    Font font_isi = new Font("SanSerif", Font.BOLD, 14);
    
    JFrame frame = new JFrame("Login Menu");
    JLabel llogin = new JLabel("L O G I N");
    JLabel l_perpus = new JLabel("Pengelola Perpustakaan");
    JLabel lusername = new JLabel("Username");
    JTextField fusername = new JTextField();
    JLabel lpassword = new JLabel("Password");
    JPasswordField fpassword = new JPasswordField();
    
    JLabel l_help = new JLabel("Hubungi untuk bantuan");
    JLabel l_no_hp = new JLabel("0811-8235-3444 (James)");
    JLabel pic = new JLabel(new ImageIcon("D:\\onedrive\\Pictures\\user.png"));
    
    JButton b_login = new JButton("Login");
    JButton b_reset = new JButton("Reset");
    
    JLabel background = new JLabel();

    public ViewLogin() {
        frame.setLayout(null);
        frame.setSize(450,525);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation (EXIT_ON_CLOSE);
        
        frame.add(llogin);
        llogin.setFont(fontt);
        llogin.setBounds(180, 45, 100, 25); 
        
        frame.add(l_perpus);
        l_perpus.setFont(new Font("SanSerif", Font.BOLD, 16));
        l_perpus.setBounds(130, 70, 188, 25);
        
        frame.add(lusername);
        lusername.setFont(font_isi);
        lusername.setBounds(25, 120, 100, 20);
        
        frame.add(fusername);
        fusername.setBounds(25, 150, 380, 30);
        
        frame.add(lpassword);
        lpassword.setFont(font_isi);
        lpassword.setBounds(25, 195, 110, 20);
        
        frame.add(fpassword);
        fpassword.setBounds(25, 225, 380, 30);
        
        frame.add(b_login);
        b_login.setBounds(245, 270, 70, 20);
        
        frame.add(b_reset);
        b_reset.setBounds(95, 270, 70, 20);
        
        frame.add(l_help);
        l_help.setFont(fontt);
        l_help.setBounds(110, 350, 200, 25); 
        
        frame.add(pic);
        pic.setBounds(80,380,70,70);
        
        frame.add(l_no_hp);
        l_no_hp.setFont(new Font("SanSerif", Font.BOLD, 16));
        l_no_hp.setBounds(160, 400, 200, 25);
        
        frame.add(background);
        background.setIcon(new ImageIcon("D:\\java\\responsi_pbo\\bg.jpg"));
        background.setBounds(0,0,450,525);
    }
    public static void main(String[] args) {
        new ViewLogin();
    }
    public String getFusername() {
        return fusername.getText();
    }

    public String getFpassword() {
        return fpassword.getText();
    }
}
