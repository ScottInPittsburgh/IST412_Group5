package com.mycompany.ist412_group5.view;

import com.mycompany.ist412_group5.controller.FeedbackController;

import javax.swing.*;
import java.awt.*;

/**
 * View class for displaying feedback-related user interface elements.
 *
 * @author Bright Darko
 */
public class FeedbackView {
    private FeedbackController feedbackController;
    private HomeView homeView;

    /**
     * Constructs a FeedbackView instance.
     *
     * @param homeView           the home view instance to update the main content panel
     * @param feedbackController the feedback controller to manage feedback operations
     */
    public FeedbackView(HomeView homeView, FeedbackController feedbackController) {
        this.homeView = homeView;
        this.feedbackController = feedbackController;
    }

    /**
     * Displays a form for adding feedback.
     *
     * @param userId the ID of the user providing the feedback
     */
    public void displayAddFeedbackForm(String userId) {
        // Create a panel with BorderLayout
        JPanel panel = new JPanel(new BorderLayout());

        // Create and add a label to the panel
        JLabel label = new JLabel("Enter your feedback:");
        JTextArea textArea = new JTextArea(5, 20);
        JButton submitButton = new JButton("Submit");

        // Set the action listener for the submit button
        submitButton.addActionListener(e -> {
            String feedbackText = textArea.getText();
            feedbackController.addFeedback(userId, feedbackText);
            JOptionPane.showMessageDialog(panel, "Feedback submitted successfully!");
            homeView.updateMainContentPanel(new JPanel());
        });

        // Add components to the panel
        panel.add(label, BorderLayout.NORTH);
        panel.add(new JScrollPane(textArea), BorderLayout.CENTER);
        panel.add(submitButton, BorderLayout.SOUTH);

        // Update the main content panel with the feedback form panel
        homeView.updateMainContentPanel(panel);
    }

    /**
     * Displays all feedback in a read-only format.
     */
    public void displayUserFeedback() {
        // Create a panel with BorderLayout
        JPanel panel = new JPanel(new BorderLayout());

        // Create a text pane for displaying feedback in HTML format
        JTextPane textPane = new JTextPane();
        textPane.setContentType("text/html");
        textPane.setEditable(false);

        // Get and set all feedback from the feedback controller
        String feedback = feedbackController.getAllFeedback();
        textPane.setText(feedback);

        // Add the text pane to a scroll pane and then to the panel
        panel.add(new JScrollPane(textPane), BorderLayout.CENTER);

        // Update the main content panel with the feedback display panel
        homeView.updateMainContentPanel(panel);
    }
}
