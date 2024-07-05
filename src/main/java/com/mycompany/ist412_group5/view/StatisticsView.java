package com.mycompany.ist412_group5.view;

import com.mycompany.ist412_group5.controller.StatisticsController;
import com.mycompany.ist412_group5.model.statistics.ParkStatistics;

import javax.swing.*;
import java.awt.*;

/**
 * View class for displaying park statistics.
 *
 * @author Bright Darko
 */
public class StatisticsView {
    private HomeView homeView;
    private StatisticsController statisticsController;

    /**
     * Constructs a StatisticsView instance.
     *
     * @param homeView             the home view instance to update the main content panel
     * @param statisticsController the statistics controller to fetch statistics data
     */
    public StatisticsView(HomeView homeView, StatisticsController statisticsController) {
        this.homeView = homeView;
        this.statisticsController = statisticsController;
    }

    /**
     * Displays the park statistics on the main content panel.
     */
    public void displayStatistics() {
        // Create a panel with BorderLayout
        JPanel panel = new JPanel(new BorderLayout());

        // Get the park statistics from the controller
        ParkStatistics statistics = statisticsController.getStatistics();

        // Create a text area to display the statistics
        JTextArea textArea = new JTextArea();
        textArea.setText("Attendance: " + statistics.getAttendance() + "\n" +
                "Ride Wait Times: " + statistics.getRideWaitTimes() + "\n" +
                "User Feedback: " + statistics.getUserFeedback());
        textArea.setEditable(false);

        // Add the text area to a scroll pane and then to the panel
        panel.add(new JScrollPane(textArea), BorderLayout.CENTER);

        // Update the main content panel with the statistics panel
        homeView.updateMainContentPanel(panel);
    }
}
