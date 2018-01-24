package com.netcracker.Entities;

import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users")
@EnableTransactionManagement
public class User implements Serializable{
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "password")
    private String password;

    @Column(name = "isadmin")
    private Boolean isAdmin;

    @Column(name = "login")
    private String login;

    public User() {
    }

    public User(String password, Boolean isAdmin, String login) {
        this.password = password;
        this.isAdmin = isAdmin;
        this.login = login;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer userId) {
        this.id = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + id +
                ", password='" + password + '\'' +
                ", isAdmin=" + isAdmin +
                ", login='" + login + '\'' +
                '}';
    }
}
