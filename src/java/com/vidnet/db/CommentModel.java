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
public class CommentModel {
    //database variables
    String dbURL = "jdbc:mysql://localhost:3306/vid_project";
    String dbUser = "root";
    String dbPass = "root";
    Connection dbconnection;
    Statement dbstatement;
    ResultSet dbresults;
    
    //temporary working variables
    Comment tempCom;
    String query;
    LinkedList<Comment> comList;
    
    //get comments of specified video
    public LinkedList<Comment> getComments(int videoid) {
        query = "SELECT * FROM Comment WHERE VideoID = " + videoid + ";";
        
        try {
            //use mysql jdbc driver
            Class.forName("com.mysql.jdbc.Driver");
            
            //make the connection
            dbstatement = dbconnection.createStatement();
            
            //query the database for the list of video comments
            dbresults = dbstatement.executeQuery(query);
            
            //initialize comList
            comList = new LinkedList<Comment>();
            while (dbresults.next()) {
                tempCom = new Comment(dbresults.getInt(1), dbresults.getString(2), dbresults.getInt(3), dbresults.getTimestamp(4), dbresults.getInt(5));
                comList.add(tempCom);
            }
            
            return comList;
        } catch (Exception e) {
            return null;
        }
    }
    
    //overload get comments
    public LinkedList<Comment> getComments(Video video) {
        return getComments(video.getVideoID());
    }
    
    //post comment method
    public Comment Post(String content, int videoid, int userid) {
        int index;
        query = "SELECT MAX(CommentID) FROM Comment;";
        
        try {
            //use mysql jdbc driver
            Class.forName("com.mysql.jdbc.Driver");
            
            //make the connection
            dbconnection = DriverManager.getConnection(dbURL, dbUser, dbPass);
            
            //get statement from connection
            dbstatement = dbconnection.createStatement();
            
            //query the database for the max commentid
            dbresults = dbstatement.executeQuery(query);
            
            //extract the largest commentid
            if (dbresults.next()) {
                index = dbresults.getInt(1) + 1;
            } else {
                index = 1000;
            }
            
            Date today = new Date();
            Timestamp now = new Timestamp(today.getTime());
            tempCom = new Comment(index, content, videoid, now, userid);
            query = "INSERT INTO Comment (CommentID, Content, VideoID, Posted, UserID) VALUES (" +
                    index + ", '" + content + "', " + videoid + ", '" + now.toString() + "', " + userid + ");";
            
            //execute the insertion
            dbstatement.executeUpdate(query);
            
            return tempCom;
        } catch (Exception e) {
            return null;
        }
    }
    
    //overloaded post comment method
    public Comment Post(Comment comment) {
        return Post(comment.getContent(), comment.getVideoID(), comment.getUserID());
    }
}
