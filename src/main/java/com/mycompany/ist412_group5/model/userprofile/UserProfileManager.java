package com.mycompany.ist412_group5.model.userprofile;

public class UserProfileManager implements IntUserProfileManager {
    /**
     *
     * @author Frank Imbrunone
     */
    @Override
    public UserProfile viewUserProfile(String userId) {
        // Logic to retrieve and return a user profile from the database
        UserProfile userProfile = new UserProfile();
        userProfile.setName("Displays name...");
        userProfile.setEmail("Displays email address..");
        userProfile.setPhone("Displays phone number...");
        userProfile.setEmergencyContact("Displays emergency contact info...");
        return userProfile;
    }

    @Override
    public String addEmergencyContact(String userId, EmergencyContact contact) {
        // Logic to add an emergency contact to a user profile in the database
        return "Emergency contact added successfully";
    }

    @Override
    public String updateEmergencyContact(String userId, EmergencyContact contact) {
        // Logic to update an emergency contact in a user profile in the database
        return "Emergency contact updated successfully";
    }
}
