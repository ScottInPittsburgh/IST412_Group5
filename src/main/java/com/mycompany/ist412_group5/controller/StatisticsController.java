package com.mycompany.ist412_group5.controller;

import com.mycompany.ist412_group5.model.statistics.ParkStatistics;
import com.mycompany.ist412_group5.model.statistics.Report;
import com.mycompany.ist412_group5.model.statistics.StatisticsManager;

/**
 * Controller for managing statistics-related operations.
 *
 * @author Bright Darko
 */
public class StatisticsController {

    private final StatisticsManager statisticsManager;

    public StatisticsController() {
        this.statisticsManager = new StatisticsManager();
    }

    /**
     * Retrieves real-time park statistics.
     * @return ParkStatistics object containing real-time statistics
     */
    public ParkStatistics getRealTimeStatistics() {
        return statisticsManager.getRealTimeStatistics();
    }

    /**
     * Generates a report based on park statistics.
     * @return Report object containing the generated report
     */
    public Report generateReport() {
        return statisticsManager.generateReport(); 
    }
}
