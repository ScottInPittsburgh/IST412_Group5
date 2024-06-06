package com.mycompany.ist412_group5.controller;

import com.mycompany.ist412_group5.model.ticketing.IntTicketManager;
import com.mycompany.ist412_group5.model.ticketing.TicketManager;
import com.mycompany.ist412_group5.view.TicketView;

public class TicketController {
    private IntTicketManager ticketManager;
    private TicketView ticketView;

    public TicketController() {
        this.ticketManager = new TicketManager();
        this.ticketView = new TicketView();
    }

    public void exampleTicketMethod() {
        ticketManager.exampleTicketMethod();
        ticketView.showTickets();
    }
}
