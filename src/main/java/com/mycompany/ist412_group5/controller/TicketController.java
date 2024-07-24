package com.mycompany.ist412_group5.controller;

import com.mycompany.ist412_group5.model.ticketing.IntTicketManager;
import com.mycompany.ist412_group5.model.ticketing.TicketManager;


/**
 * Controller - ticket related operations
 */
public class TicketController {
    private IntTicketManager ticketManager;


     /**
     * Construct new TicketController instance
     */
    public TicketController(TicketManager ticketManager) {
        this.ticketManager = ticketManager;

    }
}
