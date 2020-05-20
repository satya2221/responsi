/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buku;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Satya
 */
public class ControllerBuku {
    ModelBuku modelnya;
    ViewBuku viewnya;
    String dataterpilih = null;
    int baris,kolom;

    public ControllerBuku(ModelBuku modelnya, ViewBuku viewnya) {
        this.modelnya = modelnya;
        this.viewnya = viewnya;
        
        if (modelnya.banyaknyaData() != 0) {
            String kontaknya[][] = modelnya.tampilkanData();
            viewnya.tabel.setModel(new JTable(kontaknya, viewnya.kolom).getModel());
        } else {
            JOptionPane.showMessageDialog(null, "Data Kosong");
        }
        
        viewnya.b_tambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (viewnya.getTfjudul().equals("")
                        || viewnya.getTfpenulis().equals("")
                        || viewnya.getTfpenerbit().equals("")
                        || viewnya.getTfstok().equals("")) {
                    JOptionPane.showMessageDialog(null, "Ada yang kosong");
                } else {
                    try {
                        String judul = viewnya.getTfjudul();
                        String penulis = viewnya.getTfpenulis();
                        String penerbit = viewnya.getTfpenerbit();
                        int stok =Integer.parseInt(viewnya.getTfstok()) ;
                        modelnya.masukkanData(judul,penulis,penerbit,stok);
                        viewnya.tf_judul.setText("");
                        viewnya.tf_penulis.setText("");
                        viewnya.tf_penerbit.setText("");
                        viewnya.tf_stok.setText("");

                    updateTable();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "stok harus integer");
                    }
                                  
                }
            }
        });
        
        viewnya.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
                baris = viewnya.tabel.getSelectedRow();
                viewnya.tf_judul.setText(viewnya.tabel.getValueAt(baris, 1).toString());
                viewnya.tf_penulis.setText(viewnya.tabel.getValueAt(baris, 2).toString());
                viewnya.tf_penerbit.setText(viewnya.tabel.getValueAt(baris, 3).toString());
                viewnya.tf_stok.setText(viewnya.tabel.getValueAt(baris, 4).toString());
                dataterpilih = viewnya.tabel.getValueAt(baris, 0).toString();
                System.out.println(dataterpilih);
            }

        });
        
        viewnya.b_edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String judul = viewnya.getTfjudul();
                String penulis = viewnya.getTfpenulis();
                String penerbit = viewnya.getTfpenerbit();
                int stok =Integer.parseInt(viewnya.getTfstok()) ;
                
                modelnya.updateData(dataterpilih,judul, penulis, penerbit,stok);
                viewnya.tf_judul.setText("");
                viewnya.tf_penulis.setText("");
                viewnya.tf_penerbit.setText("");
                viewnya.tf_stok.setText("");
                updateTable();
                dataterpilih=null;
            }
        }
        );
        
        viewnya.b_reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                viewnya.tf_judul.setText("");
                viewnya.tf_penulis.setText("");
                viewnya.tf_penerbit.setText("");
                viewnya.tf_stok.setText("");
                dataterpilih=null;
            }
        });
        
        viewnya.b_delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                    if (dataterpilih != null) {
                        modelnya.hapusData(dataterpilih);
                        updateTable();
                        viewnya.tf_judul.setText("");
                        viewnya.tf_penulis.setText("");
                        viewnya.tf_penerbit.setText("");
                        viewnya.tf_stok.setText("");
                        dataterpilih=null;
                }
            }
        });
        
        viewnya.b_buku.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               viewnya.frame.dispose();
            }
        });
    }
     private void updateTable() {
        String kontaknya[][] = modelnya.tampilkanData();
        viewnya.tabel.setModel(new JTable(kontaknya, viewnya.kolom).getModel());
    }
    
}
