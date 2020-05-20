/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anggota;

import java.awt.*;
import javax.swing.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Satya
 */
public class ViewAnggota {
    Font fontt = new Font("SanSerif", Font.BOLD, 20);
    Font font_isi = new Font("SanSerif", Font.BOLD, 14);
    
    JTable tabel;
    Container c;
    Object[] kolom = {"ID","Nama","ponsel","alamat"};
    DefaultTableModel model;
    JScrollPane pane;
    
    JButton b_tambah = new JButton("Tambah");
    JButton b_delete = new JButton ("Hapus");
    JButton b_edit = new JButton("Edit");
    JButton b_reset = new JButton("Reset");
    
    JTextField tf_id = new JTextField();
    JTextField tf_nama = new JTextField();
    JTextField tf_ponsel = new JTextField();
    JTextArea ta_alamat = new JTextArea();
    
    JFrame frame = new JFrame("Buku");
    JLabel ljudul,l_perpus,l_help,l_no_hp,pic,l_opsi,l_id,l_nama,l_ponsel,l_alamat;
    JButton b_buku = new JButton("Menu");
    JButton b_anggota = new JButton("anggota");
    JButton b_peminjaman = new JButton("Peminjaman");
    JButton b_about = new JButton("About Us");
    
    JLabel background = new JLabel();

    public ViewAnggota() {
        l_opsi = new JLabel("Opsi");
        l_id = new JLabel("Id :");
        l_nama = new JLabel("Nama :");
        l_ponsel = new JLabel("no ponsel :");
        l_alamat = new JLabel("Alamat :");
        
        model = new DefaultTableModel(kolom,0);
        tabel = new JTable(model);
        pane = new JScrollPane(tabel);
        
        tabel.setModel(model);
        tabel.setBackground(Color.PINK);
        
        frame.setLayout(null);
        frame.setTitle("Buku");
        frame.setSize(900,450);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation (DISPOSE_ON_CLOSE);
        pane.setBounds(0, 0, 500, 300);
        frame.add(pane);
        
        frame.add(b_buku);
        frame.add(b_anggota);
        frame.add(b_peminjaman);
        frame.add(b_about);
        b_buku.setBounds(30,350,110,25);
        b_anggota.setBounds(150,350,110,25);
        b_peminjaman.setBounds(270,350,110,25);
        b_about.setBounds(390,350,110,25);
        
        frame.add(l_opsi);
        l_opsi.setFont(fontt);
        l_opsi.setBounds(680, 15, 50, 25);
        
        frame.add(l_id);
        l_id.setFont(font_isi);
        l_id.setBounds(590, 60, 50, 25);
        frame.add(tf_id);
        tf_id.setBounds(670, 60, 150, 25);
        
        frame.add(l_nama);
        l_nama.setFont(font_isi);
        l_nama.setBounds(590, 90, 60, 25);
        frame.add(tf_nama);
        tf_nama.setBounds(670, 90, 150, 25);
        
        frame.add(l_ponsel);
        l_ponsel.setFont(font_isi);
        l_ponsel.setBounds(590, 120, 80, 25);
        frame.add(tf_ponsel);
        tf_ponsel.setBounds(670, 120, 150, 25);
        
        frame.add(l_alamat);
        l_alamat.setFont(font_isi);
        l_alamat.setBounds(590, 150, 80, 25);
        frame.add(ta_alamat);
        ta_alamat.setBounds(670, 150, 150, 100);
        ta_alamat.setLineWrap(true);
        ta_alamat.setWrapStyleWord(true);
        
        frame.add(b_tambah);
        b_tambah.setBounds(575, 300, 80, 25);
        
        frame.add(b_edit);
        b_edit.setBounds(665, 300, 80, 25);
        
        frame.add(b_delete);
        b_delete.setBounds(755, 300, 80, 25);
        
        frame.add(b_reset);
        b_reset.setBounds(665, 330, 80, 25);
        
        frame.add(background);
        background.setIcon(new ImageIcon("D:\\java\\responsi_pbo\\bg.jpg"));
        background.setBounds(0,0,900,400);
    }
    
    public static void main(String[] args) {
        new ViewAnggota();
    }
    
    public String getTfid() {
        return tf_id.getText();
    }

    public String getTfnama() {
        return tf_nama.getText();
    }

    public String getTfponsel() {
        return tf_ponsel.getText();
    }

    public String getTfalamat() {
        return ta_alamat.getText();
    }
}
