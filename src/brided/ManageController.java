/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brided;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.mysql.jdbc.Statement;
import java.awt.HeadlessException;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javax.swing.JOptionPane;


/**
 * FXML Controller class
 *
 * @author Meytha Bethany
 */
public class ManageController implements Initializable {

    @FXML
    private TableView<UserDetail> tabelUser;
    @FXML
    private TableColumn<UserDetail, String> ttlID;
    @FXML
    private TableColumn<UserDetail, String> noID;
    @FXML
    private TableColumn<UserDetail, String> alamatID;
    @FXML
    private TableColumn<UserDetail, String> usernameID;
    @FXML
    private TableColumn<UserDetail, String> passwordID;
    @FXML
    private Button btnload;
    
    
    
    @FXML
    private TableColumn<UserDetail, String> namaID;
    @FXML
    private JFXTextField nama;
    @FXML
    private JFXTextField no;
    @FXML
    private JFXDatePicker tanggal;
    @FXML
    private JFXTextField alamat;
    @FXML
    private JFXTextField username;
    @FXML
    private JFXTextField password;
    @FXML
    private TableColumn<BarangDetail, String> barangID;
    @FXML
    private TableColumn<BarangDetail, String> StokID;
    @FXML
    private JFXTextField namabarang;
    @FXML
    private JFXTextField stok;
    
    
    private ObservableList<UserDetail>data;
   private ObservableList<BarangDetail>data2;
    private DBKonek dc;
    @FXML
    private TableView<BarangDetail> tabelbarang;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        dc = new DBKonek();
    }    

    @FXML
    private void delete(ActionEvent event) {
        
        try
         {
             UserDetail val = tabelUser.getSelectionModel().getSelectedItem();
             String sql="DELETE * FROM `user` WHERE Nama ='"+val.getNama() +"' ";
             System.out.println(sql);
            java.sql.Connection conn=(Connection)config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Delete Data Sukses");
         }
        catch (SQLException | HeadlessException e)
        {
            JOptionPane.showMessageDialog(null, "Delete Data Gagal");
        }
       

    }

    @FXML
    private void add(ActionEvent event) throws SQLException {
        String sql = "INSERT INTO user VALUES('"+nama.getText()+"', '"+tanggal.getValue()+"',  '"+no.getText()+"',"
                    + " '"+alamat.getText()+"', '"+username.getText()+"', '"+password.getText()+"')";
            java.sql.Connection conn=(Connection)config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Penyimpanan Data Berhasil");
    }

    @FXML
    private void load(ActionEvent event) {
        Connection con;
        Statement stat;

        DBKonek DB = new DBKonek();
        DB.connectdb();
        con = DB.conn;
        stat = (Statement) DB.pst;
        try{
            data = FXCollections.observableArrayList();
            
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM user");
            while (rs.next()){
                data.add(new UserDetail(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)));
            }
        }catch(SQLException ex){
            System.err.println("Error"+ex);
        }
        
        namaID.setCellValueFactory(new PropertyValueFactory<>("nama"));
        ttlID.setCellValueFactory(new PropertyValueFactory<>("ttl"));
        noID.setCellValueFactory(new PropertyValueFactory<>("noTelepon"));
        alamatID.setCellValueFactory(new PropertyValueFactory<>("alamat"));
        usernameID.setCellValueFactory(new PropertyValueFactory<>("username"));
        passwordID.setCellValueFactory(new PropertyValueFactory<>("password"));
        
        tabelUser.setItems(null);
        tabelUser.setItems(data);
    }

    @FXML
    private void Logout(ActionEvent event) throws IOException {
        ((Node)(event.getSource())).getScene().getWindow().hide();
                    // Load the new fxml
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("LoginAdmin.fxml"));
                    Scene scene = new Scene(fxmlLoader.load(), 635, 390);

                    // Create new stage (window), then set the new Scene
                    Stage stage = new Stage();
                    stage.setResizable(false);
                    stage.setScene(scene);
                    stage.setTitle("Brided");
                    stage.show();
    }

    @FXML
    private void back(ActionEvent event) throws IOException {
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

    @FXML
    private void addBarang(ActionEvent event) throws SQLException{
        String sql = "INSERT INTO barang VALUES('"+namabarang.getText()+"','"+stok.getText()+"')";
            java.sql.Connection conn=(Connection)config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Penyimpanan Data Berhasil");
    }

    @FXML
    private void LoadBarang(ActionEvent event) {
        Connection con;
        Statement stat;

        DBKonek DB = new DBKonek();
        DB.connectdb();
        con = DB.conn;
        stat = (Statement) DB.pst;
        try{
            data2 = FXCollections.observableArrayList();
            
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM barang");
            while (rs.next()){
                data2.add(new BarangDetail(rs.getString(1),rs.getString(2)));
            }
        }catch(SQLException ex){
            System.err.println("Error"+ex);
        }
        
        barangID.setCellValueFactory(new PropertyValueFactory<>("namaBarang"));
        StokID.setCellValueFactory(new PropertyValueFactory<>("stock"));

        tabelbarang.setItems(data2);
    }

    @FXML
    private void report(ActionEvent event) {
        Button report = new Button("Report");
        report.setFont(Font.font("SanSerif", 15));
        report.setOnAction(e ->{
            PrintReport viewReport = new PrintReport();
            viewReport.showReport();           
        });
        
        HBox hbox = new HBox(5);
        hbox.getChildren().addAll(report);
    }

 
    
}
