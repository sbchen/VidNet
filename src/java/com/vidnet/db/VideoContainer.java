/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vidnet.db;

import java.util.LinkedList;

/**
 *
 * @author SC
 */
public class VideoContainer {
    private String title;
    private String desc;
    private String username;
    private String path;
    private String date;
    private LinkedList<Tag> tagList;
    
    //setter and getter methods
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
    
    public String getDate() {
        return date;
    }
    
    public LinkedList<Tag> getTags() {
        return tagList;
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
    
    public void setDate(String newDate) {
        date = newDate;
    }
    
    public void setTags(LinkedList<Tag> newTags) {
        tagList = newTags;
    }
    
    //constructors
    public VideoContainer() {
        tagList = null;
    }
    
    public VideoContainer(String newTitle, String newDesc, String newUsername, String newPath, String newDate, LinkedList<Tag> newTags) {
        title = newTitle;
        desc = newDesc;
        username = newUsername;
        path = newPath;
        date = newDate;
        tagList = newTags;
    }
}
