package com.mycompany.ist412_group5;

import com.mycompany.ist412_group5.controller.SchedulingController;
import com.mycompany.ist412_group5.controller.StatisticsController;
import com.mycompany.ist412_group5.controller.TicketController;
import com.mycompany.ist412_group5.controller.UserProfileController;
import com.mycompany.ist412_group5.view.SchedulingView;
import com.mycompany.ist412_group5.view.StatisticsView;
import com.mycompany.ist412_group5.view.TicketView;
import com.mycompany.ist412_group5.view.UserProfileView;

public class IST412_Group5 {
    public static void main(String[] args) {
        
        SchedulingController schedulingController = new SchedulingController();
        StatisticsController statisticsController = new StatisticsController();
        TicketController ticketController = new TicketController();
        UserProfileController userProfileController = new UserProfileController();

        SchedulingView schedulingView = new SchedulingView();
        StatisticsView statisticsView = new StatisticsView();
        TicketView ticketView = new TicketView();
        UserProfileView userProfileView = new UserProfileView();


        //schedulingController.exampleSchedulingMethod();
        //schedulingView.showActivities();

        // Display the real-time statistics for the park
        statisticsView.displayRealTimeStatistics();
        // Display the generated report based on the park statistics
        statisticsView.displayReport();

        ticketController.exampleTicketMethod();
        ticketView.showTickets();

        /**
         * Displays user profile
         */
        userProfileController.viewUserProfile();
    }
}
