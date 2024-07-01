package com.mycompany.ist412_group5.controller;

import com.mycompany.ist412_group5.model.userprofile.IntUserProfileManager;
import com.mycompany.ist412_group5.model.userprofile.UserProfileManager;
import com.mycompany.ist412_group5.view.UserProfileView;
import com.mycompany.ist412_group5.model.userprofile.UserProfile;
import com.mycompany.ist412_group5.model.userprofile.EmergencyContact;
import com.mycompany.ist412_group5.view.HomeView;

/**
 * Controller for managing User Profiles
 */
public class UserProfileController {

    private IntUserProfileManager userProfileManager;
    private UserProfileView userProfileView;

    /**
     * Construct new UserProfileController instance
     *
     * @param homeView           The HomeView instance to update the main content panel
     * @param userProfileManager The UserProfileManager instance to manage user profiles
     */
    public UserProfileController(HomeView homeView, UserProfileManager userProfileManager) {
        this.userProfileManager = userProfileManager;
        this.userProfileView = new UserProfileView(homeView);
    }

    /**
     * Views a user profile.
     * Retrieves the user profile from the manager and displays it using the view.
     */
    public void viewUserProfile() {
        UserProfile userProfile = userProfileManager.getUser();
        userProfileView.displayUserProfile(userProfile);
    }

}