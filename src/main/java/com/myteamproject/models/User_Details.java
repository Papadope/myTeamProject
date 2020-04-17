package com.myteamproject.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="user_details")
public class User_Details {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="userDetailsId")
    private int userDetailsId;
    
    @OneToOne(mappedBy="user_details", 
        cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})    
    private User user;
    
    @Column(name="userFName")
    private String userFName;
    
    @Column(name="userLName")
    private String userLName;      
    
    @Column(name="email")
    private String email;
    
    @Column(name="shipAddress")
    private String shipAddress;
    
    @Column(name="phoneNumber")
    private String phoneNumber;
    
    public User_Details(){}
    
    public User_Details(String userFName, String userLName, String email, String shipAddress, String phoneNumber) {
        this.userFName = userFName;
        this.userLName = userLName;
        this.email = email;
        this.shipAddress = shipAddress;
        this.phoneNumber = phoneNumber;
    }     

    public int getUserDetailsId() {
        return userDetailsId;
    }

    public void setUserDetailsId(int userDetailsId) {
        this.userDetailsId = userDetailsId;
    }

    public String getUserFName() {
        return userFName;
    }

    public void setUserFName(String userFName) {
        this.userFName = userFName;
    }

    public String getUserLName() {
        return userLName;
    }

    public void setUserLName(String userLName) {
        this.userLName = userLName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }    

    @Override
    public String toString() {
        return "UserDetailsId=" + userDetailsId + ", UserFName=" + userFName + ", UserLName=" + userLName + ", Email=" + 
                 email + ", ShipAddress=" + shipAddress + ", PhoneNumber=" + phoneNumber + ", UserId="+user.getUserId();
    }   
}
