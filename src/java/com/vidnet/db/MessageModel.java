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
public class MessageModel {
    //database variables
    String dbURL = "jdbc:mysql://localhost:3306/vid_project";
    String dbUser = "root";
    String dbPass = "root";
    Connection dbconnection;
    Statement dbstatement;
    ResultSet dbresults;
    
    //temporary working variables
    Message tempMsg;
    String query;
    LinkedList<Message> msgList;
    
    //get messages sent to user
    public LinkedList<Message> getMsgsReceived(int userid) {
        query = "SELECT * FROM Message WHERE RecipientID = " + userid + " ORDER BY MessageID DESC;";
        
        try {
            //use mysql jdbc driver
            Class.forName("com.mysql.jdbc.Driver");
            
            //make the connection
            dbstatement = dbconnection.createStatement();
            
            //query the database for the list of messages
            dbresults = dbstatement.executeQuery(query);
            
            //initialize msgList
            msgList = new LinkedList<Message>();
            while (dbresults.next()) {
                tempMsg = new Message(dbresults.getInt(1), dbresults.getString(2), dbresults.getInt(3), dbresults.getInt(4));
                msgList.add(tempMsg);
            }
            
            return msgList;
        } catch (Exception e) {
            return null;
        }
    }
    
    //overloaded getMsgsReceived
    public LinkedList<Message> getMsgsReceived(User user) {
        return getMsgsReceived(user.getUserID());
    }
    
    //get messages sent from user
    public LinkedList<Message> getMsgsSent(int userid) {
        query = "SELECT * FROM Message WHERE SenderID = " + userid + " ORDER BY MessageID DESC;";
        
        try {
            //use mysql jdbc driver
            Class.forName("com.mysql.jdbc.Driver");
            
            //make the connection
            dbstatement = dbconnection.createStatement();
            
            //query the database for the list of messages
            dbresults = dbstatement.executeQuery(query);
            
            //initialize msgList
            msgList = new LinkedList<Message>();
            while (dbresults.next()) {
                tempMsg = new Message(dbresults.getInt(1), dbresults.getString(2), dbresults.getInt(3), dbresults.getInt(4));
                msgList.add(tempMsg);
            }
            
            return msgList;
        } catch (Exception e) {
            return null;
        }
    }
    
    //overloaded getMsgsSent
    public LinkedList<Message> getMsgsSent(User user) {
        return getMsgsSent(user.getUserID());
    }
    
    //send message method
    public Message Send(String content, int senderid, int recid) {
        int index;
        query = "SELECT MAX(MessageID) FROM Message;";
        
        try {
            //use mysql jdbc driver
            Class.forName("com.mysql.jdbc.Driver");
            
            //make the connection
            dbconnection = DriverManager.getConnection(dbURL, dbUser, dbPass);
            
            //get statement from connection
            dbstatement = dbconnection.createStatement();
            
            //query the database for the max messageid
            dbresults = dbstatement.executeQuery(query);
            
            //extract the largest messageid
            if (dbresults.next()) {
                index = dbresults.getInt(1) + 1;
            } else {
                index = 3000;
            }
            
            tempMsg = new Message(index, content, senderid, recid);
            query = "INSERT INTO Message (MessageID, MsgContent, SenderID, RecipientID) VALUES (" + 
                    index + ", '" + content.replace("'", "''") + "', " + senderid + ", " + recid + ");";
            
            //execute the insertion
            dbstatement.executeUpdate(query);
            
            return tempMsg;
            
        } catch (Exception e) {
            return null;
        }
    }
    
    //overloaded send message method
    public Message Send(Message msg) {
        return Send(msg.getMsgContent(), msg.getSenderID(), msg.getRecipientID());
    }
}
