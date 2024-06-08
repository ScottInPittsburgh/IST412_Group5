package com.mycompany.ist412_group5.model.userprofile;
/**
 *
 * @author Frank Imbrunone
 */
public interface IntUserProfileManager {

    /**
     * Retrieves a user profile based on user ID.
     * @param userId The ID of the user.
     * @return The user profile.
     */
    UserProfile viewUserProfile(String userId);

    /**
     * Adds an emergency contact to a user profile.
     * @param userId The ID of the user.
     * @param contact The emergency contact details.
     * @return A confirmation message or error.
     */
    String addEmergencyContact(String userId, EmergencyContact contact);

    /**
     * Updates an emergency contact in a user profile.
     * @param userId The ID of the user.
     * @param contact The updated emergency contact details.
     * @return A confirmation message or error.
     */
    String updateEmergencyContact(String userId, EmergencyContact contact);
}

