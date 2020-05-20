/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Satya
 */
public class ModelLogin {
    static final String drivernya = "com.mysql.jdbc.Driver";
    static final String DBurl = "jdbc:mysql://localhost/resp_pbo";
    static final String DBusername = "root";
    static final String DBpassword = "";
    Connection koneksi;
    Statement statement;
    
    public ModelLogin(){
        try {
            Class.forName(drivernya);
            koneksi = DriverManager.getConnection(DBurl,DBusername, DBpassword);
            System.out.println("Koneksi berhasil");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.println("Koneksi gagal!");
        }
    }
    public boolean cekLogin(String username,String pass){
        int cek = 0;
        try {
            statement = (Statement)koneksi.createStatement();
            String querynya = "SELECT * FROM `user` WHERE `nama`='"+username+"' AND `pass`='"+pass+"'";
            ResultSet hasilnya = statement.executeQuery(querynya);
            while (hasilnya.next()){
                    cek++;
            }
            if(cek>0){
                JOptionPane.showMessageDialog(null,"Login Success");
                //mengembalikan nilai true biar di cek di controller nantinya
                return true;
            }
            else{
                JOptionPane.showMessageDialog(null,"Login Failed");
            }
//            statement.executeUpdate(querynya);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),"Hasil",JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
}
