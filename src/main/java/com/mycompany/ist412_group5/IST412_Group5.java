/**
 * This package contains the main entry point for the project.
 * It includes the main class.
 */
package com.mycompany.ist412_group5;

import com.mycompany.ist412_group5.controller.SchedulingController;
import com.mycompany.ist412_group5.controller.StatisticsController;
import com.mycompany.ist412_group5.controller.TicketController;
import com.mycompany.ist412_group5.controller.UserProfileController;
import com.mycompany.ist412_group5.model.userprofile.UserProfileManager;
import com.mycompany.ist412_group5.view.SchedulingView;
import com.mycompany.ist412_group5.view.StatisticsView;
import com.mycompany.ist412_group5.view.TicketView;
import com.mycompany.ist412_group5.view.UserProfileView;
import com.mycompany.ist412_group5.view.HomeView;

/**
 * Main class for the IST412 Group 5 project.
 * Initializes controllers and views, and displays various information.
 */
public class IST412_Group5 {
    /**
     * main method, compiled project ran from here
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {

        HomeView homeView = new HomeView();

        //UserProfileController userProfileController = new UserProfileController(homeView, new UserProfileManager());
        SchedulingController schedulingController = new SchedulingController();
        StatisticsController statisticsController = new StatisticsController();
        TicketController ticketController = new TicketController();



        SchedulingView schedulingView = new SchedulingView();
        StatisticsView statisticsView = new StatisticsView();
        TicketView ticketView = new TicketView();
        //UserProfileView userProfileView = new UserProfileView(homeView);


        //schedulingController.exampleSchedulingMethod();
        //schedulingView.showActivities();

        // Displays the real-time statistics for the park
        statisticsView.displayRealTimeStatistics();
        // Displays the generated report based on the park statistics
        statisticsView.displayReport();

        ticketController.exampleTicketMethod();
        ticketView.showTickets();
    }
}
