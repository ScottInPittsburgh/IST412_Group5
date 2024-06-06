package com.mycompany.ist412_group5.view;

import com.mycompany.ist412_group5.controller.StatisticsController;
import com.mycompany.ist412_group5.model.statistics.ParkStatistics;
import com.mycompany.ist412_group5.model.statistics.Report;

/**
 * View for displaying statistics-related information.
 */
public class StatisticsView {

    private StatisticsController statisticsController;

    public StatisticsView() {
        this.statisticsController = new StatisticsController();
    }

    public void displayRealTimeStatistics() {
        ParkStatistics stats = statisticsController.getRealTimeStatistics();
        System.out.println("Attendance: " + stats.getAttendance());
        System.out.println("Ride Wait Times: " + stats.getRideWaitTimes());
        System.out.println("User Feedback: " + stats.getUserFeedback());
    }

    public void displayReport() {
        Report report = statisticsController.generateReport();
        System.out.println("Report Content: " + report.getContent());
    }
}
