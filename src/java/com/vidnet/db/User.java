/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vidnet.db;

import java.sql.Timestamp;

/**
 *
 * @author SC
 */
public class User {
    private int userid;
    private String username;
    private String password;
    private String email;
    private Timestamp joined;
    
    //getter and setter methods
    public int getUserID() {
        return userid;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    
    public String getEmail() {
        return email;
    }
    
    public Timestamp getJoined() {
        return joined;
    }

    public void setUserID(int newUserID) {
        userid = newUserID;
    }

    public void setUsername(String newUsername) {
        username = newUsername;
    }

    public void setPassword(String newPassword) {
        password = newPassword;
    }
    
    public void setEmail(String newEmail) {
        email = newEmail;
    }
    
    public void setJoined(Timestamp newJoined) {
        joined = newJoined;
    }
    
    //constructors
    public User() {
        userid = -1;
        username = "";
        password = "";
        email = "";
    }
    
    public User(int newUserID, String newUsername, String newPassword,
            String newEmail) {
        userid = newUserID;
        username = newUsername;
        password = newPassword;
        email = newEmail;
    }
    
    public User(int newUserID, String newUsername, String newPassword,
            String newEmail, Timestamp newJoined) {
        userid = newUserID;
        username = newUsername;
        password = newPassword;
        email = newEmail;
        joined = newJoined;
    }
    
    public User(int newUserID, String newUsername, String newPassword,
            String newEmail, String newJoined) {
        userid = newUserID;
        username = newUsername;
        password = newPassword;
        email = newEmail;
        joined = Timestamp.valueOf(newJoined);
    }
}
