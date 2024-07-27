/**
 * Package provides classes and interfaces for managing tickets within the application.
 * Includes classes for ticket operations like purchasing and canceling tickets.
 */
package com.mycompany.ist412_group5.model.ticketing;

/**
 * Interface defines the ticket management operations
 *
 * @author Jed Galvo
 */
public interface IntTicketManager {

    String purchaseTickets(int amount, String paymentMethod);
}
