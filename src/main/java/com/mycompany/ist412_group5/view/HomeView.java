package com.mycompany.ist412_group5.view;

import com.mycompany.ist412_group5.controller.UserProfileController;
import com.mycompany.ist412_group5.model.userprofile.UserProfileManager;
import com.mycompany.ist412_group5.model.userprofile.UserProfile;

import javax.swing.*;
import java.awt.*;

public class HomeView {

    private JPanel mainContentPanel;
    private UserProfileManager userProfileManager;

    public HomeView() {
        JFrame frame = new JFrame("WallyLand Vacation Planner");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        userProfileManager = new UserProfileManager();

        // Get the user's name for the welcome message
        UserProfile user = userProfileManager.getUser();
        String userName = user.getName();

        // Panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(20, 10, 20, 10), // padding around the panel
                BorderFactory.createMatteBorder(0, 0, 0, 1, Color.BLACK) // line on the right side
        ));
        buttonPanel.setPreferredSize(new Dimension(200, frame.getHeight())); // set size for the button panel


        // Welcome message
        JLabel welcomeLabel = new JLabel("<html><div style='text-align: center;'><b><font size='5'>Welcome,<br>" + userName + "</font></b></div></html>");
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);

        JPanel welcomePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        welcomePanel.add(welcomeLabel);

        // Adding the welcomePanel to the buttonPanel
        buttonPanel.add(welcomePanel);

        JButton userProfileButton = new JButton("User Profile");
        JButton purchaseTicketsButton = new JButton("Purchase Tickets");
        JButton scheduleActivitiesButton = new JButton("Schedule Activities");
        JButton viewStatisticsButton = new JButton("View Statistics");
        JButton quitButton = new JButton("Quit");

        // Set a larger preferred size for the buttons
        Dimension buttonSize = new Dimension(160, 30);
        userProfileButton.setMaximumSize(buttonSize);
        purchaseTicketsButton.setMaximumSize(buttonSize);
        scheduleActivitiesButton.setMaximumSize(buttonSize);
        viewStatisticsButton.setMaximumSize(buttonSize);
        quitButton.setMaximumSize(buttonSize);

        // Center-align the buttons
        userProfileButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        purchaseTicketsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        scheduleActivitiesButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        viewStatisticsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        quitButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        UserProfileController userProfileController = new UserProfileController(this, userProfileManager);

        userProfileButton.addActionListener(e -> userProfileController.viewUserProfile());

        // Add ticket button functionality here. See userProfileButton example above
        purchaseTicketsButton.addActionListener(e -> System.out.println("Purchase Tickets clicked"));

        // Add scheduling button functionality here. See userProfileButton example above
        scheduleActivitiesButton.addActionListener(e -> System.out.println("Schedule Activities clicked"));

        // Add statistics button functionality here. See userProfileButton example above
        viewStatisticsButton.addActionListener(e -> System.out.println("View Statistics clicked"));

        quitButton.addActionListener(e -> System.exit(0)); // terminates the application

        // Add vertical struts for spacing
        buttonPanel.add(Box.createVerticalStrut(10)); // space above the welcome message
        buttonPanel.add(Box.createVerticalStrut(80)); // space above the first button
        buttonPanel.add(userProfileButton);
        buttonPanel.add(Box.createVerticalStrut(15)); // space between buttons
        buttonPanel.add(purchaseTicketsButton);
        buttonPanel.add(Box.createVerticalStrut(15)); // space between buttons
        buttonPanel.add(scheduleActivitiesButton);
        buttonPanel.add(Box.createVerticalStrut(15)); // space between buttons
        buttonPanel.add(viewStatisticsButton);
        buttonPanel.add(Box.createVerticalGlue()); // push buttons upwards
        buttonPanel.add(Box.createVerticalStrut(15)); // space between buttons and Quit button
        buttonPanel.add(quitButton); // add the Quit button at the very bottom

        // Main content panel (background)
        mainContentPanel = new JPanel();
        mainContentPanel.setLayout(new BorderLayout());
        mainContentPanel.setBackground(Color.LIGHT_GRAY);

        frame.add(buttonPanel, BorderLayout.WEST);
        frame.add(mainContentPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    public void updateMainContentPanel(JPanel newPanel) {
        mainContentPanel.removeAll();
        mainContentPanel.add(newPanel, BorderLayout.CENTER);
        mainContentPanel.revalidate();
        mainContentPanel.repaint();
    }

    // Method to get the UserProfileManager instance
    public UserProfileManager getUserProfileManager() {
        return userProfileManager;
    }
}
