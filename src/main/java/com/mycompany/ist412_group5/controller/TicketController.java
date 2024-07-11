package com.mycompany.ist412_group5.controller;

import com.mycompany.ist412_group5.model.ticketing.IntTicketManager;
import com.mycompany.ist412_group5.model.ticketing.TicketManager;
import com.mycompany.ist412_group5.view.TicketView;

/**
 * Controller - ticket related operations
 */
public class TicketController {
    private IntTicketManager ticketManager;
    private TicketView ticketView;

     /**
     * Construct new TicketController instance
     */
    public TicketController(TicketManager ticketManager, TicketView ticketView) {
        this.ticketManager = new TicketManager();
        this.ticketView = new TicketView();
    }

    /**
     * Example standin method for ticket handling
     */
    public void exampleTicketMethod() {
        ticketManager.exampleTicketMethod();
        ticketView.showTickets();
    }
}
