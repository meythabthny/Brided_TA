/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brided;
import java.sql.*;
import javax.swing.*;
/**
 *
 * @author Meytha Bethany
 */
public class DBKonek {
    Connection conn;
    Statement pst;
    
    public void connectdb(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/brideddress","root","");
            pst = conn.createStatement();
        } catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, "koneksi gagal "+e.getMessage());
        }
    }
}
