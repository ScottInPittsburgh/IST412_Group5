package com.mycompany.ist412_group5.view;

import com.mycompany.ist412_group5.model.userprofile.UserProfile;
import com.mycompany.ist412_group5.model.userprofile.EmergencyContact;

import javax.swing.*;
import java.awt.*;

/**
 * View - all user profile functions
 */
public class UserProfileView {

    private HomeView homeView;

    public UserProfileView(HomeView homeView) {
        this.homeView = homeView;
    }

    /**
     * Displays the user profile details.
     *
     * @param userProfile The profile details to be displayed.
     */
    public void displayUserProfile(UserProfile userProfile) {
        JPanel profilePanel = new JPanel(new BorderLayout());

        JPanel profileDetailsPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // spacing around components
        gbc.anchor = GridBagConstraints.WEST; // left-align the labels

        gbc.gridx = 0;
        gbc.gridy = 0;
        profileDetailsPanel.add(new JLabel("Name:"), gbc);

        gbc.gridx = 1;
        profileDetailsPanel.add(new JLabel(userProfile.getName()), gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        profileDetailsPanel.add(new JLabel("Email:"), gbc);

        gbc.gridx = 1;
        profileDetailsPanel.add(new JLabel(userProfile.getEmail()), gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        profileDetailsPanel.add(new JLabel("Phone:"), gbc);

        gbc.gridx = 1;
        profileDetailsPanel.add(new JLabel(userProfile.getPhone()), gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        profileDetailsPanel.add(new JLabel("Emergency Contact:"), gbc);

        gbc.gridx = 1;
        profileDetailsPanel.add(new JLabel(userProfile.getEmergencyContact().getName()), gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        profileDetailsPanel.add(new JLabel("Emergency Contact Phone:"), gbc);

        gbc.gridx = 1;
        profileDetailsPanel.add(new JLabel(userProfile.getEmergencyContact().getPhone()), gbc);

        // Add vertical spacing
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        profileDetailsPanel.add(Box.createVerticalStrut(15), gbc);

        // Adding update info button inside profile details panel
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.CENTER; // Center the button

        JButton updateInfoButton = new JButton("Update Info");
        updateInfoButton.setPreferredSize(new Dimension(160, 30)); // setting the size to match other buttons
        updateInfoButton.addActionListener(e -> displayEditableUserProfile(userProfile));

        profileDetailsPanel.add(updateInfoButton, gbc);

        profilePanel.add(profileDetailsPanel, BorderLayout.CENTER);

        // Panel for the back button to adjust its position
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20)); // Add vertical padding

        // Adding back button
        JButton backButton = new JButton("Back");
        backButton.setPreferredSize(new Dimension(160, 30)); // setting the size to match other buttons
        backButton.addActionListener(e -> homeView.updateMainContentPanel(new JPanel()));
        buttonPanel.add(backButton);

        profilePanel.add(buttonPanel, BorderLayout.SOUTH);

        homeView.updateMainContentPanel(profilePanel);
    }

    /**
     * Displays the editable user profile details once the update button is clicked.
     *
     * @param userProfile The profile details to be displayed and edited.
     */
    public void displayEditableUserProfile(UserProfile userProfile) {
        JPanel profilePanel = new JPanel(new BorderLayout());

        JPanel profileDetailsPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // spacing around components
        gbc.anchor = GridBagConstraints.WEST; // left-align the labels

        gbc.gridx = 0;
        gbc.gridy = 0;
        profileDetailsPanel.add(new JLabel("Name:"), gbc);

        gbc.gridx = 1;
        JTextField nameField = new JTextField(userProfile.getName(), 20);
        nameField.setEditable(false);
        profileDetailsPanel.add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        profileDetailsPanel.add(new JLabel("Email:"), gbc);

        gbc.gridx = 1;
        JTextField emailField = new JTextField(userProfile.getEmail(), 20);
        profileDetailsPanel.add(emailField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        profileDetailsPanel.add(new JLabel("Phone:"), gbc);

        gbc.gridx = 1;
        JTextField phoneField = new JTextField(userProfile.getPhone(), 20);
        profileDetailsPanel.add(phoneField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        profileDetailsPanel.add(new JLabel("Emergency Contact:"), gbc);

        gbc.gridx = 1;
        JTextField emergencyContactNameField = new JTextField(userProfile.getEmergencyContact().getName(), 20);
        profileDetailsPanel.add(emergencyContactNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        profileDetailsPanel.add(new JLabel("Emergency Contact Phone:"), gbc);

        gbc.gridx = 1;
        JTextField emergencyContactPhoneField = new JTextField(userProfile.getEmergencyContact().getPhone(), 20);
        profileDetailsPanel.add(emergencyContactPhoneField, gbc);

        // Add vertical spacing
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        profileDetailsPanel.add(Box.createVerticalStrut(15), gbc);

        // Adding save button inside profile details panel
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.CENTER; // Center the button

        JButton saveButton = new JButton("Save");
        saveButton.setPreferredSize(new Dimension(160, 30)); // setting the size to match other buttons
        saveButton.addActionListener(e -> {
            userProfile.setEmail(emailField.getText());
            userProfile.setPhone(phoneField.getText());
            userProfile.getEmergencyContact().setName(emergencyContactNameField.getText());
            userProfile.getEmergencyContact().setPhone(emergencyContactPhoneField.getText());
            homeView.getUserProfileManager().saveToFile(); // Save changes
            homeView.updateMainContentPanel(new JPanel()); // Navigate back
            JOptionPane.showMessageDialog(null, "Profile updated successfully!");
        });

        profileDetailsPanel.add(saveButton, gbc);

        profilePanel.add(profileDetailsPanel, BorderLayout.CENTER);

        // Panel for the back button to adjust its position
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20)); // Add vertical padding

        // Adding back button
        JButton backButton = new JButton("Back");
        backButton.setPreferredSize(new Dimension(160, 30)); // setting the size to match other buttons
        backButton.addActionListener(e -> displayUserProfile(userProfile));
        buttonPanel.add(backButton);

        profilePanel.add(buttonPanel, BorderLayout.SOUTH);

        homeView.updateMainContentPanel(profilePanel);
    }

    /**
     * Prompts the user to enter their user ID.
     *
     * @return The entered user ID.
     */
    public String promptForUserId() {
        return JOptionPane.showInputDialog("Enter User ID:");
    }

    /**
     * Prompts the user to enter emergency contact details.
     *
     * @return The entered emergency contact details.
     */
    public EmergencyContact promptForEmergencyContact() {
        JTextField nameField = new JTextField();
        JTextField phoneField = new JTextField();

        Object[] message = {
                "Name:", nameField,
                "Phone:", phoneField
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Enter Emergency Contact", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            EmergencyContact contact = new EmergencyContact();
            contact.setName(nameField.getText());
            contact.setPhone(phoneField.getText());
            return contact;
        } else {
            return null;
        }
    }

    /**
     * Displays a message to the user.
     *
     * @param message The message to be displayed.
     */
    public void displayMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }
}
