/**
 * Package provides classes and interfaces for managing park statistics.
 * Includes classes for collecting, storing, and reporting statistical data.
 */
package com.mycompany.ist412_group5.model.statistics;

/**
 * Interface for StatisticsManager class.
 *
 * @author Bright Darko
 */

public interface IntStatisticsManager {

    /**
     * Retrieves real-time park statistics.
     *
     * @return ParkStatistics object containing real-time statistics
     */
    ParkStatistics getRealTimeStatistics();

    /**
     * Generates a report based on park statistics.
     *
     * @return Report object containing the generated report
     */
    Report generateReport();
}