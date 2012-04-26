/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vidnet.db;

/**
 *
 * @author SC
 */
public class MsgContainer {
    private String username;
    private String msg;
    
    //getter and setter methods
    public String getUsername() {
        return username;
    }
    
    public String getMsg() {
        return msg;
    }
    
    public void setUsername(String newUsername) {
        username = newUsername;
    }
    
    public void setMsg(String newMsg) {
        msg = newMsg;
    }
    
    //constructors
    public MsgContainer() {
        username = "";
        msg = "";
    }
    
    public MsgContainer(String newUsername, String newMsg) {
        username = newUsername;
        msg = newMsg;
    }
}
