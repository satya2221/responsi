/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buku;

import java.awt.*;
import javax.swing.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Satya
 */
public class ViewBuku {
    Font fontt = new Font("SanSerif", Font.BOLD, 20);
    Font font_isi = new Font("SanSerif", Font.BOLD, 14);
    
    JTable tabel;
    Container c;
    Object[] kolom = {"ID","Judul","Penulis","penerbit","stok"};
    DefaultTableModel model;
    JScrollPane pane;
    
    JButton b_tambah = new JButton("Tambah");
    JButton b_delete = new JButton ("Hapus");
    JButton b_edit = new JButton("Edit");
    JButton b_reset = new JButton("Reset");
    
    JTextField tf_judul = new JTextField();
    JTextField tf_penulis = new JTextField();
    JTextField tf_penerbit = new JTextField();
    JTextField tf_stok = new JTextField();
    
    JFrame frame = new JFrame("Buku");
    JLabel ljudul,l_perpus,l_help,l_no_hp,pic,l_opsi,l_judul,l_penulis,l_penerbit,l_stok;
    JButton b_buku = new JButton("Menu");
    JButton b_anggota = new JButton("anggota");
    JButton b_peminjaman = new JButton("Peminjaman");
    JButton b_about = new JButton("About Us");
    
    JLabel background = new JLabel();

    public ViewBuku() {
        l_opsi = new JLabel("Opsi");
        l_judul = new JLabel("Judul :");
        l_penulis = new JLabel("Penulis :");
        l_penerbit = new JLabel("Penerbit :");
        l_stok = new JLabel("Stok :");
        
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
        
        frame.add(l_judul);
        l_judul.setFont(font_isi);
        l_judul.setBounds(590, 60, 50, 25);
        frame.add(tf_judul);
        tf_judul.setBounds(670, 60, 150, 25);
        
        frame.add(l_penulis);
        l_penulis.setFont(font_isi);
        l_penulis.setBounds(590, 90, 60, 25);
        frame.add(tf_penulis);
        tf_penulis.setBounds(670, 90, 150, 25);
        
        frame.add(l_penerbit);
        l_penerbit.setFont(font_isi);
        l_penerbit.setBounds(590, 120, 80, 25);
        frame.add(tf_penerbit);
        tf_penerbit.setBounds(670, 120, 150, 25);
        
        frame.add(l_stok);
        l_stok.setFont(font_isi);
        l_stok.setBounds(590, 150, 80, 25);
        frame.add(tf_stok);
        tf_stok.setBounds(670, 150, 60, 25);
        
        frame.add(b_tambah);
        b_tambah.setBounds(575, 210, 80, 25);
        
        frame.add(b_edit);
        b_edit.setBounds(665, 210, 80, 25);
        
        frame.add(b_delete);
        b_delete.setBounds(755, 210, 80, 25);
        
        frame.add(b_reset);
        b_reset.setBounds(665, 250, 80, 25);
        
        frame.add(background);
        background.setIcon(new ImageIcon("D:\\java\\responsi_pbo\\bg.jpg"));
        background.setBounds(0,0,900,400);
    }
    
    public static void main(String[] args) {
        new ViewBuku();
    }
    
    public String getTfjudul() {
        return tf_judul.getText();
    }

    public String getTfpenulis() {
        return tf_penulis.getText();
    }

    public String getTfpenerbit() {
        return tf_penerbit.getText();
    }

    public String getTfstok() {
        return tf_stok.getText();
    }
}
