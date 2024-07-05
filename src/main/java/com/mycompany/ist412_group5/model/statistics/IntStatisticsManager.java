package com.mycompany.ist412_group5.model.statistics;

import java.util.List;

/**
 * Interface for managing park statistics and user feedback.
 *
 * @author Bright Darko
 */
public interface IntStatisticsManager {

    /**
     * Retrieves real-time park statistics.
     *
     * @return the current park statistics
     */
    ParkStatistics getRealTimeStatistics();

    /**
     * Generates a report based on the park statistics.
     *
     * @return the generated report
     */
    Report generateReport();

    /**
     * Adds user feedback to the statistics manager.
     *
     * @param feedback the feedback to be added
     */
    void addFeedback(Feedback feedback);

    /**
     * Retrieves all user feedback.
     *
     * @return a list of all feedback
     */
    List<Feedback> getAllFeedback();
}
