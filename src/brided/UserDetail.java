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
public class UserDetail {
    private final StringProperty nama;
    private final StringProperty ttl;
    private final StringProperty noTelepon;
    private final StringProperty alamat;
    private final StringProperty username;
    private final StringProperty password;
    
    public UserDetail(String nama, String ttl, String noTelepon, String alamat, String username, String password){
        this.nama = new SimpleStringProperty(nama);
        this.ttl = new SimpleStringProperty(ttl);
        this.noTelepon = new SimpleStringProperty(noTelepon);
        this.alamat = new SimpleStringProperty(alamat);
        this.username = new SimpleStringProperty(username);
        this.password = new SimpleStringProperty(password); 
    }
    
    public String getNama(){
        return nama.get();
    }
    
    public String getTtl(){
        return ttl.get();
    }
    
    public String getNoTelepon(){
        return noTelepon.get();
    }
    
    public String getAlamat(){
        return alamat.get();
    }
    
    public String getUsername(){
        return username.get();
    }
    
    public String getPassword(){
        return password.get();
    }
    
    
    public void setNama(String value){
        nama.set(value);
    }
    
    public void setTtl(String value){
        ttl.set(value);
    }
    
    public void setNoTelepon(String value){
        noTelepon.set(value);
    }
    
    public void setAlamat(String value){
        alamat.set(value);
    }
    
    public void setUsername(String value){
        username.set(value);
    }
    
    public void setPassword(String value){
        password.set(value);
    }
    
    
    public StringProperty namaProperty(){
        return nama;
    }
    
    public StringProperty ttlProperty(){
        return ttl;
    }
    
    public StringProperty noTeleponProperty(){
        return noTelepon;
    }
    
    public StringProperty alamatProperty(){
        return alamat;
    }
    
    public StringProperty usernameProperty(){
        return username;
    }
    
    public StringProperty passwordProperty(){
        return password;
    }
}
