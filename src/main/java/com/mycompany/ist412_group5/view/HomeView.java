package com.mycompany.ist412_group5.view;

import com.mycompany.ist412_group5.controller.*;
import com.mycompany.ist412_group5.model.ticketing.TicketManager;
import com.mycompany.ist412_group5.model.userprofile.UserProfile;
import com.mycompany.ist412_group5.model.userprofile.UserProfileManager;

import javax.swing.*;
import java.awt.*;

/**
 * Main view class for the WallyLand Vacation Planner application.
 * Handles the display of various components based on user actions.
 */
public class HomeView {
    private JPanel mainContentPanel;
    private UserProfileManager userProfileManager;
    private FeedbackController feedbackController;
    private StatisticsController statisticsController;
    private UserProfile user;
    private TicketController ticketController;
    private TicketView ticketView;
    private TicketManager ticketManager;
    private SchedulingController schedulingController;

    /**
     * Constructs a HomeView instance.
     *
     * @param userProfileManager   the user profile manager instance to manage user profiles
     * @param feedbackController   the feedback controller to handle feedback operations
     * @param statisticsController the statistics controller to handle statistics operations
     * @param user                 the currently logged-in user
     * @param ticketController
     * @param ticketView
     * @param ticketManager
     */
    public HomeView(UserProfileManager userProfileManager, FeedbackController feedbackController, StatisticsController statisticsController, UserProfile user, TicketController ticketController) {
        this.userProfileManager = userProfileManager;
        this.feedbackController = feedbackController;
        this.statisticsController = statisticsController;
        this.user = user;
        this.ticketController = ticketController;
        this.schedulingController = new SchedulingController(this, user);
      

        JFrame frame = new JFrame("WallyLand Vacation Planner");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());
        frame.setResizable(false);

        String userName = user.getName();
        String role = user.getRole();

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(20, 10, 20, 10),
                BorderFactory.createMatteBorder(0, 0, 0, 1, Color.BLACK)
        ));
        buttonPanel.setPreferredSize(new Dimension(200, frame.getHeight()));

        JLabel welcomeLabel = new JLabel("<html><div style='text-align: center;'><b><font size='5'>Welcome,<br>" + userName + "</font></b></div></html>");
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);

        JPanel welcomePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        welcomePanel.add(welcomeLabel);

        buttonPanel.add(welcomePanel);

        JButton userProfileButton = new JButton("User Profile");
        JButton purchaseTicketsButton = new JButton("Purchase Tickets");
        JButton scheduleActivitiesButton = new JButton("Schedule Activities");
        JButton viewStatisticsButton = new JButton("View Statistics");
        JButton addFeedbackButton = new JButton("Add Feedback");
        JButton viewFeedbackButton = new JButton("View Feedback");
        JButton adminViewUsersButton = new JButton("View Users");
        JButton quitButton = new JButton("Quit");

        Dimension buttonSize = new Dimension(160, 30);
        userProfileButton.setMaximumSize(buttonSize);
        purchaseTicketsButton.setMaximumSize(buttonSize);
        scheduleActivitiesButton.setMaximumSize(buttonSize);
        viewStatisticsButton.setMaximumSize(buttonSize);
        addFeedbackButton.setMaximumSize(buttonSize);
        viewFeedbackButton.setMaximumSize(buttonSize);
        adminViewUsersButton.setMaximumSize(buttonSize);
        quitButton.setMaximumSize(buttonSize);

        userProfileButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        purchaseTicketsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        scheduleActivitiesButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        viewStatisticsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        addFeedbackButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        viewFeedbackButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        adminViewUsersButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        quitButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Handle user profile action
        userProfileButton.addActionListener(e -> {
            UserProfileController userProfileController = new UserProfileController(this, userProfileManager);
            userProfileController.viewUserProfile(user.getUserId());
        });

        // Handle purchase tickets action
        purchaseTicketsButton.addActionListener(e -> {
            JPanel purchasePanel = new JPanel();
          Cart cart = new Cart();
            cart.inital();
        });

        // Handle schedule activities action
        scheduleActivitiesButton.addActionListener(e -> {
            schedulingController.showSchedulingView();
        });

        // Handle view statistics action for admin only
        if ("admin".equals(role)) {
            viewStatisticsButton.addActionListener(e -> {
                StatisticsView statisticsView = new StatisticsView(this, statisticsController);
                statisticsView.displayStatistics();
            });
        } else {
            viewStatisticsButton.setEnabled(false);
        }

        // Handle add feedback action
        addFeedbackButton.addActionListener(e -> {
            FeedbackView feedbackView = new FeedbackView(this, feedbackController);
            feedbackView.displayAddFeedbackForm(user.getUserId());
        });

        // Handle view feedback action
        viewFeedbackButton.addActionListener(e -> {
            FeedbackView feedbackView = new FeedbackView(this, feedbackController);
            feedbackView.displayAllFeedback();
        });

        // Handle admin view users action
        if ("admin".equals(role)) {
            adminViewUsersButton.addActionListener(e -> {
                AdminView adminView = new AdminView(this, feedbackController, new UserProfileController(this, userProfileManager));
                adminView.displayAllUsers();
            });
        } else {
            adminViewUsersButton.setEnabled(false);
        }

        quitButton.addActionListener(e -> System.exit(0));

        buttonPanel.add(Box.createVerticalStrut(10));
        buttonPanel.add(Box.createVerticalStrut(80));
        buttonPanel.add(userProfileButton);
        buttonPanel.add(Box.createVerticalStrut(15));
        buttonPanel.add(purchaseTicketsButton);
        buttonPanel.add(Box.createVerticalStrut(15));
        buttonPanel.add(scheduleActivitiesButton);
        buttonPanel.add(Box.createVerticalStrut(15));
        buttonPanel.add(viewStatisticsButton);
        buttonPanel.add(Box.createVerticalStrut(15));
        buttonPanel.add(addFeedbackButton);
        buttonPanel.add(Box.createVerticalStrut(15));
        buttonPanel.add(viewFeedbackButton);
        if ("admin".equals(role)) {
            buttonPanel.add(Box.createVerticalStrut(15));
            buttonPanel.add(adminViewUsersButton);
        }
        buttonPanel.add(Box.createVerticalGlue());
        buttonPanel.add(Box.createVerticalStrut(15));
        buttonPanel.add(quitButton);

        mainContentPanel = new JPanel();
        mainContentPanel.setLayout(new BorderLayout());
        mainContentPanel.setBackground(Color.LIGHT_GRAY);

        frame.add(buttonPanel, BorderLayout.WEST);
        frame.add(mainContentPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    /**
     * Updates the main content panel with a new panel.
     *
     * @param newPanel the new panel to be displayed
     */
    public void updateMainContentPanel(JPanel newPanel) {
        mainContentPanel.removeAll();
        mainContentPanel.add(newPanel, BorderLayout.CENTER);
        mainContentPanel.revalidate();
        mainContentPanel.repaint();
    }

    /**
     * Returns the user profile manager.
     *
     * @return the user profile manager
     */
    public UserProfileManager getUserProfileManager() {
        return userProfileManager;
    }
}
