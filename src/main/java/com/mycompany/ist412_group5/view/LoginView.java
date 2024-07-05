package com.mycompany.ist412_group5.view;

import com.mycompany.ist412_group5.controller.FeedbackController;
import com.mycompany.ist412_group5.controller.StatisticsController;
import com.mycompany.ist412_group5.model.userprofile.UserProfile;
import com.mycompany.ist412_group5.model.userprofile.UserProfileManager;

import javax.swing.*;
import java.awt.*;

/**
 * View class for handling user login.
 *
 * @author Bright Darko
 */
public class LoginView {
    private UserProfileManager userProfileManager;
    private FeedbackController feedbackController;
    private StatisticsController statisticsController;

    /**
     * Constructs a LoginView instance.
     *
     * @param userProfileManager   the user profile manager for authentication
     * @param feedbackController   the feedback controller
     * @param statisticsController the statistics controller
     */
    public LoginView(UserProfileManager userProfileManager, FeedbackController feedbackController, StatisticsController statisticsController) {
        this.userProfileManager = userProfileManager;
        this.feedbackController = feedbackController;
        this.statisticsController = statisticsController;

        // Create the login frame
        JFrame frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        // Create a panel to hold the login components
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel, frame);

        // Make the frame visible
        frame.setVisible(true);
    }

    /**
     * Places the components on the panel.
     *
     * @param panel the panel to place components on
     * @param frame the frame containing the panel
     */
    private void placeComponents(JPanel panel, JFrame frame) {
        panel.setLayout(null);

        // User ID label and text field
        JLabel userLabel = new JLabel("User ID:");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        // Password label and text field
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);

        // Login button
        JButton loginButton = new JButton("login");
        loginButton.setBounds(10, 80, 80, 25);
        panel.add(loginButton);

        // Add action listener to handle login button click
        loginButton.addActionListener(e -> {
            String userId = userText.getText();
            String password = new String(passwordText.getPassword());
            System.out.println("Attempting login with UserID: " + userId);
            UserProfile user = userProfileManager.authenticate(userId, password);
            if (user != null) {
                // If authentication is successful, show the home view
                new HomeView(userProfileManager, feedbackController, statisticsController, user);
                frame.dispose();
            } else {
                // If authentication fails, show an error message
                System.out.println("Invalid credentials for UserID: " + userId);
                JOptionPane.showMessageDialog(frame, "Invalid credentials. Please try again.");
            }
        });
    }
}
