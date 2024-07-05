package com.mycompany.ist412_group5.controller;

import com.mycompany.ist412_group5.model.statistics.Feedback;
import com.mycompany.ist412_group5.model.statistics.StatisticsManager;
import com.mycompany.ist412_group5.view.FeedbackView;

/**
 * Controller class for managing feedback operations.
 *
 * @author Bright Darko
 */
public class FeedbackController {
    private StatisticsManager statisticsManager;
    private FeedbackView feedbackView;

    /**
     * Constructs a FeedbackController instance.
     *
     * @param statisticsManager the statistics manager to handle feedback data
     */
    public FeedbackController(StatisticsManager statisticsManager) {
        this.statisticsManager = statisticsManager;
    }

    /**
     * Adds feedback from a user.
     *
     * @param userId       the ID of the user providing the feedback
     * @param feedbackText the text of the feedback
     */
    public void addFeedback(String userId, String feedbackText) {
        Feedback feedback = new Feedback(userId, feedbackText);
        statisticsManager.addFeedback(feedback);
    }

    /**
     * Retrieves all feedback as a formatted HTML string.
     *
     * @return a string containing all feedback formatted as HTML
     */
    public String getAllFeedback() {
        StringBuilder feedbackText = new StringBuilder();
        for (Feedback feedback : statisticsManager.getAllFeedback()) {
            feedbackText.append("<b>").append(feedback.getUserId()).append("</b>: ").append(feedback.getText()).append("<br>");
        }
        return feedbackText.toString();
    }
}
