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
public class Video {
    private int videoid;
    private String title;
    private String description;
    private String location;
    private Timestamp posted;
    private int userid;
    
    //getter and setter methods
    public int getVideoID() {
        return videoid;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getDescription() {
        return description;
    }
    
    public String getLocation() {
        return location;
    }
    
    public Timestamp getPosted() {
        return posted;
    }
    
    public int getUserID() {
        return userid;
    }
    
    public void setVideoID(int newid) {
        videoid = newid;
    }
    
    public void setTitle(String newTitle) {
        title = newTitle;
    }
    
    public void setDescription(String newDescription) {
        description = newDescription;
    }
    
    public void setUserID(int newuserid) {
        userid = newuserid;
    }
    
    //constructors
    public Video() {
        videoid = 0;
        title = "";
        description = "";
        location = "";
        posted = null;
        userid = 0;
    }
    
    public Video(int newVideoID, String newTitle, String newDesc, String newLoc, int newUserID) {
        videoid = newVideoID;
        title = newTitle;
        description = newDesc;
        location = newLoc;
        userid = newUserID;
    }
    
    public Video(int newVideoID, String newTitle, String newDesc, String newLoc, Timestamp newPosted, int newUserID) {
        videoid = newVideoID;
        title = newTitle;
        description = newDesc;
        location = newLoc;
        posted = newPosted;
        userid = newUserID;
    }
    
    public Video(int newVideoID, String newTitle, String newDesc, String newLoc, String newPosted, int newUserID) {
        videoid = newVideoID;
        title = newTitle;
        description = newDesc;
        location = newLoc;
        posted = Timestamp.valueOf(newPosted);
        userid = newUserID;
    }
}
