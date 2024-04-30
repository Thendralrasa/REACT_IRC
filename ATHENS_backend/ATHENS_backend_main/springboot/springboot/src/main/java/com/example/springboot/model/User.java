package com.example.springboot.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    private int id;
    private String athleticApparel;
    private String sportsEquipment;
    private String email;
    private String userName;
    private String password;
    public int getid() {
        return id;
    }
    public void setid(int id) {
        this.id = id;
    }
    public String getAthleticApparel() {
        return athleticApparel;
    }
    public void setAthleticApparel(String athleticApparel) {
        this.athleticApparel = athleticApparel;
    }
    public String getSportsEquipment() {
        return sportsEquipment;
    }
    public void setSportsEquipment(String sportsEquipment) {
        this.sportsEquipment = sportsEquipment;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public User() {
    }
    public User(int id, String athleticApparel, String sportsEquipment, String email, String userName,
            String password) {
        this.id = id;
        this.athleticApparel = athleticApparel;
        this.sportsEquipment = sportsEquipment;
        this.email = email;
        this.userName = userName;
        this.password = password;
    }
    
}