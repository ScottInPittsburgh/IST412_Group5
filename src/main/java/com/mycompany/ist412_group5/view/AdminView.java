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
    public void displayUserFeedback(UserProfile user) { // Added user parameter
        JPanel panel = new JPanel(new BorderLayout());

        // Create a JList for displaying feedback
        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> feedbackList = new JList<>(listModel);
        feedbackList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Single selection mode
        feedbackList.setVisibleRowCount(10); // Set visible row count
        feedbackList.setFixedCellHeight(30); // Increase cell height for better visibility
        feedbackList.setFixedCellWidth(300); // Set cell width

        JScrollPane scrollPane = new JScrollPane(feedbackList);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Load feedback into the JList
        String[] feedbackArray = feedbackController.getAllFeedback().split("<br>");
        for (String feedback : feedbackArray) {
            listModel.addElement(feedback.replaceAll("<[^>]*>", "").trim()); // Remove HTML tags and trim
        }

        // Only add delete button if user is admin
        if ("admin".equals(user.getRole())) { // Check if user is admin
            JButton deleteButton = new JButton("Delete Review");
            deleteButton.addActionListener(e -> {
                String selectedFeedback = feedbackList.getSelectedValue();
                if (selectedFeedback != null && !selectedFeedback.isEmpty()) {
                    String strippedFeedback = selectedFeedback.replaceAll("^user:|admin:", "").replaceAll("<[^>]*>", "").trim(); // Ensure stripping HTML and user/admin labels
                    boolean success = feedbackController.deleteFeedback(strippedFeedback);
                    if (success) {
                        JOptionPane.showMessageDialog(panel, "Feedback deleted successfully!");
                        listModel.removeElement(selectedFeedback); // Remove deleted feedback from the list
                    } else {
                        JOptionPane.showMessageDialog(panel, "Failed to delete feedback.");
                    }
                } else {
                    JOptionPane.showMessageDialog(panel, "Please select feedback to delete.");
                }
            });
            panel.add(deleteButton, BorderLayout.SOUTH);
        }

        homeView.updateMainContentPanel(panel);
    }

}
