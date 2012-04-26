/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vidnet.db;

import java.sql.*;
import java.util.Date;
import java.util.LinkedList;

/**
 *
 * @author SC
 */
public class UserModel {
    //database variables
    String dbURL = "jdbc:mysql://localhost:3306/vid_project";
    String dbUser = "root";
    String dbPass = "root";
    Connection dbconnection;
    Statement dbstatement;
    ResultSet dbresults;
    
    //temporary working variables
    LinkedList<User> userList;
    User tempUser;
    String query;
    String tempStr;
    int tempInt;
    
    //get list of all users
    public LinkedList<User> getUsers() {
        
        query = "SELECT * FROM User ORDER BY Username;";
        
        try {
            //use mysql jdbc driver
            Class.forName("com.mysql.jdbc.Driver");
            
            //make the connection
            dbconnection = DriverManager.getConnection(dbURL, dbUser, dbPass);
            
            //get statement from connection
            dbstatement = dbconnection.createStatement();
            
            //query the database for the list of user videos
            dbresults = dbstatement.executeQuery(query);
            
            //initialize vidList
            userList = new LinkedList<User>();
            while (dbresults.next()) {
                tempUser = new User(dbresults.getInt(1), dbresults.getString(2), dbresults.getString(3), dbresults.getString(4), dbresults.getTimestamp(5));
                userList.add(tempUser);
            }
            
            return userList;
        } catch (Exception e) {
            return null;
        }
    }
    
    //get userid of a specific username
    public int getUserID(String username) {
        //create the query
        query = "SELECT UserID FROM USER WHERE username = '" + username + "';";
        
        try {
            //use mysql jdbc driver
            Class.forName("com.mysql.jdbc.Driver");

            //make the connection
            dbconnection = DriverManager.getConnection(dbURL, dbUser, dbPass);

            //get statement from connection
            dbstatement = dbconnection.createStatement();

            //query the database for the user
            dbresults = dbstatement.executeQuery(query);

            //transfer resultset to tempUser working variable
            dbresults.next();
            tempInt = dbresults.getInt(1);
            
            //close connection
            dbconnection.close();
            
            return tempInt;
        } catch (Exception e) {
            return -1;
        }
    }
    
    //overload getUserID to accept a User object
    public int getUserID(User user) {
        return getUserID(user.getUsername());
    }
    
    //get the username from a userid
    public String getUserName(int userid) {
        //create the query
        query = "SELECT Username FROM USER WHERE UserID = '" + userid + "';";
        
        try {
            //use mysql jdbc driver
            Class.forName("com.mysql.jdbc.Driver");

            //make the connection
            dbconnection = DriverManager.getConnection(dbURL, dbUser, dbPass);

            //get statement from connection
            dbstatement = dbconnection.createStatement();

            //query the database for the user
            dbresults = dbstatement.executeQuery(query);

            //transfer resultset to tempUser working variable
            dbresults.next();
            tempStr = dbresults.getString(1);
            
            //close connection
            dbconnection.close();
            
            return tempStr;
        } catch (Exception e) {
            return "";
        }
    }
    
    //overload getUserName to accept user object
    public String getUserName(User user) {
        return getUserName(user.getUserID());
    }
    
    //login method. should return the userid if username and password is correct and -1 otherwise
    public User Login(String email, String password) {
        //create the query
        query = "SELECT * FROM USER WHERE email = '" + email.toString() + "';";
        
        try {
            //use mysql jdbc driver
            Class.forName("com.mysql.jdbc.Driver");

            //make the connection
            dbconnection = DriverManager.getConnection(dbURL, dbUser, dbPass);

            //get statement from connection
            dbstatement = dbconnection.createStatement();

            //query the database for the user
            dbresults = dbstatement.executeQuery(query);

            //transfer resultset to tempUser working variable
            dbresults.next();
            tempUser = new User(dbresults.getInt(1), dbresults.getString(2), dbresults.getString(3), dbresults.getString(4), dbresults.getString(5));
            
            //close connection
            dbconnection.close();
        } catch (Exception e) {
            return null;
        }
        
        if (password.equals(tempUser.getPassword())) {
                return tempUser;
        } else {
                return null;
        }
    }
    
    //overloaded login to accept user object as a parameter
    public User Login(User user) {
        return Login(user.getEmail(), user.getPassword());
    }
    
    //user signup method. should return the user object if successful otherwise null
    public User Signup(String newUsername, String newPassword, String newEmail) {
        int index;
        query = "SELECT MAX(UserID) FROM USER;";
        
        try {
            //use mysql jdbc driver
            Class.forName("com.mysql.jdbc.Driver");

            //make the connection
            dbconnection = DriverManager.getConnection(dbURL, dbUser, dbPass);

            //get statement from connection
            dbstatement = dbconnection.createStatement();

            //query the database for the biggest userid
            dbresults = dbstatement.executeQuery(query);

            //transfer resultset to tempUser working variable
            if (dbresults.next()) {
                index = dbresults.getInt(1) + 1;
            } else {
                index = 1000;
            }
            
            query = "SELECT * FROM USERS WHERE username = '" + newUsername.toString() + "';";
            
            try {
                //query the database for the user
                dbresults = dbstatement.executeQuery(query);

                //close connection
                dbconnection.close();

                return null;
            } catch (Exception e) {
                Date today = new Date();
                Timestamp now = new Timestamp(today.getTime());
                tempUser = new User(index, newUsername.toString(), newPassword.toString(), newEmail.toString(), now.toString());
                query = "INSERT INTO User (UserID, Username, Password, Email, Joined) VALUES (" + 
                        index + ", '" + newUsername.toString() + "', '" + newPassword.toString() + "', '" +
                        newEmail.toString() + "', '" + now.toString() + "');";
                //try {
                //use mysql jdbc driver
                Class.forName("com.mysql.jdbc.Driver");

                //make the connection
                dbconnection = DriverManager.getConnection(dbURL, dbUser, dbPass);

                //get statement
                dbstatement = dbconnection.createStatement();

                //execute the query
                dbstatement.executeUpdate(query);

                //close connection
                dbconnection.close();

                return tempUser;
            }
        } catch(Exception e) {
            return null;
        }
    }
    
    //overloaded signup method
    public User Signup(User newUser) {
        return Signup(newUser.getUsername(), newUser.getPassword(), newUser.getEmail());
    }
}
