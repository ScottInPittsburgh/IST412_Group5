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

public class UserProfileController {
    private IntUserProfileManager userProfileManager;
    private UserProfileView userProfileView;

    public UserProfileController() {
        this.userProfileManager = new UserProfileManager();
        this.userProfileView = new UserProfileView();
    }

    /**
     * Views a user profile.
     */
    public void viewUserProfile() {
        String userId = userProfileView.promptForUserId();
        UserProfile userProfile = userProfileManager.viewUserProfile(userId);
        userProfileView.displayUserProfile(userProfile);
    }

    /**
     * Adds an emergency contact to a user profile.
     */
    public void addEmergencyContact() {
        String userId = userProfileView.promptForUserId();
        EmergencyContact contact = userProfileView.promptForEmergencyContact();
        String result = userProfileManager.addEmergencyContact(userId, contact);
        userProfileView.displayMessage(result);
    }

    /**
     * Updates an emergency contact in a user profile.
     */
    public void updateEmergencyContact() {
        String userId = userProfileView.promptForUserId();
        EmergencyContact contact = userProfileView.promptForEmergencyContact();
        String result = userProfileManager.updateEmergencyContact(userId, contact);
        userProfileView.displayMessage(result);
    }
}
