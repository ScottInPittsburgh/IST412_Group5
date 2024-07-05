/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ist412_group5.view;

import com.mycompany.ist412_group5.controller.Cart;
import TicketMaster.Price;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Jed Elijah Galvo
 */
public class CheckOut extends Cart{
    
    //variables for checkout class
    String payment = " ";
    static ArrayList<Ticket> ps = new ArrayList<>();
     ArrayList<Integer> ticket = new ArrayList<>();
     String creditCard = " ";
     double totalAmount = 0;
     
    
    //This method allows the user to see the number of tickets purchase, the purchase price (total) and the tax.
 public void add(ArrayList<Integer> x, int ticketTotal){
 String payment = JOptionPane.showInputDialog(null, "How do you want to pay? VISA, MasterCard, Amex, Chase or CapitalOne?");
 String card = " ";
 switch (payment){
 
     case "VISA": 
     case "Visa":
    
          card = "VISA";
         break;
         
     case "MasterCard":
     case "mastercard":
      
          card = "MasterCard";
         break;    
         
     case "Amex":
      
          card = "Amex";
         break;          
         
     case "Chase":
      
          card = "Chase";
         break;
         
     case "CapitalOne":
   
          card = "CapitalOne";
         break;          
                
     default:
               JOptionPane.showMessageDialog(null , "That is not a payment of method. Try another card.");
                add(x, ticketTotal);
 
 
 }
 
 Price p = new Price();
 float ticketPrice = p.getPrice();
 double total = Math.round((ticketPrice*ticketTotal)*100.00)/100.00;
 System.out.println(total);
  JOptionPane.showMessageDialog(null, "tickets purchased: " + x + " \n" + "YourTotal:" + total + "\n" + "Card: " + card );
 int input =  JOptionPane.showConfirmDialog(null, "Confirm perchase?");
 
 System.out.println(input);
 if(input ==1 || input ==2){
     int conf =  JOptionPane.showConfirmDialog(null, "Do you wish to change method of payment?");
     if(conf == 0 || conf == 3){add(x, ticketTotal);}
 }
 else{
    for(int i=0; i<=x.size()-1; i++){
    ticket.add(x.get(i));
    
    }
ps.add(new Ticket(ticket,total,card));

 
 }
 }
 
 public void viewingTickets(){
     
      for(int i=0; i<=ps.size()-1; i++){
  
           JOptionPane.showMessageDialog(null, "TotalTickets purchasae: " + ps.get(i).getTickets() + " \nYourTotalCharged: " 
                   + ps.get(i).getTotal() + " \nmethodOfPayment: " + ps.get(i).getCard());
     }

 
 }
 
 public void viewingTicketsCancel(){
    
   for(int i=0; i<=ps.size()-1; i++){
      int input = JOptionPane.showConfirmDialog(null, "TotalTickets purchasae: " + ps.get(i).getTickets() + " \nYourTotalCharged: " 
                   + ps.get(i).getTotal() + " \nmethodOfPayment: " + ps.get(i).getCard() + "\n" + "-----------------------------------------\n" +  "Do you want to cancel this Order?");
           
           System.out.println(input);
            if(input ==0){
     ps.remove(i);
   
 }
            else{
            }
     }
 
 
 }
 
 public ArrayList<Integer> callTickets()  {
     ArrayList<Integer> temp = new ArrayList<>();
 for(int i=0; i<=ticket.size()-1; i++){
 
 System.out.println(ticket.get(i));
 }
 
 return temp;
 }
 
 
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


class Ticket {
  private ArrayList<Integer> tickets = new ArrayList<>();
  private  double total;
  private String card;
  
   public Ticket(ArrayList<Integer> ticket, double total ,String card){
    this.tickets = ticket;
    this.total = total;
    this.card = card;
    }
    
    public ArrayList<Integer>  getTickets(){
        //System.out.println(tickets);
     return tickets;
    }
        
    public double getTotal(){return total;}
    public String getCard(){return card;}
    
@Override
public String toString(){
    return "Tickets: " + tickets + " YourTotalCharged: " + total + " card: " + card;
}




}

