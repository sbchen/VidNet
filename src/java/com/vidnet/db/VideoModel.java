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
public class VideoModel {
    //database variables
    String dbURL = "jdbc:mysql://localhost:3306/vid_project";
    String dbUser = "root";
    String dbPass = "root";
    Connection dbconnection;
    Statement dbstatement;
    ResultSet dbresults;
    
    TagModel tagModel;
    
    //temporary working variables
    Video tempVid;
    VideoContainer tempVidContainer;
    String query;
    LinkedList<Video> vidList;
    
    //get all information including tags of video
    public VideoContainer getAllInfo(int videoid) {
        query = "SELECT V.VideoID, V.Title, V.Description, V.Location, V.Posted, V.UserID, U.Username FROM Video V JOIN User U ON V.UserID = U.UserID WHERE V.VideoID = " + videoid + ";";
        
        try {
            //use mysql jdbc driver
            Class.forName("com.mysql.jdbc.Driver");
            
            //make the connection
            dbconnection = DriverManager.getConnection(dbURL, dbUser, dbPass);
            
            //get statement from connection
            dbstatement = dbconnection.createStatement();
            
            //query the database for the list of user videos
            dbresults = dbstatement.executeQuery(query);
            
            dbresults.next();
            tempVidContainer = new VideoContainer(dbresults.getInt(1), dbresults.getString(2), dbresults.getString(3), dbresults.getString(4), dbresults.getTimestamp(5), dbresults.getInt(6), dbresults.getString(7));
            
            //tempVidContainer.setTags(tagModel.getTagList(videoid));
            
            return tempVidContainer;
        } catch (Exception e) {
            return null;
        }
    }
    
    //get information of videoid
    public Video getInfo(int videoid) {
        query = "SELECT * FROM Video WHERE VideoID = " + videoid + ";";
        
        try {
            //use mysql jdbc driver
            Class.forName("com.mysql.jdbc.Driver");
            
            //make the connection
            dbconnection = DriverManager.getConnection(dbURL, dbUser, dbPass);
            
            //get statement from connection
            dbstatement = dbconnection.createStatement();
            
            //query the database for the list of user videos
            dbresults = dbstatement.executeQuery(query);
            
            dbresults.next();
            tempVid = new Video(dbresults.getInt(1), dbresults.getString(2), dbresults.getString(3), dbresults.getString(4), dbresults.getTimestamp(5), dbresults.getInt(6));
                        
            return tempVid;
        } catch (Exception e) {
            return null;
        }
    }
    
    //get videos posted by user
    public LinkedList<Video> getVideos(int userid) {
        query = "SELECT * FROM Video WHERE UserID = " + userid + " ORDER BY VideoID DESC;";
        
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
            vidList = new LinkedList<Video>();
            while (dbresults.next()) {
                tempVid = new Video(dbresults.getInt(1), dbresults.getString(2), dbresults.getString(3), dbresults.getString(4), dbresults.getTimestamp(5), dbresults.getInt(6));
                vidList.add(tempVid);
            }
            
            return vidList;
        } catch (Exception e) {
            return null;
        }
    }
    
    //overloaded getVideos using user object
    public LinkedList<Video> getVideos(User user) {
        return getVideos(user.getUserID());
    }
    
    //get random list of videos of size num
    public LinkedList<Video> getRandVideos(int num) {
        query = "SELECT * FROM Video ORDER BY RAND() LIMIT " + num + ";";
        
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
            vidList = new LinkedList<Video>();
            while (dbresults.next()) {
                tempVid = new Video(dbresults.getInt(1), dbresults.getString(2), dbresults.getString(3), dbresults.getString(4), dbresults.getTimestamp(5), dbresults.getInt(6));
                vidList.add(tempVid);
            }
            
            return vidList;
        } catch (Exception e) {
            return null;
        }
    }
    
    //overloaded getVideos using user object
    public LinkedList<Video> getRandVideos() {
        return getVideos(5);
    }
    
    //get next videoID
    public int NextVideoID() {
        int index;
        query = "SELECT MAX(VideoID) FROM Video;";
        
        try {
            //use mysql jdbc driver
            Class.forName("com.mysql.jdbc.Driver");
            
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
        } catch (Exception e) {
            index = 2000;
        }
        
        return index;
    }
    
    //video upload method
    public Video Upload(String title, String desc, String loc, int userid) {
        int index;
        query = "SELECT MAX(VideoID) FROM Video;";
        
        try {
            //use mysql jdbc driver
            Class.forName("com.mysql.jdbc.Driver");
            
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
            
//            Date today = new Date();
//            Timestamp now = new Timestamp(today.getTime());
//            tempVid = new Video(index, title, desc, loc, now, userid);
//            query = "INSERT INTO Video (VideoID, Title, Description, Location, Posted, UserID) VALUES (" +
//                    index + ", '" + title.repl + "', '" + desc + "', '" + loc + "', '" + now.toString() + "', " + userid + ");";
//
//            //execute the query
//            dbstatement.executeUpdate(query);
//
//            //close connection
//            dbconnection.close();
//
            return Upload(index, title, desc, loc, userid);
        } catch (Exception e) {
            return null;
        }
    }
    
    //overloaded upload method
    public Video Upload(Video newVid) {
        return Upload(newVid.getTitle(), newVid.getDescription(), newVid.getLocation(), newVid.getUserID());
    }
    
    //overloaded upload method with videoid parameter
    public Video Upload(int videoid, String title, String desc, String loc, int userid) {
        Date today = new Date();
        Timestamp now = new Timestamp(today.getTime());
        tempVid = new Video(videoid, title, desc, loc, now, userid);
        query = "INSERT INTO Video (VideoID, Title, Description, Location, Posted, UserID) VALUES (" +
                videoid + ", '" + title.replace("'", "''") + "', '" + desc.replace("'", "''") + "', '" + loc + "', '" + now.toString() + "', " + userid + ");";
        query = query.replace("\\", "\\\\");
        
        try {
            //use mysql jdbc driver
            Class.forName("com.mysql.jdbc.Driver");
            
            //make the connection
            dbconnection = DriverManager.getConnection(dbURL, dbUser, dbPass);
            
            //get statement from connection
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
}
