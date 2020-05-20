/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buku;

import InterfaceNya.tampilkanData;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Satya
 */
public class ModelBuku implements tampilkanData {
    static final String drivernya = "com.mysql.jdbc.Driver";
    static final String DBurl = "jdbc:mysql://localhost/resp_pbo";
    static final String DBusername = "root";
    static final String DBpassword = "";
    Connection koneksi;
    Statement statement;

    public ModelBuku() {
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
            String query = "SELECT * FROM `buku`";
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
    
    public void masukkanData(String judul, String penulis, String penerbit, int stok){
        try {
            String querynya = "INSERT INTO `buku`( `judul`, `author`,`penerbit`,`stok`)"
                    + " VALUES ('"+judul+"','"+penulis+"','"+penerbit+"','"+stok+"')";
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
            String data[][] = new String[banyaknyaData()][5];
            String query = "Select * from `buku`";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data[jmlData][0] = resultSet.getString("id_buku");
                data[jmlData][1] = resultSet.getString("judul");
                data[jmlData][2] = resultSet.getString("author");
                data[jmlData][3] = resultSet.getString("penerbit"); 
                data[jmlData][4] = resultSet.getString("stok"); 
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
            
            String query = "DELETE FROM `buku` WHERE `id_buku` = '"+id+"'";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Dihapus","Hasil",JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException sql){
            JOptionPane.showMessageDialog(null, sql.getMessage(),"Hasil",JOptionPane.ERROR_MESSAGE);
        } 
    }
    
    public void updateData(String id,String judul, String penulis, String penerbit, int stok){
        try{
            
            statement = koneksi.createStatement();
            
            String querynya = "UPDATE `buku` SET `judul`='"+judul+"',`author`='"+penulis+"',`penerbit`='"+penerbit+"',"
                    + "`stok` = '"+stok+"' WHERE `id_buku` = '"+id+"'";
            statement.executeUpdate(querynya);
            
//            JOptionPane.showMessageDialog(null, "Edit Data Sukses!");
            
        }catch(Exception errorUpdate){
            JOptionPane.showMessageDialog(null, errorUpdate.getMessage(),"Hasil",JOptionPane.ERROR_MESSAGE);
        }
    }
}
