/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vidnet.db;

/**
 *
 * @author SC
 */
public class Tag {
    private int tagid;
    private String tagname;
    private int videoid;
    
    //getter and setter methods
    public int getTagID() {
        return tagid;
    }
    
    public String getTagName() {
        return tagname;
    }
    
    public int getVideoID() {
        return videoid;
    }
    
    public void setTagID(int newtagid) {
        tagid = newtagid;
    }
    
    public void setTagName(String newtagname) {
        tagname = newtagname;
    }
    
    public void setVideoID(int newvideoid) {
        videoid = newvideoid;
    }
    
    //constructors
    public Tag() {
        tagid = -1;
        tagname = "";
        videoid = -1;
    }
    
    public Tag(int newtagid, String newtagname, int newvideoid) {
        tagid = newtagid;
        tagname = newtagname;
        videoid = newvideoid;
    }
}
