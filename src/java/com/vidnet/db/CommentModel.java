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
    CommentContainer tempComCont;
    String query;
    LinkedList<Comment> comList;
    LinkedList<CommentContainer> comContList;
    
    //get comments of specified video
    public LinkedList<CommentContainer> getComments(int videoid) {
        query = "SELECT C.CommentID, C.Content, C.VideoID, C.Posted, C.UserID, U.Username FROM Comment C JOIN User U ON C.UserID = U.UserID WHERE VideoID = " + videoid + ";";
        
        try {
            //use mysql jdbc driver
            Class.forName("com.mysql.jdbc.Driver");
            
            //make the connection
            dbconnection = DriverManager.getConnection(dbURL, dbUser, dbPass);
            
            //make the statement
            dbstatement = dbconnection.createStatement();
            
            //query the database for the list of video comments
            dbresults = dbstatement.executeQuery(query);
            
            //initialize comList
            comContList = new LinkedList<CommentContainer>();
            while (dbresults.next()) {
                tempComCont = new CommentContainer(dbresults.getInt(1), dbresults.getString(2), dbresults.getInt(3), dbresults.getTimestamp(4), dbresults.getInt(5), dbresults.getString(6));
                comContList.add(tempComCont);
            }
            
            return comContList;
        } catch (Exception e) {
            return null;
        }
    }
    
    //overload get comments
    public LinkedList<CommentContainer> getComments(Video video) {
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
                    index + ", '" + content.replace("'", "''") + "', " + videoid + ", '" + now.toString() + "', " + userid + ");";
            
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
