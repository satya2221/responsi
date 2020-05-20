/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anggota;

import InterfaceNya.tampilkanData;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Satya
 */
public class ModelAnggota implements tampilkanData {
    static final String drivernya = "com.mysql.jdbc.Driver";
    static final String DBurl = "jdbc:mysql://localhost/resp_pbo";
    static final String DBusername = "root";
    static final String DBpassword = "";
    Connection koneksi;
    Statement statement;

    public ModelAnggota() {
    try {
            Class.forName(drivernya);
            koneksi = DriverManager.getConnection(DBurl,DBusername, DBpassword);
            System.out.println("Koneksi berhasil");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.println("Koneksi gagal!");
        }
    
    }
    
    public int banyaknyaData(){
        int jmlData=0;
        try {
            statement = (Statement)koneksi.createStatement();
            String query = "SELECT * FROM `anggota`";
            ResultSet hasilnya = statement.executeQuery(query);
                while (hasilnya.next()){
                    jmlData++;
                }
            return jmlData;
        } catch (Exception countData) {
            JOptionPane.showMessageDialog(null, countData.getMessage(),"Hasil",JOptionPane.ERROR_MESSAGE);
            return 0;
        }
    }
    
    public void masukkanData(String id, String nama, String ponsel, String alamat){
        try {
            String querynya = "INSERT INTO `anggota`( `no_id`, `nama`,`phone`,`alamat`)"
                    + " VALUES ('"+id+"','"+nama+"','"+ponsel+"','"+alamat+"')";
            koneksi =  (Connection) DriverManager.getConnection(DBurl,DBusername,DBpassword);
            statement = (Statement)koneksi.createStatement();
            statement.executeUpdate(querynya);
            JOptionPane.showMessageDialog(null,"Data disimpan","Hasil",JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception errorInput) {
            JOptionPane.showMessageDialog(null, errorInput.getMessage(),"Hasil",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public String[][] tampilkanData(){
        try {
            int jmlData=0;
            String data[][] = new String[banyaknyaData()][4];
            String query = "Select * from `anggota`";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data[jmlData][0] = resultSet.getString("no_id");
                data[jmlData][1] = resultSet.getString("nama");
                data[jmlData][2] = resultSet.getString("phone");
                data[jmlData][3] = resultSet.getString("alamat"); 
                jmlData++;
            }
            return data;
        } catch (Exception errorTampil) {
            JOptionPane.showMessageDialog(null, errorTampil.getMessage(),"Hasil",JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    public void hapusData(String id){
        try{
            
            String query = "DELETE FROM `anggota` WHERE `no_id` = '"+id+"'";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Dihapus","Hasil",JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException sql){
            JOptionPane.showMessageDialog(null, sql.getMessage(),"Hasil",JOptionPane.ERROR_MESSAGE);
        } 
    }
    
    public void updateData(String id, String nama, String ponsel, String alamat){
        try{
            
            statement = koneksi.createStatement();
            
            String querynya = "UPDATE `anggota` SET `nama`='"+nama+"',`phone`='"+ponsel+"',`alamat`='"+alamat+"' "
                    + " WHERE `no_id` = '"+id+"'";
            statement.executeUpdate(querynya);
            
//            JOptionPane.showMessageDialog(null, "Edit Data Sukses!");
            
        }catch(Exception errorUpdate){
            JOptionPane.showMessageDialog(null, errorUpdate.getMessage(),"Hasil",JOptionPane.ERROR_MESSAGE);
        }
    }
}
