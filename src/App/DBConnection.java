/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Ahmad Dimyati
 */
public class DBConnection {
    public Connection conn;
    
    /**
     * fungsu untuk mengoneksikan DB
     */
    public Connection openConnection() throws ClassNotFoundException {
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            String connURL = "jdbc:mysql://localhost:3306/kuliah_pbo_uas?autoReconnect=true&useSSL=false"
                    + "&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            String user = "root";
            String password = "";
            
            conn = DriverManager.getConnection(connURL, user, password);
            
            return conn;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Koneksi ke database gagal, cek kembali konfigurasinya.");
            return null;
        }
    }
    
    /**
     * fungsi untuk menutup / menonaktifkan koneksi
     */
    public void closeConnection() throws SQLException {
        try {
            
            if(conn != null){
                System.out.print("Tutup Koneksi\n");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Koneksi ke database gagal ditutup");
        }
    }
}
