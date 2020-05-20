/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anggota;

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
public class ControllerAnggota {
    ModelAnggota modelnya;
    ViewAnggota viewnya;
    String dataterpilih = null;
    int baris,kolom;

    public ControllerAnggota(ModelAnggota modelnya, ViewAnggota viewnya) {
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
                if (viewnya.getTfid().equals("")
                        || viewnya.getTfnama().equals("")
                        || viewnya.getTfponsel().equals("")
                        || viewnya.getTfalamat().equals("")) {
                    JOptionPane.showMessageDialog(null, "Ada yang kosong");
                } else {
                    try {
                        String id = viewnya.getTfid();
                        String nama = viewnya.getTfnama();
                        String ponsel = viewnya.getTfponsel();
                        String alamat =viewnya.getTfalamat();
                        modelnya.masukkanData(id,nama,ponsel,alamat);
                        viewnya.tf_id.setText("");
                        viewnya.tf_nama.setText("");
                        viewnya.tf_ponsel.setText("");
                        viewnya.ta_alamat.setText("");

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
                viewnya.tf_id.setText(viewnya.tabel.getValueAt(baris, 0).toString());
                viewnya.tf_nama.setText(viewnya.tabel.getValueAt(baris, 1).toString());
                viewnya.tf_ponsel.setText(viewnya.tabel.getValueAt(baris, 2).toString());
                viewnya.ta_alamat.setText(viewnya.tabel.getValueAt(baris, 3).toString());
                dataterpilih = viewnya.tabel.getValueAt(baris, 0).toString();
                System.out.println(dataterpilih);
            }

        });
        
        viewnya.b_edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String id = viewnya.getTfid();
                String nama = viewnya.getTfnama();
                String ponsel = viewnya.getTfponsel();
                String alamat =viewnya.getTfalamat();
                
                modelnya.updateData(dataterpilih,nama, ponsel, alamat);
                viewnya.tf_id.setText("");
                viewnya.tf_nama.setText("");
                viewnya.tf_ponsel.setText("");
                viewnya.ta_alamat.setText("");
                updateTable();
                dataterpilih=null;
            }
        }
        );
        
        viewnya.b_reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                viewnya.tf_id.setText("");
                viewnya.tf_nama.setText("");
                viewnya.tf_ponsel.setText("");
                viewnya.ta_alamat.setText("");
                dataterpilih=null;
            }
        });
        
        viewnya.b_delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                    if (dataterpilih != null) {
                        modelnya.hapusData(dataterpilih);
                        updateTable();
                        viewnya.tf_id.setText("");
                        viewnya.tf_nama.setText("");
                        viewnya.tf_ponsel.setText("");
                        viewnya.ta_alamat.setText("");
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
