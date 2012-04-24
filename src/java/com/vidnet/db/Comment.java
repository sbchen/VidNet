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
public class Comment {
    private int commentid;
    private String content;
    private int videoid;
    private Timestamp posted;
    private int userid;
    
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
    
    public void setCommentID(int newcommentid) {
        commentid = newcommentid;
    }
    
    public void setContent(String newcontent) {
        content = newcontent;
    }
    
    public void setVideoID(int newvideoid) {
        videoid = newvideoid;
    }
    
    public void setPosted(Timestamp newposted) {
        posted = newposted;
    }
    
    public void setUserID(int newuserid) {
        userid = newuserid;
    }
    
    //constructors
    public Comment() {
        commentid = -1;
        content = "";
        videoid = -1;
        userid = -1;
    }
    
    public Comment(int newcommentid, String newcontent, int newvideoid, int newuserid) {
        commentid = newcommentid;
        content = newcontent;
        videoid = newvideoid;
        userid = newuserid;
    }
    
    public Comment(int newcommentid, String newcontent, int newvideoid, Timestamp newposted, int newuserid) {
        commentid = newcommentid;
        content = newcontent;
        videoid = newvideoid;
        posted = newposted;
        userid = newuserid;
    }
    
    public Comment(int newcommentid, String newcontent, int newvideoid, String newposted, int newuserid) {
        commentid = newcommentid;
        content = newcontent;
        videoid = newvideoid;
        posted = Timestamp.valueOf(newposted);
        userid = newuserid;
    }
}
