/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ist412_group5.view;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.Border;

/**
 *
 * @author Jed Elijah Galvo
 */
public class CheckOut {

    //variables for checkout class
    String payment = " ";
    private HomeView homeView;
    public JLabel test = new JLabel();
    public JButton VISA = new JButton();

    public JPanel panel = new JPanel(new BorderLayout());
    public JButton MasterCard = new JButton();
    public JButton AMEX = new JButton();
    public JButton CAPONE = new JButton();

    static ArrayList<Tickets> ps = new ArrayList<>();
    ArrayList<Integer> ticket = new ArrayList<>();
    String creditCard = " ";
    double totalAmount = 0;



    //This method allows the user to see the number of tickets purchase, the purchase price (total) and the tax.
    public void add(ArrayList<Integer> x, int ticketTotal){
        test.setText("How do you want to pay?");

        panel.add(VISA);
        panel.add(MasterCard);
        panel.add(AMEX);
        panel.add(CAPONE);
        homeView.updateMainContentPanel(panel);


        String payment = JOptionPane.showInputDialog(null, "How do you want to pay? VISA, MasterCard, Amex, Chase or CapitalOne?");
        String card = " ";
        switch (payment){

            case "VISA", "Visa" -> card = "VISA";
            case "MasterCard", "mastercard" -> card = "MasterCard";

            case "Amex" -> card = "Amex";
            case "Chase" -> card = "Chase";

            case "CapitalOne" -> card = "CapitalOne";

            default -> {
                JOptionPane.showMessageDialog(null , "That is not a payment of method. Try another card.");
                add(x, ticketTotal);
            }


        }

        com.mycompany.ist412_group5.model.ticketing.Price p = new com.mycompany.ist412_group5.model.ticketing.Price();
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
            ps.add(new Tickets(ticket,total,card));


        }
    }

    public void viewingTickets(){

        for(int i=0; i<=ps.size()-1; i++){

            JOptionPane.showMessageDialog(null, "TotalTickets purchasae: " + ps.get(i).getTickets() + " \nYourTotalCharged: "
                    + ps.get(i).getTotal() + " \nmethodOfPayment: " + ps.get(i).getCard());
        }


    }

    public ArrayList<Integer> viewingTicketsCancel(){

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

        return null;
    }

    public ArrayList<Integer> callTickets()  {
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i=0; i<=ticket.size()-1; i++){

            System.out.println(ticket.get(i));
        }

        return temp;
    }


}


class Tickets {
    private ArrayList<Integer> tickets = new ArrayList<>();
    private  double total;
    private String card;

    public Tickets(ArrayList<Integer> ticket, double total ,String card){
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


