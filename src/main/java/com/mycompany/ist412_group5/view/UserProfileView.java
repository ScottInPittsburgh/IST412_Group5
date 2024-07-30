package com.mycompany.ist412_group5.view;

import com.mycompany.ist412_group5.model.userprofile.UserProfile;
import com.mycompany.ist412_group5.model.userprofile.EmergencyContact;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * View class for displaying and editing user profiles.
 *
 * @author Frank Imbrunone
 */
public class UserProfileView {

    private HomeView homeView;

    /**
     * Constructs a UserProfileView instance.
     *
     * @param homeView the home view instance to update the main content panel
     */
    public UserProfileView(HomeView homeView) {
        this.homeView = homeView;
    }

    /**
     * Displays the user profile details.
     *
     * @param userProfile the profile details to be displayed
     */
    public void displayUserProfile(UserProfile userProfile) {
        // Create a panel with BorderLayout
        JPanel profilePanel = new JPanel(new BorderLayout());

        // Create a panel for profile details with GridBagLayout
        JPanel profileDetailsPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // spacing around components
        gbc.anchor = GridBagConstraints.WEST; // left-align the labels

        // Add name label and value
        gbc.gridx = 0;
        gbc.gridy = 0;
        profileDetailsPanel.add(new JLabel("Name:"), gbc);

        gbc.gridx = 1;
        profileDetailsPanel.add(new JLabel(userProfile.getName()), gbc);

        // Add email label and value
        gbc.gridx = 0;
        gbc.gridy = 1;
        profileDetailsPanel.add(new JLabel("Email:"), gbc);

        gbc.gridx = 1;
        profileDetailsPanel.add(new JLabel(userProfile.getEmail()), gbc);

        // Add phone label and value
        gbc.gridx = 0;
        gbc.gridy = 2;
        profileDetailsPanel.add(new JLabel("Phone:"), gbc);

        gbc.gridx = 1;
        profileDetailsPanel.add(new JLabel(userProfile.getPhone()), gbc);

        // Add emergency contact label and value
        gbc.gridx = 0;
        gbc.gridy = 3;
        profileDetailsPanel.add(new JLabel("Emergency Contact:"), gbc);

        gbc.gridx = 1;
        profileDetailsPanel.add(new JLabel(userProfile.getEmergencyContact().getName()), gbc);

        // Add emergency contact phone label and value
        gbc.gridx = 0;
        gbc.gridy = 4;
        profileDetailsPanel.add(new JLabel("Emergency Contact Phone:"), gbc);

        gbc.gridx = 1;
        profileDetailsPanel.add(new JLabel(userProfile.getEmergencyContact().getPhone()), gbc);

        // Vertical spacing
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        profileDetailsPanel.add(Box.createVerticalStrut(15), gbc);

        // Add update info button
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.CENTER; // Center the button

        JButton updateInfoButton = new JButton("Update Info");
        updateInfoButton.setPreferredSize(new Dimension(160, 30));
        updateInfoButton.addActionListener(e -> displayEditableUserProfile(userProfile));

        profileDetailsPanel.add(updateInfoButton, gbc);

        profilePanel.add(profileDetailsPanel, BorderLayout.NORTH);

        // Add order history section with scroll pane
        JPanel orderHistoryPanel = new JPanel(new BorderLayout());
        JLabel orderHistoryLabel = new JLabel("Order History:");
        orderHistoryLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        orderHistoryPanel.add(orderHistoryLabel, BorderLayout.NORTH);

        DefaultListModel<String> orderListModel = new DefaultListModel<>();
        JList<String> orderList = new JList<>(orderListModel);
        for (String purchase : userProfile.getTicketPurchases()) {
            orderListModel.addElement(purchase);
        }
        JScrollPane scrollPane = new JScrollPane(orderList);
        scrollPane.setPreferredSize(new Dimension(400, 150));
        orderHistoryPanel.add(scrollPane, BorderLayout.CENTER);

        // Create a panel for the cancel button with FlowLayout to alter the size
        JPanel cancelButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        // Cancel button
        JButton cancelButton = new JButton("Cancel Purchase");
        cancelButton.setPreferredSize(new Dimension(160, 30));
        cancelButton.addActionListener(e -> {
            String selectedPurchase = orderList.getSelectedValue();
            if (selectedPurchase != null) {
                userProfile.removeTicketPurchase(selectedPurchase);
                homeView.getUserProfileManager().saveToFile();
                orderListModel.removeElement(selectedPurchase);
                JOptionPane.showMessageDialog(null, "Purchase canceled successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "Please select a purchase to cancel.");
            }
        });

        // Add the cancel button to a panel
        cancelButtonPanel.add(cancelButton);

        // Add new panel with the cancel button to the order history panel
        orderHistoryPanel.add(cancelButtonPanel, BorderLayout.SOUTH);

        profilePanel.add(orderHistoryPanel, BorderLayout.CENTER);

        // Panel for the back button to adjust its position
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20)); // Vertical padding

