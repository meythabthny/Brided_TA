/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brided;

import com.jfoenix.controls.JFXTextField;
import com.mysql.jdbc.Statement;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Meytha Bethany
 */
public class HomeController implements Initializable {
    @FXML
    private Tab Rosa;
    @FXML
    private Tab Leona;
    @FXML
    private Tab Maja;
    @FXML
    private Tab Barcaza;
    @FXML
    private Pane modern;
    @FXML
    private Pane home;
    @FXML
    private Pane tradisional;
    @FXML
    private Pane desain;
    @FXML
    private Pane muslim;
    @FXML
    private JFXTextField StokJaya;
    @FXML
    private JFXTextField jumlahJaya;
    @FXML
    private JFXTextField alamatJaya;
    @FXML
    private JFXTextField StokBali;
    @FXML
    private JFXTextField jumlahBali;
    @FXML
    private JFXTextField alamatBali;
    @FXML
    private JFXTextField StokMinang;
    @FXML
    private JFXTextField jumlahMinang;
    @FXML
    private JFXTextField alamatMinang;
    @FXML
    private JFXTextField StokJogja;
    @FXML
    private JFXTextField jumlahJogja;
    @FXML
    private JFXTextField alamatJogja;
    @FXML
    private JFXTextField StokRosa;
    @FXML
    private JFXTextField jumlahRosa;
    @FXML
    private JFXTextField alamatRosa;
    @FXML
    private JFXTextField StokLeona;
    @FXML
    private JFXTextField jumlahLeona;
    @FXML
    private JFXTextField alamatLeona;
    @FXML
    private JFXTextField StokMaja;
    @FXML
    private JFXTextField jumlahMaja;
    @FXML
    private JFXTextField alamatMaja;
    @FXML
    private JFXTextField StokBarca;
    @FXML
    private JFXTextField jumlahBarca;
    @FXML
    private JFXTextField alamatBarca;
    @FXML
    private JFXTextField StokVestido;
    @FXML
    private JFXTextField jumlahVestido;
    @FXML
    private JFXTextField alamatVestido;
    @FXML
    private JFXTextField StokEvening;
    @FXML
    private JFXTextField jumlahEvening;
    @FXML
    private JFXTextField alamatEvening;
    @FXML
    private Label userID;
    
  
     
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    
    
    @FXML
    private void Modern(ActionEvent event) throws IOException, SQLException {

      modern.setVisible(true);
      home.setVisible(false);
      tradisional.setVisible(false);
      muslim.setVisible(false);
      desain.setVisible(false);
    
    
    }
    
    
    @FXML
    private void Tradisional(ActionEvent event) throws IOException {
              tradisional.setVisible(true);
      modern.setVisible(false);
      home.setVisible(false);
      muslim.setVisible(false);
      desain.setVisible(false);
    }

    @FXML
    private void Muslim(ActionEvent event) throws IOException {
        modern.setVisible(false);
      home.setVisible(false);
      tradisional.setVisible(false);
      muslim.setVisible(true);
      desain.setVisible(false);
    }

    @FXML
    private void Desain(ActionEvent event) throws IOException {
        modern.setVisible(false);
      home.setVisible(false);
      tradisional.setVisible(false);
      muslim.setVisible(false);
      desain.setVisible(true);
    }

    @FXML
    private void Logout(ActionEvent event) throws IOException {
        ((Node)(event.getSource())).getScene().getWindow().hide();
                    // Load the new fxml
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("Login.fxml"));
                    Scene scene = new Scene(fxmlLoader.load(), 635, 390     );

