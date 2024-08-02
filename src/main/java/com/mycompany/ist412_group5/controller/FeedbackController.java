package com.mycompany.ist412_group5.controller;

import com.mycompany.ist412_group5.model.statistics.Feedback;
import com.mycompany.ist412_group5.model.statistics.StatisticsManager;


import java.util.List;

/**
 * Controller class for managing feedback operations.
 *
 * @author Bright Darko
 */
public class FeedbackController {
    private StatisticsManager statisticsManager;

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
        feedbackText.append("<html>"); // Start HTML
        for (Feedback feedback : statisticsManager.getAllFeedback()) {
            feedbackText.append("<span style='color:blue;'><b>")
                    .append(feedback.getUserId())
                    .append("</b></span>: ")
                    .append(feedback.getText())
                    .append("<br>");
        }
        feedbackText.append("</html>"); // End HTML
        return feedbackText.toString();
    }


    /**
     * Deletes feedback by the feedback text.
     *
     * @param feedbackText the text of the feedback to be deleted
     * @return true if the feedback was deleted, false otherwise
     */
    public boolean deleteFeedback(String feedbackText) {
        feedbackText = feedbackText.replaceAll("<[^>]*>", "").replaceAll("^user:|admin:", "").trim(); // Remove HTML tags, user/admin labels, and trim
        System.out.println("Attempting to delete feedback: " + feedbackText); // Debug line
        return statisticsManager.deleteFeedback(feedbackText);
    }







}

