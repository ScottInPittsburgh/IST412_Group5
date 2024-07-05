package com.mycompany.ist412_group5.controller;

import com.mycompany.ist412_group5.model.statistics.ParkStatistics;
import com.mycompany.ist412_group5.model.statistics.StatisticsManager;

/**
 * Controller class for managing statistics-related operations.
 *
 * @author Bright Darko
 */
public class StatisticsController {
    private StatisticsManager statisticsManager;

    /**
     * Constructs a StatisticsController instance.
     *
     * @param statisticsManager the statistics manager to handle data operations
     */
    public StatisticsController(StatisticsManager statisticsManager) {
        this.statisticsManager = statisticsManager;
    }

    /**
     * Retrieves real-time park statistics.
     *
     * @return the current park statistics
     */
    public ParkStatistics getStatistics() {
        return statisticsManager.getRealTimeStatistics();
    }
}
