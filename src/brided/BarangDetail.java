/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brided;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;
/**
 *
 * @author Meytha Bethany
 */
public class BarangDetail {
     private final StringProperty namaBarang;
    private final StringProperty stock;

    
    public BarangDetail(String namaBarang, String stock){
        this.namaBarang = new SimpleStringProperty(namaBarang);
        this.stock = new SimpleStringProperty(stock);

    }
    
    public String getNamaBarang(){
        return namaBarang.get();
    }
    
    public String getStock(){
        return stock.get();
    }
    
    
    public void setNamaBarang(String value){
        namaBarang.set(value);
    }
    
    public void setStock(String value){
        stock.set(value);
    }

    
    public StringProperty namaBarangProperty(){
        return namaBarang;
    }
    
    public StringProperty stockProperty(){
        return stock;
    }
}
