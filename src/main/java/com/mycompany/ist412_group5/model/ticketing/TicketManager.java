package com.mycompany.ist412_group5.model.ticketing;

import java.util.ArrayList;

/**
 * Manage ticket operations
 *
 * @author Jed Galvo
 */
public class TicketManager implements IntTicketManager {
    private int ticketTotal = 0;
    private int ticketRemaining = 1000;
    private ArrayList<Integer> tempTicket = new ArrayList<>();

    /**
     * Purchases tickets and updates the remaining ticket count.
     *
     * @param amount the number of tickets to purchase
     * @param paymentMethod the payment method used for the purchase
     * @return a message indicating the result of the purchase
     */
    public String purchaseTickets(int amount, String paymentMethod) {
        if (amount <= 0) {
            return "The amount of ticket purchase needs to be higher than 0.";
        }

        if (amount > ticketRemaining) {
            return "Not enough tickets remaining.";
        }

        ticketTotal += amount;
        ticketRemaining -= amount;
        tempTicket.add(amount);

        // Calculate the price
        Price p = new Price();
        float ticketPrice = p.getPrice();
        double total = Math.round((ticketPrice * ticketTotal) * 100.00) / 100.00;

        tempTicket.clear();

        return "Purchase successful. Total: $" + total + " using " + paymentMethod;
    }
}

