package com.mycompany.ist412_group5.controller;
/**
 *
 * @author Frank I
 */
import com.mycompany.ist412_group5.model.userprofile.IntUserProfileManager;
import com.mycompany.ist412_group5.model.userprofile.UserProfileManager;
import com.mycompany.ist412_group5.view.UserProfileView;
import com.mycompany.ist412_group5.model.userprofile.UserProfile;
import com.mycompany.ist412_group5.model.userprofile.EmergencyContact;

/**
 * Controller for managing User Profiles
 */
public class UserProfileController {
    private IntUserProfileManager userProfileManager;
    private UserProfileView userProfileView;

      /**
     * Construct new UserProfileController instance
     */
    public UserProfileController() {
        this.userProfileManager = new UserProfileManager();
        this.userProfileView = new UserProfileView();
    }

    /**
     * Views a user profile.
     * Retrieves the user profile from the manager and displays it using the view.
     */
    public void viewUserProfile() {
        String userId = userProfileView.promptForUserId();
        UserProfile userProfile = userProfileManager.viewUserProfile(userId);
        userProfileView.displayUserProfile(userProfile);
    }

    /**
     * Adds an emergency contact to a user profile.
     * Prompts for a user ID and emergency contact details, adds the contact
     * using the manager, and displays the result using the view.
     */
    public void addEmergencyContact() {
        String userId = userProfileView.promptForUserId();
        EmergencyContact contact = userProfileView.promptForEmergencyContact();
        String result = userProfileManager.addEmergencyContact(userId, contact);
        userProfileView.displayMessage(result);
    }

    /**
     * Updates an emergency contact in a user profile.
     * @param userId - user id
     * @param contact - updated emergency contact details
     * @return a confirmation message or error
     * Updates the contact using the manager and displays the result using the view.
     */
    public String updateEmergencyContact(String userId, EmergencyContact contact) {
        String result = userProfileManager.updateEmergencyContact(userId, contact);
        userProfileView.displayMessage(result);
        return result;
    }
}
