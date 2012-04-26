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
public class CommentContainer {
    private int commentid;
    private String content;
    private int videoid;
    private Timestamp posted;
    private int userid;
    private String username;
    
    //getter and setter methods
    public int getCommentID() {
        return commentid;
    }
    
    public String getContent() {
        return content;
    }
    
    public int getVideoID() {
        return videoid;
    }
    
    public Timestamp getPosted() {
        return posted;
    }
    
    public int getUserID() {
        return userid;
    }
    
    public String getUsername() {
        return username;
    }
    
    //constructors
    public CommentContainer() {
        
    }
    
    public CommentContainer(int newCommentID, String newContent, int newVideoID, Timestamp newPosted, int newUserID, String newUsername) {
        commentid = newCommentID;
        content = newContent;
        videoid = newVideoID;
        posted = newPosted;
        userid = newUserID;
        username = newUsername;
    }
}
