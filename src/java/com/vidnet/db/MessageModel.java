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
    MsgContainer msgContainer;
    String query;
    LinkedList<MsgContainer> msgList;
    
    //get messages sent to user
    public LinkedList<MsgContainer> getMsgsReceived(int userid) {
//        query = "SELECT * FROM Message WHERE RecipientID = " + userid + " ORDER BY MessageID DESC;";
        query = "SELECT Username, MsgContent FROM Message JOIN User ON SenderID = UserID WHERE RecipientID = " + userid + " ORDER BY MessageID DESC;";
        
        try {
            //use mysql jdbc driver
            Class.forName("com.mysql.jdbc.Driver");
            
            //make the connection
            dbconnection = DriverManager.getConnection(dbURL, dbUser, dbPass);
            
            //make the statement
            dbstatement = dbconnection.createStatement();
            
            //query the database for the list of messages
            dbresults = dbstatement.executeQuery(query);
            
            //initialize msgList
            msgList = new LinkedList<MsgContainer>();
            while (dbresults.next()) {
//                tempMsg = new Message(dbresults.getInt(1), dbresults.getString(2), dbresults.getInt(3), dbresults.getInt(4));
                msgContainer = new MsgContainer(dbresults.getString(1), dbresults.getString(2));
                msgList.add(msgContainer);
            }
            
            return msgList;
        } catch (Exception e) {
            return null;
        }
    }
    
    //overloaded getMsgsReceived
    public LinkedList<MsgContainer> getMsgsReceived(User user) {
        return getMsgsReceived(user.getUserID());
    }
    
    //get messages sent from user
    public LinkedList<MsgContainer> getMsgsSent(int userid) {
//        query = "SELECT * FROM Message WHERE SenderID = " + userid + " ORDER BY MessageID DESC;";
        query = "SELECT Username, MsgContent FROM Message JOIN User ON RecipientID = UserID WHERE SenderID = " + userid + " ORDER BY MessageID DESC;";
        
        try {
            //use mysql jdbc driver
            Class.forName("com.mysql.jdbc.Driver");
            
            //make the connection
            dbstatement = dbconnection.createStatement();
            
            //query the database for the list of messages
            dbresults = dbstatement.executeQuery(query);
            
            //initialize msgList
            msgList = new LinkedList<MsgContainer>();
            while (dbresults.next()) {
//                tempMsg = new Message(dbresults.getInt(1), dbresults.getString(2), dbresults.getInt(3), dbresults.getInt(4));
                msgList.add(msgContainer);
            }
            
            return msgList;
        } catch (Exception e) {
            return null;
        }
    }
    
    //overloaded getMsgsSent
    public LinkedList<MsgContainer> getMsgsSent(User user) {
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
