package com.mycompany.ist412_group5.model.statistics;

/**
 * StatisticsManager class to handle statistics-related operations.
 */
public class StatisticsManager {

    /**
     * Retrieves real-time park statistics.
     *
     * @return ParkStatistics object containing real-time statistics
     */
    public ParkStatistics getRealTimeStatistics() {

        return new ParkStatistics();
    }

    /**
     * Generates a report based on park statistics.
     *
     * @return Report object containing the generated report
     */
    public Report generateReport() {

        return new Report();
    }
}
