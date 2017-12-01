/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brided;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.mysql.jdbc.Statement;
import java.awt.HeadlessException;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Meytha Bethany
 */
public class LoginAdminController implements Initializable {

    @FXML
    private JFXTextField usernameID;
    @FXML
    private JFXPasswordField passwordID;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Login(ActionEvent event) throws IOException {
        Connection con;
        Statement stat;
        ResultSet rs;
        String sql;

        DBKonek DB = new DBKonek();
        DB.connectdb();
        con = DB.conn;
        stat = (Statement) DB.pst;
        
        if(usernameID.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Tulisan Username Anda");
        }
        else if(passwordID.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Tulisan Password Anda");
        }
        else{
        try {
            sql = "SELECT * FROM admin WHERE Username='"+usernameID.getText()+"'OR Email='"+usernameID.getText()+"' AND password='"+passwordID.getText()+"'";
            rs = stat.executeQuery(sql);
            if(rs.next()){
                if(usernameID.getText().equals(rs.getString("Username")) || usernameID.getText().equals(rs.getString("Email"))  && passwordID.getText().equals(rs.getString("password"))){
                    JOptionPane.showMessageDialog(null, "Berhasil Login");                  
                    ((Node)(event.getSource())).getScene().getWindow().hide();
                    // Load the new fxml
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("AdminHome.fxml"));
                    Scene scene = new Scene(fxmlLoader.load(), 635, 390);

                    // Create new stage (window), then set the new Scene
                    Stage stage = new Stage();
                    stage.setResizable(false);
                    stage.setScene(scene);
                    stage.setTitle("Brided");
                    stage.show();
                }
            }else{
                    JOptionPane.showMessageDialog(null, "Username Atau Password Salah");
                }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    }

    @FXML
    private void SignUp(ActionEvent event) throws IOException {
        ((Node)(event.getSource())).getScene().getWindow().hide();
            
            // Load the new fxml
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("SignUpAdmin.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 635,390);
            
            // Create new stage (window), then set the new Scene
            Stage stage = new Stage();
            stage.setResizable(false);
            stage.setScene(scene);
            stage.setTitle("Registration");
            stage.show();
    }

    @FXML
    private void back(ActionEvent event) throws IOException {
        ((Node)(event.getSource())).getScene().getWindow().hide();
            
            // Load the new fxml
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("Welcome.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 635,390);
            
            // Create new stage (window), then set the new Scene
            Stage stage = new Stage();
            stage.setResizable(false);
            stage.setScene(scene);
            stage.setTitle("Brided");
            stage.show();
    }
    
}
