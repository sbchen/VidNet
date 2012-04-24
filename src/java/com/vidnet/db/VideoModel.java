/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vidnet.db;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Date;
import java.util.LinkedList;

/**
 *
 * @author SC
 */
public class VideoModel {
    //database variables
    String dbURL = "jdbc:mysql://localhost:3306/vid_project";
    String dbUser = "root";
    String dbPass = "root";
    Connection dbconnection;
    Statement dbstatement;
    ResultSet dbresults;
    
    //temporary working variables
    Video tempVid;
    String query;
    LinkedList<Video> vidList;
    
    //get videos posted by user
    public LinkedList<Video> getVideos(int userid) {
        query = "SELECT * from Video WHERE userid = " + userid + ";";
        
        try {
            //use mysql jdbc driver
            Class.forName("com.msql.jdbc.Driver");
            
            //make the connection
            dbconnection = DriverManager.getConnection(dbURL, dbUser, dbPass);
            
            //get statement from connection
            dbstatement = dbconnection.createStatement();
            
            //query the database for the list of user videos
            dbresults = dbstatement.executeQuery(query);
            
            //initialize vidList
            vidList = new LinkedList<Video>();
            while (dbresults.next()) {
                tempVid = new Video(dbresults.getInt(1), dbresults.getString(2), dbresults.getString(3), dbresults.getString(4), dbresults.getTimestamp(5), dbresults.getInt(6));
                vidList.add(tempVid);
            }
        } catch (Exception e) {
            return null;
        }
        return vidList;
    }
    
    //overloaded getVideos using user object
    public LinkedList<Video> getVideos(User user) {
        return getVideos(user.getUserID());
    }
    
    //video upload method
    public Video Upload(String title, String desc, String loc, int userid) {
        int index;
        query = "SELECT MAX(VideoID) from Video";
        
        try {
            //use mysql jdbc driver
            Class.forName("com.msql.jdbc.Driver");
            
            //make the connection
            dbconnection = DriverManager.getConnection(dbURL, dbUser, dbPass);
            
            //get statement from connection
            dbstatement = dbconnection.createStatement();
            
            //query the database for the max videoid
            dbresults = dbstatement.executeQuery(query);
            
            //extract the largest videoid
            if (dbresults.next()) {
                index = dbresults.getInt(1) + 1;
            } else {
                index = 2000;
            }
            
            Date today = new Date();
            Timestamp now = new Timestamp(today.getTime());
            tempVid = new Video(index, title, desc, loc, now, userid);
            query = "INSERT INTO Video (VideoID, Title, Description, Location, Posted, UserID) VALUES (" +
                    index + ", '" + title + "', '" + desc + "', '" + loc + "', '" + now.toString() + "', " + userid + ");";
            
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

            return tempVid;
        } catch (Exception e) {
            return null;
        }
    }
    
    //overloaded upload method
    public Video Upload(Video newVid) {
        return Upload(newVid.getTitle(), newVid.getDescription(), newVid.getLocation(), newVid.getUserID());
    }
}
