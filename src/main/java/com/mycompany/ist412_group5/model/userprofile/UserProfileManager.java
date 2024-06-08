package com.mycompany.ist412_group5.model.userprofile;
/**
 *
 * @author Frank I
 */
public class UserProfileManager implements IntUserProfileManager {

    /**
     * Retrieves and returns a user profile from the database.
     *
     * @param userId the ID of the user
     * @return the user profile
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

    /**
     * Adds an emergency contact to a user profile in the database.
     *
     * @param userId the ID of the user
     * @param contact the emergency contact details
     * @return a confirmation message or error
     */
    @Override
    public String addEmergencyContact(String userId, EmergencyContact contact) {
        // Logic to add an emergency contact to a user profile in the database
        return "Emergency contact added successfully";
    }

    /**
     * Updates an emergency contact in a user profile in the database.
     *
     * @param userId the ID of the user
     * @param contact the updated emergency contact details
     * @return a confirmation message or error
     */
    @Override
    public String updateEmergencyContact(String userId, EmergencyContact contact) {
        // Logic to update an emergency contact in a user profile in the database
        return "Emergency contact updated successfully";
    }
}
