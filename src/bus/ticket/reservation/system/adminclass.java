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
public class adminclass {
    static Connection conn=null;
    static PreparedStatement pst=null;
    static ResultSet rs=null;
    static DefaultTableModel model=new DefaultTableModel();
     String page1;
    static String Name;
    static    String CNIC;
    static    String adress;
    static    String phone;
    static    String seats;
    static    String to;
    static    String from;
    static    String category;
    static    String t;
    static    String d;
    static    String valid;

     public static void main(String[] args) {
        setdata();
    }
     public static void setdata(){
         conn=adminclass.connectdb();
         String sql1="DELETE From reservations";
            try{
                pst=conn.prepareStatement(sql1);
                //pst.setString(1, );
                int a=pst.executeUpdate();
                
                //rs.close();
                pst.close();
                
            }catch(Exception e){
                System.out.println(e+"abc");
            }
         if(conn!=null){
        String sql="Select Name,Adress,phoneno,CNIC,Date,seats,destination,Start,Class,Timing from ticketreservation";
        try{
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            //Object[] columnData=new Object[7];
            while(rs.next()){
                availability available=new availability();
                Name=rs.getString("Name");
                adress=rs.getString("Adress");
                phone=rs.getString("phoneno");
                CNIC=rs.getString("CNIC");
                d=rs.getString("Date");
                seats=rs.getString("seats");
                to=rs.getString("destination");
                from=rs.getString("Start");
                category=rs.getString("Class");
                t=rs.getString("Timing");
                
                
                TicketBookingThread t1= new TicketBookingThread(available,Name,adress,phone,CNIC,d,seats,to,from,category,t);
                t1.start();
                
                
                
            }
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex+"System not Updated Successfully");
        }
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