                    // Create new stage (window), then set the new Scene
                    Stage stage = new Stage();
                    stage.setResizable(false);
                    stage.setScene(scene);
                    stage.setTitle("Brided");
                    stage.show();
    }

    @FXML
    private void pesanJaya(ActionEvent event) {
        int jumlah = Integer.parseInt(jumlahJaya.getText());
        String Alamat = alamatJaya.getText();
        int harga=1750000;
        int total=0;
        
        total = jumlah*harga;
        JOptionPane.showMessageDialog(null, "Pemesanan Berhasil Total Pembayaran : "+ total +"Alamat : "+Alamat);
    }

    @FXML
    private void pesanBali(ActionEvent event) {
        int jumlah = Integer.parseInt(jumlahBali.getText());
        String Alamat = alamatBali.getText();
        int harga=18500000;
        int total=0;
        
        total = jumlah*harga;
        JOptionPane.showMessageDialog(null, "Pemesanan Berhasil Total Pembayaran : "+ total +"Alamat : "+Alamat);
    }

    @FXML
    private void pesanMinang(ActionEvent event) {
        int jumlah = Integer.parseInt(jumlahMinang.getText());
        String Alamat = alamatMinang.getText();
        int harga=1850000;
        int total=0;
        
        total = jumlah*harga;
        JOptionPane.showMessageDialog(null, "Pemesanan Berhasil Total Pembayaran : "+ total +"Alamat : "+Alamat);
    }

    @FXML
    private void pesanJogja(ActionEvent event) {
        int jumlah = Integer.parseInt(jumlahJogja.getText());
        String Alamat = alamatJogja.getText();
        int harga=1950000;
        int total=0;
        
        total = jumlah*harga;
        JOptionPane.showMessageDialog(null, "Pemesanan Berhasil Total Pembayaran : "+ total +"Alamat : "+Alamat);
    }

    @FXML
    private void pesanRosa(ActionEvent event) throws IOException {
        int jumlah = Integer.parseInt(jumlahRosa.getText());
        String Alamat = alamatRosa.getText();
        int harga=1750000;
        int total=0;
        
        total = jumlah*harga;
        JOptionPane.showMessageDialog(null, "Pemesanan Berhasil Total Pembayaran : "+ total +"Alamat : "+Alamat);
        
    }

    @FXML
    private void pesanLeona(ActionEvent event) {
        int jumlah = Integer.parseInt(jumlahLeona.getText());
        String Alamat = alamatLeona.getText();
        int harga=1500000;
        int total=0;
        
        total = jumlah*harga;
        JOptionPane.showMessageDialog(null, "Pemesanan Berhasil Total Pembayaran : "+ total +"Alamat : "+Alamat);
    }

    @FXML
    private void pesanMaja(ActionEvent event) {
        int jumlah = Integer.parseInt(jumlahMaja.getText());
        String Alamat = alamatMaja.getText();
        int harga=2500000;
        int total=0;
        
        total = jumlah*harga;
        JOptionPane.showMessageDialog(null, "Pemesanan Berhasil Total Pembayaran : "+ total +"Alamat : "+Alamat);
    }

    @FXML
    private void pesanBarca(ActionEvent event) {
        int jumlah = Integer.parseInt(jumlahBarca.getText());
        String Alamat = alamatBarca.getText();
        int harga=1900000;
        int total=0;
        
        total = jumlah*harga;
        JOptionPane.showMessageDialog(null, "Pemesanan Berhasil Total Pembayaran : "+ total +"Alamat : "+Alamat);
    }

    @FXML
    private void pesanVestido(ActionEvent event) {
        int jumlah = Integer.parseInt(jumlahVestido.getText());
        String Alamat = alamatVestido.getText();
        int harga=3900000;
        int total=0;
        
        total = jumlah*harga;
        JOptionPane.showMessageDialog(null, "Pemesanan Berhasil Total Pembayaran : "+ total +"Alamat : "+Alamat);
    }

    @FXML
    private void pesanEvening(ActionEvent event) {
        int jumlah = Integer.parseInt(jumlahEvening.getText());
        String Alamat = alamatEvening.getText();
        int harga=3000000;
        int total=0;
        
        total = jumlah*harga;
        JOptionPane.showMessageDialog(null, "Pemesanan Berhasil Total Pembayaran : "+ total +"Alamat : "+Alamat);
    }

    @FXML
    private void back(ActionEvent event) {
        modern.setVisible(false);
      home.setVisible(true);
      tradisional.setVisible(false);
      muslim.setVisible(false);
      desain.setVisible(false);
    }
    
}
