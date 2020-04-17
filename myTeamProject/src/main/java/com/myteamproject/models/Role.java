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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class Role {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="roleId")
    private int roleId;
    
    @Column(name="accessLevel")
    private int accessLevel;
    
    @OneToMany(fetch=FetchType.LAZY,
            mappedBy="role", 
            cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<User> users;
    
    public Role(){}

    public Role(int accessLevel) {
        this.accessLevel = accessLevel;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(int accessLevel) {
        this.accessLevel = accessLevel;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    
    @Override
    public String toString() {
        return "RoleId=" + roleId + ", AccessLevel=" + accessLevel;
    }
    
    public void add(User tempUser){
        if(users==null){
            users=new ArrayList<>();
        }
        users.add(tempUser);
        tempUser.setRole(this);
    }
}
