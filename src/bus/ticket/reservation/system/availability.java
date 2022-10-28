/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus.ticket.reservation.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Zarar bhai
 */
public class availability {
    Connection conn=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    DefaultTableModel model=new DefaultTableModel();
    public synchronized void bookTicket(String Name,String adress,String phone,String CNIC,String d,String seats,
            String to,
            String from,String category,String t) {
            conn=availability.connectdb();
            
        
            
                
                    System.out.println("ALL data recieved");
                    String sql="INSERT INTO ticketreservation(Name,Adress,phoneno,CNIC,Date,seats,destination,Start,Class,Timing)"
                + "VALUES(?,?,?,?,?,?,?,?,?,?)";
        try{
            pst=conn.prepareStatement(sql);
            pst.setString(1, Name);
            pst.setString(2, adress);
            pst.setString(3, phone);
            pst.setString(4, CNIC);
            pst.setString(5, d);
            pst.setString(6, seats);
            pst.setString(7, to);
            pst.setString(8, from);
            pst.setString(9, t);
            pst.setString(10, category);
            
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Data Inserted Successfully");
            pst.close();
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null,e+"abc");
                }
                
                
                
                
    }
    public static Connection connectdb(){
        try{
            Class.forName("org.sqlite.JDBC");
            Connection conn=DriverManager.getConnection("jdbc:sqlite:C:\\sqlite\\bussystem.db");
            System.out.println("connected");
            return conn;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
    
}
