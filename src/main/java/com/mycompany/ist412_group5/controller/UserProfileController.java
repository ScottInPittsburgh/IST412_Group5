package com.mycompany.ist412_group5.controller;

import com.mycompany.ist412_group5.model.userprofile.IntUserProfileManager;
import com.mycompany.ist412_group5.model.userprofile.UserProfileManager;
import com.mycompany.ist412_group5.view.UserProfileView;

public class UserProfileController {
    private IntUserProfileManager userProfileManager;
    private UserProfileView userProfileView;

    public UserProfileController() {
        this.userProfileManager = new UserProfileManager();
        this.userProfileView = new UserProfileView();
    }

    public void exampleUserProfileMethod() {
        userProfileManager.exampleUserProfileMethod();
        userProfileView.showUserProfile();
    }
}
