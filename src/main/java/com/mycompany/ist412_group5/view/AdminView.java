package com.mycompany.ist412_group5.view;

import com.mycompany.ist412_group5.controller.FeedbackController;
import com.mycompany.ist412_group5.controller.UserProfileController;
import com.mycompany.ist412_group5.model.userprofile.UserProfile;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

/**
 * Admin view class for displaying and managing user profiles and feedback.
 *
 * @author Bright Darko
 */
public class AdminView {

    private HomeView homeView;
    private FeedbackController feedbackController;
    private UserProfileController userProfileController;

    /**
     * Constructs an AdminView instance.
     *
     * @param homeView              the home view instance to update the main content panel
     * @param feedbackController    the feedback controller to manage feedback operations
     * @param userProfileController the user profile controller to manage user profile operations
     */
    public AdminView(HomeView homeView, FeedbackController feedbackController, UserProfileController userProfileController) {
        this.homeView = homeView;
        this.feedbackController = feedbackController;
        this.userProfileController = userProfileController;
    }

    /**
     * Displays all user profiles in a text area.
     */
    public void displayAllUsers() {
        // Create a panel with BorderLayout
        JPanel panel = new JPanel(new BorderLayout());

        // Create a text area and wrap it in a scroll pane
        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Build the user information string
        StringBuilder userInfo = new StringBuilder();
        for (Map.Entry<String, UserProfile> entry : userProfileController.getAllUsers().entrySet()) {
            UserProfile user = entry.getValue();
            userInfo.append("ID: ").append(user.getUserId()).append("\n")
                    .append("Name: ").append(user.getName()).append("\n")
                    .append("Email: ").append(user.getEmail()).append("\n")
                    .append("Phone: ").append(user.getPhone()).append("\n\n");
        }
        textArea.setText(userInfo.toString());

        // Update the main content panel with the user information panel
        homeView.updateMainContentPanel(panel);
    }

    /**
     * Displays all user feedback in a text pane.
     */
    public void displayUserFeedback() {
        // Create a panel with BorderLayout
        JPanel panel = new JPanel(new BorderLayout());

        // Create a text pane for HTML content and wrap it in a scroll pane
        JTextPane textPane = new JTextPane();
        textPane.setContentType("text/html");
        JScrollPane scrollPane = new JScrollPane(textPane);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Get all feedback and set it as the text pane's content
        String feedback = feedbackController.getAllFeedback();
        textPane.setText(feedback);

        // Update the main content panel with the feedback panel
        homeView.updateMainContentPanel(panel);
    }
}
