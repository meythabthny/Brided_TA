/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brided;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.awt.HeadlessException;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Meytha Bethany
 */
public class SignUpAdminController implements Initializable {

    @FXML
    private JFXTextField nama;
    @FXML
    private JFXTextField notelp;
    @FXML
    private JFXTextField alamat;
    @FXML
    private JFXTextField username;
    @FXML
    private JFXPasswordField password;
    @FXML
    private JFXDatePicker tanggal;
    @FXML
    private JFXTextField email;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Daftar(ActionEvent event) throws IOException {
        if(nama.getText().equals("")||email.getText().equals("")||tanggal.getValue().equals("")||notelp.getText().equals("")||alamat.getText().equals("")||
                username.getText().equals("")||password.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Lengkapi data yang tertera");
        }
        else{
        try {
            String sql = "INSERT INTO admin VALUES('"+nama.getText()+"','"+email.getText()+"', '"+tanggal.getValue()+"',  '"+notelp.getText()+"',"
                    + " '"+alamat.getText()+"', '"+username.getText()+"', '"+password.getText()+"')";
            java.sql.Connection conn=(Connection)config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Penyimpanan Data Berhasil");
            
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
            
           
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    }

    @FXML
    private void handleclose(MouseEvent event) {
    }

    @FXML
    private void back(ActionEvent event) throws IOException {
        ((Node)(event.getSource())).getScene().getWindow().hide();
            
            // Load the new fxml
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("LoginAdmin.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 635, 390);
            
            // Create new stage (window), then set the new Scene
            Stage stage = new Stage();
            stage.setResizable(false);
            stage.setScene(scene);
            stage.setTitle("Registration");
            stage.show();
    }
    
}
