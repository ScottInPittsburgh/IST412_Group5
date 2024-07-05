package com.mycompany.ist412_group5;

import com.mycompany.ist412_group5.controller.FeedbackController;
import com.mycompany.ist412_group5.controller.StatisticsController;
import com.mycompany.ist412_group5.model.statistics.StatisticsManager;
import com.mycompany.ist412_group5.model.userprofile.UserProfileManager;
import com.mycompany.ist412_group5.view.LoginView;

/**
 * Main class for the IST412 Group 5 project.
 * Initializes controllers and views, and displays the login screen.
 */
public class IST412_Group5 {

    /**
     * Main method, the entry point of the application.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        // Initialize the user profile manager
        UserProfileManager userProfileManager = new UserProfileManager();

        // Initialize the statistics manager
        StatisticsManager statisticsManager = new StatisticsManager();

        // Initialize the feedback controller with the statistics manager
        FeedbackController feedbackController = new FeedbackController(statisticsManager);

        // Initialize the statistics controller with the statistics manager
        StatisticsController statisticsController = new StatisticsController(statisticsManager);

        // Display the login view
        new LoginView(userProfileManager, feedbackController, statisticsController);
    }
}
