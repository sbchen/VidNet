/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vidnet.db;

/**
 *
 * @author SC
 */
public class Message {
    private int messageid;
    private String msgcontent;
    private int senderid;
    private int recipientid;
    
    //getter and setter methods
    public int getMessageID() {
        return messageid;
    }
    
    public String getMsgContet() {
        return msgcontent;
    }
    
    public int getSenderID() {
        return senderid;
    }
    
    public int getRecipientID() {
        return recipientid;
    }
    
    public void setMessageID(int newmessageid) {
        messageid = newmessageid;
    }
    
    public void setMsgContent(String newmsgcontent) {
        msgcontent = newmsgcontent;
    }
    
    public void setSenderID(int newsenderid) {
        senderid = newsenderid;
    }
    
    public void setRecipientID(int newrecipientid) {
        recipientid = newrecipientid;
    }
    
    //constructors
    public Message() {
        messageid = -1;
        msgcontent = "";
        senderid = -1;
        recipientid = -1;
    }
    
    public Message(int newmessageid, String newmsgcontent, int newsenderid, int newrecipientid) {
        messageid = newmessageid;
        msgcontent = newmsgcontent;
        senderid = newsenderid;
        recipientid = newrecipientid;
    }
}
