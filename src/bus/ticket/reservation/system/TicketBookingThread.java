/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus.ticket.reservation.system;

/**
 *
 * @author Zarar bhai
 */
public class TicketBookingThread extends Thread{
    private    availability available;
    private    String Name;
    private    String CNIC;
    private    String adress;
    private    String phone;
    private    String seats;
    private    String to;
    private    String from;
    private    String category;
    private    String t;
    private    String d;
    //Name,Adress,phoneno,CNIC,Date,seats,destination,Start,Class,Timing
    TicketBookingThread(availability available,String Name,String adress,String phone,String CNIC,String d,String seats,
            String to,
            String from,String category,String t){
        this.available=available;
        this.Name=Name;
        this.adress=adress;
        this.phone=phone;
        this.CNIC=CNIC;
        this.d=d;
        this.seats=seats;
        this.to=to;
        this.from=from;
        this.category=category;
        this.t=t;
        
        
        
    }
    public void run() {
		available.bookTicket(Name,adress,phone,CNIC,d,seats,to,from,category,t);
	}
}
