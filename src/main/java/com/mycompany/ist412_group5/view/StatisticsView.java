package com.mycompany.ist412_group5.view;

import com.mycompany.ist412_group5.controller.StatisticsController;
import com.mycompany.ist412_group5.model.statistics.ParkStatistics;
import com.mycompany.ist412_group5.model.statistics.Report;

/**
 * View for displaying statistics-related information.
 *
 * @author Bright Darko
 */
public class StatisticsView {

    private final StatisticsController statisticsController;

    /**
     * Constructor to initialize StatisticsView.
     * Initializes the StatisticsController.
     */
    public StatisticsView() {
        this.statisticsController = new StatisticsController();
    }

    /**
     * Displays real-time statistics about the park.
     * Retrieves statistics from the StatisticsController and prints them to the console.
     */
    public void displayRealTimeStatistics() {
        ParkStatistics stats = statisticsController.getRealTimeStatistics();
        System.out.println("Attendance: " + stats.getAttendance());
        System.out.println("Ride Wait Times: " + stats.getRideWaitTimes());
        System.out.println("User Feedback: " + stats.getUserFeedback());
    }

    /**
     * Displays a generated report about the park.
     * Retrieves the report from the StatisticsController and prints its content to the console.
     */
    public void displayReport() {
        Report report = statisticsController.generateReport();
        System.out.println("Report Content: " + report.getContent());
    }
}
