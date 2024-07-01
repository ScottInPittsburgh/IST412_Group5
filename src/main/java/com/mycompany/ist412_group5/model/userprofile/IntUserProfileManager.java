/**
 * Package provides classes and interfaces for managing user profiles.
 * Includes classes for creating, updating, and viewing user profile information.
 */
package com.mycompany.ist412_group5.model.userprofile;
/**
 *
 * @author Frank I
 */
public interface IntUserProfileManager {

    /**
     * Retrieves a user profile based on user ID.
     * @param userId The ID of the user.
     * @return The user profile.
     */
    UserProfile viewUserProfile(String userId);


    /**
     * Updates an emergency contact in a user profile.
     * @param userId The ID of the user.
     * @param contact The updated emergency contact details.
     * @return A confirmation message or error.
     */
    String updateEmergencyContact(String userId, EmergencyContact contact);

    UserProfile getUser();
}