        // Adding back button
        JButton backButton = new JButton("Back");
        backButton.setPreferredSize(new Dimension(160, 30));
        backButton.addActionListener(e -> homeView.updateMainContentPanel(new JPanel()));
        buttonPanel.add(backButton);

        profilePanel.add(buttonPanel, BorderLayout.SOUTH);

        homeView.updateMainContentPanel(profilePanel);
    }

    /**
     * Displays the editable user profile details once the update button is clicked.
     *
     * @param userProfile the profile details to be displayed and edited
     */
    public void displayEditableUserProfile(UserProfile userProfile) {
        // Create a panel with BorderLayout
        JPanel profilePanel = new JPanel(new BorderLayout());

        // Create a panel for profile details with GridBagLayout
        JPanel profileDetailsPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // spacing around components
        gbc.anchor = GridBagConstraints.WEST; // left-align the labels

        // Add name label and value
        gbc.gridx = 0;
        gbc.gridy = 0;
        profileDetailsPanel.add(new JLabel("Name:"), gbc);

        gbc.gridx = 1;
        JTextField nameField = new JTextField(userProfile.getName(), 20);
        nameField.setEditable(false);
        profileDetailsPanel.add(nameField, gbc);

        // Add email label and text field
        gbc.gridx = 0;
        gbc.gridy = 1;
        profileDetailsPanel.add(new JLabel("Email:"), gbc);

        gbc.gridx = 1;
        JTextField emailField = new JTextField(userProfile.getEmail(), 20);
        profileDetailsPanel.add(emailField, gbc);

        // Add phone label and text field
        gbc.gridx = 0;
        gbc.gridy = 2;
        profileDetailsPanel.add(new JLabel("Phone:"), gbc);

        gbc.gridx = 1;
        JTextField phoneField = new JTextField(userProfile.getPhone(), 20);
        profileDetailsPanel.add(phoneField, gbc);

        // Add emergency contact name label and text field
        gbc.gridx = 0;
        gbc.gridy = 3;
        profileDetailsPanel.add(new JLabel("Emergency Contact:"), gbc);

        gbc.gridx = 1;
        JTextField emergencyContactNameField = new JTextField(userProfile.getEmergencyContact().getName(), 20);
        profileDetailsPanel.add(emergencyContactNameField, gbc);

        // Add emergency contact phone label and text field
        gbc.gridx = 0;
        gbc.gridy = 4;
        profileDetailsPanel.add(new JLabel("Emergency Contact Phone:"), gbc);

        gbc.gridx = 1;
        JTextField emergencyContactPhoneField = new JTextField(userProfile.getEmergencyContact().getPhone(), 20);
        profileDetailsPanel.add(emergencyContactPhoneField, gbc);

        // Vertical spacing
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        profileDetailsPanel.add(Box.createVerticalStrut(15), gbc);

        // Save button
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.CENTER;

        JButton saveButton = new JButton("Save");
        saveButton.setPreferredSize(new Dimension(160, 30));
        saveButton.addActionListener(e -> {
            userProfile.setEmail(emailField.getText());
            userProfile.setPhone(phoneField.getText());
            userProfile.getEmergencyContact().setName(emergencyContactNameField.getText());
            userProfile.getEmergencyContact().setPhone(emergencyContactPhoneField.getText());
            homeView.getUserProfileManager().saveToFile(); // Save changes
            displayUserProfile(userProfile); // Display the updated profile
            JOptionPane.showMessageDialog(null, "Profile updated successfully!");
        });

        profileDetailsPanel.add(saveButton, gbc);

        profilePanel.add(profileDetailsPanel, BorderLayout.CENTER);

        // Panel for the back button to adjust its position
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20)); // Vertical padding

        // Back button
        JButton backButton = new JButton("Back");
        backButton.setPreferredSize(new Dimension(160, 30));
        backButton.addActionListener(e -> displayUserProfile(userProfile));
        buttonPanel.add(backButton);

        profilePanel.add(buttonPanel, BorderLayout.SOUTH);

        homeView.updateMainContentPanel(profilePanel);
    }
}
