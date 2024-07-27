package com.mycompany.ist412_group5.controller;

import com.mycompany.ist412_group5.model.ticketing.IntTicketManager;
import com.mycompany.ist412_group5.model.ticketing.TicketManager;
import com.mycompany.ist412_group5.view.TicketView;

/**
 * Controller - ticket related operations
 *
 * @author Jed Galvo
 */
public class TicketController {
    private IntTicketManager ticketManager;
    private TicketView ticketView;

    /**
     * Construct new TicketController instance
     */
    public TicketController(TicketManager ticketManager) {
        this.ticketManager = ticketManager;
    }

    /**
     * Sets TicketView
     */
    public void setTicketView(TicketView ticketView) {
        this.ticketView = ticketView;
    }

}

