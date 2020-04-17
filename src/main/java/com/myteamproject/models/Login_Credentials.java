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
@Table(name="login_credentials")
public class Login_Credentials {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="loginId")
    private int loginId;
    
    @Column(name="userName")
    private String userName;
    
    @Column(name="password")
    private String password;
    
    @OneToOne(mappedBy="login_credentials", 
        cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})    
    private User user;   
    
    Login_Credentials(){}

    public Login_Credentials(String userName, String password) {
        this.userName = userName;
        this.password = password;        
    } 

    public int getLoginId() {
        return loginId;
    }

    public void setLoginId(int loginId) {
        this.loginId = loginId;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    
    @Override
    public String toString() {
        return "LoginId=" + loginId + ", UserName=" + userName + ", Password=" + password +", UserID="+user.getUserId();
    }
    
    
    
    
    
}
