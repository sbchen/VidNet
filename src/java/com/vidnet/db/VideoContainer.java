/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vidnet.db;

import java.sql.Timestamp;
import java.util.LinkedList;

/**
 *
 * @author SC
 */
public class VideoContainer {
    private int videoid;
    private String title;
    private String desc;
    private String path;
    private Timestamp date;
    private int userid;
    private String username;
    private LinkedList<Tag> tagList;
    
    //setter and getter methods
    public int getVideoID() {
        return videoid;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getDesc() {
        return desc;
    }
    
    public String getUsername() {
        return username;
    }
    
    public String getPath() {
        return path;
    }
    
    public Timestamp getDate() {
        return date;
    }
    
    public int getUserID() {
        return userid;
    }
    
    public LinkedList<Tag> getTags() {
        return tagList;
    }
    
    public void setVideoID(int newID) {
        videoid = newID;
    }
    
    public void setTitle(String newTitle) {
        title = newTitle;
    }
    
    public void setDesc(String newDesc) {
        desc = newDesc;
    }
    
    public void setUsername(String newUsername) {
        username = newUsername;
    }
    
    public void setPath(String newPath) {
        path = newPath;
    }
    
    public void setDate(Timestamp newDate) {
        date = newDate;
    }
    
    public void setDate(String newDate) {
        date = Timestamp.valueOf(newDate);
    }
    
    public void setUserID(int newUserID) {
        userid = newUserID;
    }
    
    public void setTags(LinkedList<Tag> newTags) {
        tagList = newTags;
    }
    
    //constructors
    public VideoContainer() {
        tagList = null;
    }
    
    public VideoContainer(int newVideoID, String newTitle, String newDesc, String newPath, Timestamp newDate, int newUserID) {
        videoid = newVideoID;
        title = newTitle;
        desc = newDesc;
        path = newPath;
        date = newDate;
        userid = newUserID;
    }
    
    public VideoContainer(int newVideoID, String newTitle, String newDesc, String newPath, Timestamp newDate, int newUserID, String newUsername) {
        videoid = newVideoID;
        title = newTitle;
        desc = newDesc;
        path = newPath;
        date = newDate;
        userid = newUserID;
        username = newUsername;
    }
    
    public VideoContainer(int newVideoID, String newTitle, String newDesc, String newPath, Timestamp newDate, int newUserID, String newUsername, LinkedList<Tag> newTags) {
        videoid = newVideoID;
        title = newTitle;
        desc = newDesc;
        path = newPath;
        date = newDate;
        userid = newUserID;
        username = newUsername;
        tagList = newTags;
    }
}
