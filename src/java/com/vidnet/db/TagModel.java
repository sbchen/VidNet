/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vidnet.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

/**
 *
 * @author SC
 */
public class TagModel {
    //database variables
    String dbURL = "jdbc:mysql://localhost:3306/vid_project";
    String dbUser = "root";
    String dbPass = "root";
    Connection dbconnection;
    Statement dbstatement;
    ResultSet dbresults;
    
    //temporary working variables
    Tag tempTag;
    String query;
    LinkedList<Tag> tagList;
    
    //search tags for videos
    public LinkedList<Video> searchTags(String tags) {
        LinkedList<Video> vidList = new LinkedList<Video>();
        VideoModel vidModel = new VideoModel();
        
        tagList = getTaggedVideos(tags);
        
        for (Tag t : tagList) {
            vidList.add(vidModel.getInfo(t.getVideoID()));
        }
        
        return vidList;
    }
    
    //get all tags of a video
    public LinkedList<Tag> getTagList(int videoid) {
        query = "SELECT * FROM Tag WHERE VideoID = " + videoid + ";";
        
        try {
            //use mysql jdbc driver
            Class.forName("com.mysql.jdbc.Driver");
            
            //make the connection
            dbconnection = DriverManager.getConnection(dbURL, dbUser, dbPass);
            
            //get statement from connection
            dbstatement = dbconnection.createStatement();
            
            //query the database for the list of tagged videos
            dbresults = dbstatement.executeQuery(query);
            
            //initialize tagList
            tagList = new LinkedList<Tag>();
            while (dbresults.next()) {
                tempTag = new Tag(dbresults.getInt(1), dbresults.getString(2), dbresults.getInt(3));
                tagList.add(tempTag);
            }
            
            return tagList;
        } catch (Exception e) {
            return null;
        }
    }
    
    //overloaded getTagged method
    public LinkedList<Tag> getTagList(Tag tag) {
        return getTagList(tag.getVideoID());
    }
    
    //get videos that are tagged
    public LinkedList<Tag> getTaggedVideos(String tag) {
        query = "SELECT * FROM Tag WHERE TagName = '" + tag + "';";
        
        try {
            //use mysql jdbc driver
            Class.forName("com.mysql.jdbc.Driver");
            
            //make the connection
            dbconnection = DriverManager.getConnection(dbURL, dbUser, dbPass);
            
            //get statement from connection
            dbstatement = dbconnection.createStatement();
            
            //query the database for the list of tagged videos
            dbresults = dbstatement.executeQuery(query);
            
            //initialize tagList
            tagList = new LinkedList<Tag>();
            while (dbresults.next()) {
                tempTag = new Tag(dbresults.getInt(1), dbresults.getString(2), dbresults.getInt(3));
                tagList.add(tempTag);
            }
            
            return tagList;
        } catch (Exception e) {
            return null;
        }
    }
    
    //overloaded getTagged method
    public LinkedList<Tag> getTaggedVideos(Tag tag) {
        return getTaggedVideos(tag.getTagName());
    }
    
    //tag a video
    public Tag addTag(String tag, int videoid) {
        int index;
        query = "SELECT MAX(TagID) FROM Tag;";
        
        try {
            //use mysql jdbc driver
            Class.forName("com.mysql.jdbc.Driver");
            
            //make the connection
            dbconnection = DriverManager.getConnection(dbURL, dbUser, dbPass);
            
            //get statement from connection
            dbstatement = dbconnection.createStatement();
            
            //query the database for the max tagid
            dbresults = dbstatement.executeQuery(query);
            
            //extract the largest tagid
            if (dbresults.next()) {
                index = dbresults.getInt(1) + 1;
            } else {
                index = 500;
            }
            
            tempTag = new Tag(index, tag, videoid);
            query = "INSERT INTO Tag (TagID, TagName, VideoID) VALUES (" +
                    index + ", '" + tag.replace("'", "''") + "', " + videoid + ");";
            
            //execute the query
            dbstatement.executeUpdate(query);
            
            //close connection
            dbconnection.close();
            
            return tempTag;
        } catch (Exception e) {
            return null;
        }
    }
    
    //overloaded addTag
    public Tag addTag(Tag tag) {
        return addTag(tag.getTagName(), tag.getVideoID());
    }
}
