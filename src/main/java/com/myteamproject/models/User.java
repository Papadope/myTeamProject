package com.myteamproject.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="userId")
    private int userId;
    
    @ManyToOne(cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="roleId")
    private Role role;
    
    @Column(name="nameOfRole")
    private String nameOfRole;
    
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="loginId")
    private Login_Credentials login_credentials;
    
    
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="userDetailsId")
    private User_Details user_details;
    
    @OneToMany(fetch=FetchType.LAZY,
            mappedBy="user",
            cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Order> orders;
    
    public User(){}    
    
    public User(int accessLevel,  String nameOfRole, User_Details user_details) {
        int roleId=role.getRoleId();
        roleId=accessLevel;
        this.nameOfRole = nameOfRole;
        this.user_details = user_details;
    }

    
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getNameOfRole() {
        return nameOfRole;
    }

    public void setNameOfRole(String nameOfRole) {
        this.nameOfRole = nameOfRole;
    }

    public Login_Credentials getLogin_credentials() {
        return login_credentials;
    }

    public void setLogin_credentials(Login_Credentials login_credentials) {
        this.login_credentials = login_credentials;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    

    public User_Details getUser_details() {
        return user_details;
    }

    public void setUser_details(User_Details user_details) {
        this.user_details = user_details;
    }
    
    public void addOrder(Order order){
        if(orders==null){
            orders=new ArrayList<>();
        }
        orders.add(order);
        order.setUser(this);       
    }
    
    @Override
    public String toString() {
        return "UserId=" + userId + ", AccessLevel=" + role.getAccessLevel() + ", NameOfRole=" + nameOfRole+", Name="+user_details.getUserFName()
                +", LastName="+user_details.getUserLName();
    }
    
    
    
}
