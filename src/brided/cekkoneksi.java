/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brided;

import java.sql.SQLException;

/**
 *
 * @author Meytha Bethany
 */
public class cekkoneksi {
     public static void main(String [] args) throws SQLException {
    DBKonek connection = new DBKonek();
    connection.connectdb();
    }
}
